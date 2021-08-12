const authorizeElem = document.getElementById('authorize');
let currentPage = document.getElementById('currentPage');
const adminAuth = document.getElementById('loginAdmin').dataset.authno;

//유저 리스트
function getUserList(authorize, page, searchText) {
    fetch('/admin/user/list', {
        method: 'POST',
        body: JSON.stringify({
            authorize: authorize,
            page: page,
            searchText: searchText
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
            currentPage = data.paging.page;
            pagination(data.paging);
            makeList(data.userList);
        });
}

const searchTextElem = document.getElementById('searchText');
searchTextElem.addEventListener('change', () => {
    getUserList(authorizeElem.value, 1, searchTextElem.value);
});

authorizeElem.addEventListener('change', () => {
    getUserList(authorizeElem.value, 1, searchTextElem.value);
});

console.log(adminAuth);

function makeList(item) {
    const tableElem = document.getElementById('datatablesSimple');
    const tbodyElem = tableElem.querySelector('tbody');
    tbodyElem.innerText = '';

    item.forEach((item) => {
        const trElem = document.createElement('tr');
        const noElem = document.createElement('td');
        const idElem = document.createElement('td');
        const nmElem = document.createElement('td');
        const authElem = document.createElement('td');
        const emailElem = document.createElement('td');
        const regdateElem = document.createElement('td');
        const etcElem = document.createElement('td');
        const etcBtnElem = document.createElement('button');
        const adminBtnElem = document.createElement('button');

        etcElem.classList.add('list-etc');
        etcBtnElem.className = 'btn btn-secondary';
        adminBtnElem.className = 'btn btn-secondary';

        let authVal = 0;
        let adminAuthVal = 0;
        let alertMsg = '';
        switch (item.authno) {
            case 2:
                adminBtnElem.innerText = '관리자 해제';
                adminAuthVal = 3;
                alertMsg = '해당 유저를 일반유저로 변경하시겠습니까?';
                etcElem.append(adminBtnElem);
                break;
            case 3:
                etcBtnElem.innerText = '차단';
                authVal = 5;
                alertMsg = '해당 유저를 차단 상태로 변경하시겠습니까?'
                if (adminAuth == 1) {
                    adminBtnElem.innerText = '관리자 지정';
                    adminAuthVal = 2;
                    alertMsg = '해당 유저를 관리자로 변경하시겠습니까?';
                    etcElem.append(adminBtnElem);
                    break;
                }
                break;
            case 4:
                etcBtnElem.innerText = '인증';
                authVal = 3;
                alertMsg = '해당 유저를 인증 상태로 변경하시겠습니까?';
                break;
            case 5:
                etcBtnElem.innerText = '차단해제';
                authVal = 3;
                alertMsg = '해당 유저를 차단 해제 상태로 변경하시겠습니까?';
                break;
        }

        etcBtnElem.addEventListener('click', () => {
            if (authVal !== 0) {
                if (confirm(alertMsg)) {
                    updUserAuthorize(item.uno, authVal);
                }
            } else {
                alert('잘못된 접근입니다.');
            }
        });
        adminBtnElem.addEventListener('click', () => {
            if (adminAuthVal !== 0) {
                if (confirm(alertMsg)) {
                    updUserAuthorize(item.uno, adminAuthVal);
                }
            } else {
                alert('잘못된 접근입니다.');
            }
        });
        if (authorizeElem.value !== 'admin') {
            etcElem.append(etcBtnElem);
        }

        noElem.innerText = item.uno;
        idElem.innerText = item.uid;
        nmElem.innerText = item.unm;
        authElem.innerText = item.authnm;
        emailElem.innerText = item.uemail;
        regdateElem.innerText = item.urdt;

        trElem.append(noElem);
        trElem.append(idElem);
        trElem.append(nmElem);
        trElem.append(emailElem);
        trElem.append(regdateElem);
        trElem.append(authElem);
        trElem.append(etcElem);
        tbodyElem.append(trElem);
    });
}

const paginationElem = document.getElementById('pagination');

function pagination(data) {
    paginationElem.innerText = '';
    const pageBoxElem = document.createElement('ul');
    pageBoxElem.classList.add('pagination-list');

    for (let i = data.startPage; i <= data.endPage; i++) {
        const pageNumElem = document.createElement('li');
        pageNumElem.innerText = i;
        if (data.curPage === i) {
            pageNumElem.classList.add('active');
        }
        pageNumElem.addEventListener('click', () => {
            getUserList(authorizeElem.value, i, searchTextElem.value);
        });
        pageBoxElem.append(pageNumElem);
    }
    paginationElem.append(pageBoxElem);
}

function updUserAuthorize(uno, authno) {
    fetch('/admin/user', {
        method: 'PATCH',
        body: JSON.stringify({
            uno: uno,
            authno: authno
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
                alert('잘못된 접근입니다.');
            } else {
                getUserList(authorizeElem.value, currentPage, searchTextElem.value);
            }
        });
}

getUserList(null, 1, null);
