const params = new URLSearchParams(location.search);
const bcdVal = params.get('bcd');
const pageVal = params.get('page');
const searchTypeVal = params.get('searchType');
const searchTextVal = params.get('searchText');

getNoticeList();

// 공지사항 리스트
function getNoticeList() {
    //TODO: 공지사항 만들기
    fetch('/board/notice/' + bcdVal)
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            makeNoticeList(data);
        });
}

function makeNoticeList(data) {

}

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