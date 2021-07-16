const params = new URLSearchParams(location.search);
const bnoVal = params.get('bno');
const regBtn = document.getElementById('insBtn');
let replyListElem = document.getElementById('replyList');

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
    regAjax(param);
    repFrmElem.reset();
}

function regAjax(param) {
    const init = {
        method: 'POST',
        body: JSON.stringify(param),
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json;charset=UTF-8'
        }
    };

    fetch('reply/0', init)
        .then((res) => {
            return res.json();
        })
        .then((myJson) => {
            if (myJson.result == 1) {
                getListAjax();
            } else {
                //등록실패
                alert('에러!');
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
        })
}

function makeReplyList(data) {
    replyListElem.innerHTML = '';
    let ulElem = document.createElement('ul');

    replyListElem.append(ulElem);

    const loginUserPk = replyListElem.dataset.userPk;

    data.forEach((item) => {
        let liElem = document.createElement('li');
        let repElem1 = document.createElement('span');
        let repElem2 = document.createElement('span');
        let repElem3 = document.createElement('span');
        let repElem4 = document.createElement('span');
        repElem1.innerText = item.repctnt;
        repElem2.append(item.repnm);
        repElem3.append(item.reprdt);
        if (parseInt(loginUserPk) === item.uno || item.uno === 0) {
            const delBtn = document.createElement('button');
            const repBtn = document.createElement('button');
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
            // 답글버튼
            liElem.addEventListener('click', () => {
                liElem.classList.toggle("reReply");


                const formElem = document.createElement('form');
                const inputRepnm = document.createElement('input');
                const inputReppw = document.createElement('input');
                const txtRepctnt = document.createElement('textarea');
                const inputReBtn = document.createElement('input');

                formElem.onsubmit = 'return false;';
                formElem.id='reReplyFrm'+item.repno;
                inputRepnm.type = 'text';
                inputReppw.type = 'password';
                inputReBtn.type = 'button';
                inputReBtn.value = '작성';
                if(liElem.className === "reReply"){
                    formElem.append(inputRepnm);
                    formElem.append(inputReppw);
                    formElem.append(txtRepctnt);
                    formElem.append(inputReBtn);
                    liElem.append(formElem);
                }else {
                    document.getElementById('reReplyFrm'+item.repno).remove();
                }
            });

            delBtn.innerText = '삭제';
            repBtn.innerText = '답글';

            repElem4.append(delBtn);
            repElem4.append(repBtn);
        }
        ulElem.append(liElem);
        liElem.append(repElem1);
        liElem.append(repElem2);
        liElem.append(repElem3);
        liElem.append(repElem4);


    });
}

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

//추천
// const upRecBtn = document.getElementById('upRecBtn');
// const downRecBtn = document.getElementById('downRecBtn');
// // data로 bno 받아야함
// upRecBtn.addEventListener('click',regRec(1));
// downRecBtn.addEventListener('click',delRec(2))
// function regRec(btnIdx){
//
//     fetch()
// }
