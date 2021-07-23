


getTags();

let tags = new Object();
let array = new Array();

const param = {
    tags: tags
};

function getBoardList() {
    console.log(JSON.stringify(param));
    /*TODO: 07.23 마무리
    GET 메소드로는 body를 보낼수 없음.
    그래서 POST로 변경

    */

    fetch('/admin/board', {
        method: 'POST',
        body: JSON.stringify(param),
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json;charset=UTF-8'
        }
    })
        .then((res)=>{
            return res.json();
        })
        .then((data)=>{
            console.log(data);
        })
}

getBoardList();

function regTag() { // 태그를 등록하는 ajax 함수
    const tnameElem = document.getElementById('tname');
    const tnameVal = tnameElem.value;

    fetch('/admin/tag', {
        method: 'POST',
        body: JSON.stringify({
            tname: tnameVal
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
            getTags();
        });
}

function getTags() { // 태그 가져오기
    fetch('/admin/tag')
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            data.forEach((item)=>{
                tags
            })
        })
}



function delTag(tno) { // 태그삭제
    fetch('/admin/tag/' + tno, {
        method: 'DELETE'
    })
        .then((res) => {
            return res.json();
        })
        .then((data)=>{
            getTags();
        })
}
getCategoryList();
function getCategoryList(){
    fetch('/admin/category')
        .then((res)=>{
            return res.json();
        })
        .then((data)=>{
            for (let i=0; i<data.length; i++){
            }
        })
}
// 카테고리 등록
function regCategory(){
    categoryVal = document.getElementById('category').value;

    fetch('/admin/category', {
        method: 'POST',
        body: JSON.stringify({
            bnm: 'test',
            cord: '5'
        }),
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json;charset=UTF-8'
        }
    })
        .then((res)=>{
            return res.json();
        })
        .then((data)=>{
        })
}