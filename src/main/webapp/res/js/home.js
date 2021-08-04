const todayBest = document.querySelector('.todayBest');
const weekendBest = document.querySelector('.weekendBest');
const notice = document.querySelector('.notice');
const miniBoard = document.querySelector('.miniBoard');

getTodayRecList();
getWeekendRecList();
getNoticeList();
getCategoryList();

// 일간 인기글 리스트
function getTodayRecList() {
    fetch('/board/rec/today')
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            makeList(data, todayBest);
        });
}

// 주간 인기글 리스트
function getWeekendRecList() {
    fetch('/board/rec/weekend')
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            makeList(data, weekendBest);
        });
}

// 공지사항
function getNoticeList() {
    fetch('/board/notice/1')
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            makeList(data, notice);
        });
}

// 카테고리 리스트
function getCategoryList() {
    fetch('/admin/category')
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            data.result.forEach((item) => {
                const board = document.createElement('div');
                board.classList.add('board');
                board.innerText = item.bnm;
                miniBoard.append(board);
                getBoardList(item, board);
            })
        });
}

function getBoardList(item, board) {
    fetch('/board/mainList/' + item.bcd)
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            makeList(data.board, board);
        });
}

function makeList(data, menu) {
    const ulElem = document.createElement('ol');
    const menuHeaderElem = document.createElement('li');
    const headerTitleElem = document.createElement('div');
    const headerRecElem = document.createElement('div');
    const headerCategoryElem = document.createElement('div');
    const headerRegdateElem = document.createElement('div');

    menuHeaderElem.setAttribute('class','rankTable');
    headerTitleElem.innerText = '제목';
    headerRecElem.innerText = '추천';
    headerCategoryElem.innerText = '게시판';
    headerRegdateElem.innerText = '작성일';

    menu.append(ulElem);
    ulElem.append(menuHeaderElem);
    menuHeaderElem.append(headerTitleElem);
    menuHeaderElem.append(headerRecElem);
    menuHeaderElem.append(headerCategoryElem);
    menuHeaderElem.append(headerRegdateElem);

    data.forEach((item) => {
        const listElem = document.createElement('li');
        const titleElem = document.createElement('div');
        const recElem = document.createElement('div');
        const categoryElem = document.createElement('div');
        const regdateElem = document.createElement('div');

        let regDate = item.brdt;
        const date = new Date(item.brdt);

        if (menu.className === 'todayBest' || menu.className === 'board') {
            const hours = ('0' + date.getHours()).slice(-2);
            const minutes = ('0' + date.getMinutes()).slice(-2);
            regDate = hours + ':' + minutes;
        } else if (menu.className === 'weekendBest' || menu.className === 'notice') {
            const month = ('0' + (date.getMonth() + 1)).slice(-2);
            const day = ('0' + date.getDate()).slice(-2);
            regDate = month + '.' + day;
        }

        titleElem.innerText = item.btitle;
        recElem.innerText = item.rec;
        categoryElem.innerText = item.bnm;
        regdateElem.innerText = regDate;

        listElem.append(titleElem);
        listElem.append(recElem);
        listElem.append(categoryElem);
        listElem.append(regdateElem);
        ulElem.append(listElem);

    })
}