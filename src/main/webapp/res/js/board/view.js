const params = new URLSearchParams(location.search);
const bnoVal = params.get('bno');
const regBtn = document.getElementById('insBtn');
let replyListElem = document.getElementById('replyList');

regBtn.addEventListener('click', regReply);

// INSERT

function regReply(){
    const repnmElem = document.getElementById('repnm');
    const reppwElem = document.getElementById('reppw');
    const repctntElem = document.getElementById('repctnt');

    let repnmVal = null;
    let reppwVal = null;
    if(repnmElem != null){
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
}
function regAjax(param){
    const init = {
        method: 'POST',
        body: JSON.stringify(param),
        headers:{
            'accept' : 'application/json',
            'content-type' : 'application/json;charset=UTF-8'
        }
    };

    fetch('reply/0',init)
        .then((res) =>{
            return res.json();
        })
        .then((myJson) =>{
            console.log(myJson);
            if(myJson.result == 1){
                console.log('등록성공');
                getListAjax();
            }else{
                //등록실패
                alert('에러!');
            }
        });
}

// SELECT
function getListAjax(){
    fetch('reply/'+bnoVal)
        .then((res)=>{
            return res.json();
        })
        .then((myJson)=>{
            makeReplyList(myJson);
        })
}
function makeReplyList(data){
    replyListElem.innerHTML = '';
    let tableElem = document.createElement('table');
    let trRepTitle = document.createElement('tr');
    let thRepCtnt = document.createElement('th');
    let thRepNm = document.createElement('th');
    let thRepRdt = document.createElement('th');
    let thRepBigo = document.createElement('th');


    thRepCtnt.innerText = '내용';
    thRepNm.innerText = '작성자';
    thRepRdt.innerText = '작성일';
    thRepBigo.innerText = '비고';

    trRepTitle.append(thRepCtnt);
    trRepTitle.append(thRepNm);
    trRepTitle.append(thRepRdt);
    trRepTitle.append(thRepBigo);

    tableElem.append(trRepTitle);
    replyListElem.append(tableElem);

    const loginUserPk = replyListElem.dataset.userPk;

    data.forEach((item)=>{
        let trElemCtnt = document.createElement('tr');
        let tdElem1 = document.createElement('td');
        let tdElem2 = document.createElement('td');
        let tdElem3 = document.createElement('td');
        let tdElem4 = document.createElement('td');

        tdElem1.innerText = item.repctnt;
        tdElem2.append(item.repnm);
        tdElem3.append(item.reprdt);

        if(parseInt(loginUserPk) === item.uno || item.uno === 0) {
            const delBtn = document.createElement('button');
            const modBtn = document.createElement('button');

            //삭제버튼 클릭시
            delBtn.addEventListener('click', ()=> {
                if (parseInt(loginUserPk) === item.uno) {
                    alert(confirm())
                    var param = {repno: item.repno};
                    delAjax(param);
                }else{
                    let promptPw = parseInt(prompt("비밀번호를 입력하세요"));
                    var param = {
                        repno: item.repno,
                        reppw: promptPw
                    };
                    delAjax(param);
                }
            });
            //수정버튼 클릭시
            modBtn.addEventListener('click', ()=> {
                //수정창 띄우기
            });
            //TODO:답글창 만들기 table 안에서 form 못만듬 댓글리스트 table 말고 div로 변경필요 프론트 작업이니 미뤄두기

            delBtn.innerText = '삭제';
            modBtn.innerText = '수정';


            tdElem4.append(delBtn);
            tdElem4.append(modBtn);

        }
        const repBtn = document.createElement('button');
        repBtn.innerText = '답글';
        tdElem4.append(repBtn);

        trElemCtnt.append(tdElem1);
        trElemCtnt.append(tdElem2);
        trElemCtnt.append(tdElem3);
        trElemCtnt.append(tdElem4);

        tableElem.append(trElemCtnt);
    });
}

function delAjax(param){
    const init = {
        method: 'DELETE',
        body: JSON.stringify(param),
        headers:{
            'accept' : 'application/json',
            'content-type' : 'application/json;charset=UTF-8'
        }
    };

    fetch('reply', init)
        .then((res)=>{
            return res.json();
        })
        .then((myJson)=>{
            switch(myJson.result) {
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