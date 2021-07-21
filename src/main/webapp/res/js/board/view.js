const params = new URLSearchParams(location.search);
const bnoVal = params.get('bno');
const regBtn = document.getElementById('insBtn');
let replyListElem = document.getElementById('replyList');
const loginUserPk = replyListElem.dataset.userPk;
regBtn.addEventListener('click', regReply);

// 댓글등록
function regReply() {
    const repFrmElem = document.getElementById("repFrm");
    const repnmElem = document.getElementById('repnm');
    const reppwElem = document.getElementById('reppw');
    const repctntElem = document.getElementById('repctnt');

    let repnmVal = null;
    let reppwVal = null;
    if (repnmElem != null) {
        repnmVal = repnmElem.value;
        reppwVal = reppwElem.value;
    }
    const param = {
        bno: bnoVal,
        repnm: repnmVal,
        reppw: reppwVal,
        repctnt: repctntElem.value
    };
    regAjax(param, 0);
    repFrmElem.reset();
}

function regAjax(param, idx) {
    if (isNaN(parseInt(loginUserPk)) && param.reppw === '') {
        alert('비밀번호를 입력해주세요.');
        return;
    } else if (isNaN(parseInt(loginUserPk)) && param.repnm === '') {
        alert('아이디를 입력해주세요.');
        return;
    } else if (param.repctnt === '') {
        alert('내용을 입력해주세요.');
        return;
    }

    const init = {
        method: 'POST',
        body: JSON.stringify(param),
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json;charset=UTF-8'
        }
    };

    fetch('reply/' + idx, init)
        .then((res) => {
            return res.json();
        })
        .then((myJson) => {
            if (myJson.result == 1) {
                getListAjax();
            } else {
                //등록실패
                alert('등록 실패.');
            }
        });
}

// 댓글리스트
function getListAjax() {
    fetch('reply/' + bnoVal)
        .then((res) => {
            return res.json();
        })
        .then((myJson) => {
            makeReplyList(myJson);
        });
}

//리스트 만들기
function makeReplyList(data) {
    replyListElem.innerHTML = '';
    let ulElem = document.createElement('ul');

    replyListElem.append(ulElem);


    data.forEach((item) => {
        let liElem = document.createElement('li');
        let repElem1 = document.createElement('div');
        let repElem2 = document.createElement('div');
        let repElem3 = document.createElement('div');
        let repElem4 = document.createElement('div');
        repElem1.append(item.repnm);
        repElem2.append(item.repctnt);
        repElem3.append(item.reprdt);
        // 자기 댓글이거나 익명댓글인 경우 삭제 버튼 만들어주기
        if (parseInt(loginUserPk) === item.uno || item.uno === 0) {
            const delBtn = document.createElement('button');
            let promptPw = null;

            //삭제버튼 클릭시
            delBtn.addEventListener('click', () => {
                if (confirm('삭제하시겠습니까?')) {
                    if (item.uno === 0) {
                        promptPw = parseInt(prompt("비밀번호를 입력하세요"));
                    }
                    const param = {
                        repno: item.repno,
                        reppw: promptPw
                    };
                    delAjax(param);
                } else {
                    return;
                }
            });

            // 답글버튼 - 댓글 내용 클릭 시 댓글밑에 생성
            repElem2.addEventListener('click', () => {
                liElem.classList.toggle("reReply");

                const formElem = document.createElement('form');
                const inputRepnm = document.createElement('input');
                const inputReppw = document.createElement('input');
                const txtRepctnt = document.createElement('textarea');
                const inputReBtn = document.createElement('input');

                formElem.onsubmit = 'return false;';
                formElem.id = 'reReplyFrm' + item.repno;
                inputRepnm.type = 'text';
                inputRepnm.classList.add('reRepName');
                inputReppw.type = 'password';
                inputReppw.classList.add('reRepPwd');
                txtRepctnt.classList.add('reRepCtnt');
                inputReBtn.type = 'button';
                inputReBtn.value = '작성';

                /*
                댓글 클릭했을때 liElem에 'reReply'클래스 추가해줌
                'reReply' 클래스가 있으면 대댓글창 생성 없으면 삭제
                */
                if (liElem.className === "reReply") {
                    if (isNaN(parseInt(loginUserPk))) {
                        formElem.append(inputRepnm);
                        formElem.append(inputReppw);
                    }
                    formElem.append(txtRepctnt);
                    formElem.append(inputReBtn);
                    liElem.append(formElem);
                } else {
                    document.getElementById('reReplyFrm' + item.repno).remove();
                }

                // 답글 전송버튼 눌렀을떄
                inputReBtn.addEventListener('click', () => {
                    let reRepFrm = document.getElementById('reReplyFrm' + item.repno);
                    let reRepName = null;
                    let reRepPwd = null;
                    let reRepCtnt = null;
                    // if (parseInt(loginUserPk) !== 0) {
                    //     reRepName = reRepFrm.querySelector('.reRepName').value;
                    //     reRepPwd = reRepFrm.querySelector('.reRepPwd').value;
                    //     reRepCtnt = reRepFrm.querySelector('.reRepCtnt').value;
                    // }
                    const param = {
                        bno: bnoVal,
                        repnm: reRepName,
                        reppw: reRepPwd,
                        repctnt: reRepCtnt,
                        repidx: item.repidx,
                        repord: item.repord,
                        repdept: item.repdept
                    }
                    regAjax(param, 1);
                    console.log(param);
                })
            });

            delBtn.innerText = '삭제';
            repElem4.append(delBtn);
        }
        ulElem.append(liElem);
        liElem.append(repElem1);
        liElem.append(repElem2);
        liElem.append(repElem3);
        liElem.append(repElem4);
    });
}

// 댓글 삭제
function delAjax(param) {
    const init = {
        method: 'DELETE',
        body: JSON.stringify(param),
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json;charset=UTF-8'
        }
    };

    fetch('reply', init)
        .then((res) => {
            return res.json();
        })
        .then((myJson) => {
            switch (myJson.result) {
                case 0:
                    alert('잘못된 비밀번호입니다.');
                    break;
                case 1:
                    getListAjax();
                    break;
            }
        });
}

getListAjax();
getRec(bnoVal);

//게시글 추천
const upRecBtn = document.getElementById('upRecBtn');
const downRecBtn = document.getElementById('downRecBtn');

upRecBtn.addEventListener('click', () => {
    recClicked(1, upRecBtn.className);
});
downRecBtn.addEventListener('click', () => {
    recClicked(0, downRecBtn.className);
});

function recClicked(recVal, btnClassName) {
    if (upRecBtn.className !== 'clicked' && downRecBtn.className !== 'clicked') {
        regRec(recVal);
    } else if (btnClassName === 'clicked') {
        delRec();
    } else {
        alert('이미 추천한 게시글입니다.')
    }
}


// 추천수
function getRec(bno) {
    const upCntElem = document.getElementById('cntUp');
    const downCntElem = document.getElementById('cntDown');
    fetch('/board/rec/' + bno)
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            upCntElem.innerText = '';
            downCntElem.innerText = '';
            for (var i = 0; i < data.result.length; i++) {
                if (data.result[i].rec === 1) {
                    upCntElem.innerText = data.result[i].cnt;
                } else if (data.result[i].rec === 0) {
                    downCntElem.innerText = data.result[i].cnt;
                }
            }

            if (data.recCheck !== null && data.recCheck.recChk === 1) {
                toggleRec(data.recCheck.rec);
            } else {
                toggleRec(2);
            }
        });
}

function toggleRec(toggle) {
    switch (toggle) {
        case 0:
            downRecBtn.classList.add('clicked');
            break;
        case 1:
            upRecBtn.classList.add('clicked');
            break;
        case 2:
            downRecBtn.classList.remove('clicked');
            upRecBtn.classList.remove('clicked');
    }
}

// 추천, 비추천
function regRec(recVal) {
    fetch('/board/rec', {
        method: 'POST',
        body: JSON.stringify({
            bno: bnoVal,
            rec: recVal
        }),
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json;charset=UTF-8'
        }
    })
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            if (data.result === 0) {
                alert('로그인을 해주세요');  //로그인 필요
            }
            getRec(bnoVal);
        });
}

// 추천,비추천 해제
function delRec() {
    fetch('/board/rec/' + bnoVal, {
        method: 'DELETE'
    })
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            if (data.result === 0) {
                alert('잘못된 접근입니다.');
            }
            getRec(bnoVal);
        })
}