function makeUl(count, pk) {
    let targets = document.getElementById(count);

    targets.classList.toggle('userId');

    let divElem = document.createElement('div');
    let ulElem = document.createElement('ul');
    let liWhatWriteElem = document.createElement('li');
    let liWhatReplElem = document.createElement('li');
    let liWhoElem = document.createElement('li');
    let aTagElemPrf = document.createElement('a');
    let aTagElemWhatWrt = document.createElement('a');
    let aTagElemRep = document.createElement('a');
    // let userPk = document.getElementById('userPk').value;

    aTagElemPrf.innerText = '프로필';
    aTagElemWhatWrt.innerText = '작성글';
    aTagElemRep.innerText = '댓글';
    if (targets.className === 'userId') {
        divElem.append(ulElem);

        ulElem.append(liWhoElem);
        ulElem.append(liWhatWriteElem);
        ulElem.append(liWhatReplElem);

        liWhoElem.append(aTagElemPrf);
        liWhatWriteElem.append(aTagElemWhatWrt);
        liWhatReplElem.append(aTagElemRep);

        divElem.setAttribute('id', 'info' + count);
        divElem.setAttribute('class', 'infoUser');
        aTagElemPrf.setAttribute('href', '/user/info?uno=' + pk);
        aTagElemWhatWrt.setAttribute('href', '/user/info?uno=' + pk);
        aTagElemRep.setAttribute('href', '/user/info?uno=' + pk);

        targets.append(divElem);

    } else {
        document.getElementById('info' + count).remove();
    }
}

const params = new URLSearchParams(location.search);
const bcdVal = params.get('bcd');
const pageVal = params.get('page');
const searchTypeVal = params.get('searchType');
const searchTextVal = params.get('searchText');
const noticeBodyElem = document.querySelector('.notice');

getNoticeList();

// 공지사항 리스트 가져오기
function getNoticeList() {
    fetch('/board/notice/' + bcdVal)
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            makeNoticeList(data);
        });
}

// 공지사항 리스트 생성
function makeNoticeList(data) {

    data.forEach((item) => {
        const noticeElem = document.createElement('tr');
        const bnoElem = document.createElement('td');
        const btitleElem = document.createElement('td');
        const writerElem = document.createElement('td');
        const brdtElem = document.createElement('td');
        const bhitElem = document.createElement('td');
        const recElem = document.createElement('td');

        noticeElem.classList.add('boardClick');

        bnoElem.append(item.bno);
        btitleElem.append(item.btitle);
        writerElem.append(item.writer);
        brdtElem.append(item.brdt);
        bhitElem.append(item.bhit);
        recElem.append(item.rec);

        noticeBodyElem.append(noticeElem);
        noticeElem.append(bnoElem);
        noticeElem.append(btitleElem);
        noticeElem.append(writerElem);
        noticeElem.append(brdtElem);
        noticeElem.append(bhitElem);
        noticeElem.append(recElem);
    });
}

// 게시글 검색
const searchType = document.getElementById('searchType');
const searchText = document.getElementById('searchText');
document.getElementById('searchBtn').addEventListener('click', () => {

    if (pageVal === null) {
        location.href = "/board/list?bcd=" + bcdVal
            + "&searchType=" + searchType.value
            + "&searchText=" + searchText.value;
    } else {
        location.href = "/board/list?bcd=" + bcdVal + "&page=" + pageVal
            + "&searchType=" + searchType.value + "&searchText=" + searchText.value;
    }
});

// 페이지 이동
function moveToPage(bcd, page) {
    let url = "/board/list?bcd=" + bcd
    if (searchTextVal === null) {
        location.href = url + "&page=" + page;
    } else {
        location.href = url + "&page=" + page
            + "&searchType=" + searchTypeVal
            + "&searchText=" + searchTextVal;
    }
}

if(searchTypeVal !== null && searchTextVal !== null){
    searchType.value = searchTypeVal;
    searchText.value = searchTextVal;
}