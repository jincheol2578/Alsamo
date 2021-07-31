/*--------------BoardList-----------------*/
// 게시글 가져오기
const paginationElem = document.getElementById('pagination');

function getBoardList(page) {

    fetch('/admin/board', {
        method: 'POST',
        body: JSON.stringify({
            bcd: 1,
            page: page
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
            const tableElem = document.getElementById('datatablesSimple');

            const tbodyElem = tableElem.querySelector('tbody');


            paginationElem.innerText = '';
            pagination(data.paging);

            tbodyElem.innerText = '';

            data.boardList.forEach((item) => {
                const trElem = document.createElement('tr');
                const chkBoxElem = document.createElement('td');
                const bnoElem = document.createElement('td');
                const writerElem = document.createElement('td');
                const btitleElem = document.createElement('td');
                const hitElem = document.createElement('td');
                const recElem = document.createElement('td');
                const brdtElem = document.createElement('td');

                const labelElem = document.createElement('label');

                const delBox = document.createElement('input');
                delBox.type = 'checkbox';
                delBox.value = item.bno;
                delBox.name = 'delChk';
                labelElem.append(delBox);
                chkBoxElem.append(labelElem);

                bnoElem.innerText = item.bno;
                writerElem.innerText = item.writer;
                btitleElem.innerText = item.btitle;
                hitElem.innerText = item.bhit;
                recElem.innerText = item.rec;
                brdtElem.innerText = item.brdt;

                trElem.append(chkBoxElem);
                trElem.append(bnoElem);
                trElem.append(writerElem);
                trElem.append(btitleElem);
                trElem.append(hitElem);
                trElem.append(recElem);
                trElem.append(brdtElem);
                tbodyElem.append(trElem);
            });
        });
}

// 페이징
function pagination(data) {
    const pageBoxElem = document.createElement('ul');

    for (let i = data.startPage; i <= data.endPage; i++) {
        const pageNumElem = document.createElement('li');
        pageNumElem.innerText = i;
        pageNumElem.addEventListener('click', () => {
            getBoardList(i);
        });
        paginationElem.append(pageBoxElem);
        pageBoxElem.append(pageNumElem);
    }
}

getTags();

const checkBoxElem = document.getElementById('allChk');
const delChkElem = document.getElementsByName('delChk');
checkBoxElem.addEventListener('click', () => {
    if (checkBoxElem.checked) {
        for (let i = 0; i < delChkElem.length; i++) {
            delChkElem[i].checked = true;
        }
    } else {
        for (let i = 0; i < delChkElem.length; i++) {
            delChkElem[i].checked = false;
        }
    }
});

function delBoard() {
    const delChkVal = new Array;

    if (confirm('삭제 하시겠습니까?')) {
        for (let i = 0; i < delChkElem.length; i++) {
            if (delChkElem[i].checked) {
                delChkVal.push(delChkElem[i].value);
            }
        }

        fetch('/admin/board', {
            method: 'DELETE',
            body: JSON.stringify({delChk: delChkVal}),
            headers: {
                'accept': 'application/json',
                'content-type': 'application/json;charset=UTF-8'
            }
        })
            .then((res) => {
                return res.json();
            })
            .then((data) => {
                if (data.result !== 0) {
                    getBoardList();
                }
            });
    }
}

/*------------------Tag-----------------*/

const tnameElem = document.getElementById('txtTag');

tnameElem.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        regTag();
    }
});

function regTag() { // 태그를 등록하는 ajax 함수

    fetch('/admin/tag', {
        method: 'POST',
        body: JSON.stringify({
            tname: tnameElem.value
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
            tnameElem.value = '';
        });
}

function getTags() { // 태그 가져오기

    fetch('/admin/tag')
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            makeTagList(data);
            getBoardList(1);
        });
}

function makeTagList(data) {
    const tagBoxElem = document.getElementById('tagBox');
    tagBoxElem.innerText = '';
    data.tags.forEach((item) => {
        const tagElem = document.createElement('li');
        const delElem = document.createElement('button')
        tagElem.innerText = item.tname;
        delElem.className = 'tagDelBtn';

        delElem.addEventListener('click', () => {
            if (confirm("삭제 하시겠습니까?")) {
                delTag(item.tno);
            }
        })
        tagElem.append(delElem);
        tagBoxElem.append(tagElem);
    });
}

function delTag(tno) { // 태그삭제
    fetch('/admin/tag/' + tno, {
        method: 'DELETE'
    })
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            getTags();
        })
}

/*------------------------Category-------------------------*/

getCategoryList();

function getCategoryList() {
    fetch('/admin/category')
        .then((res) => {
            return res.json();
        })
        .then((data) => {
            const categoryList = document.getElementById('categoryList');
            categoryList.size = data.result.length;
            categoryList.innerText = '';

            data.result.forEach((item) => {
                const categoryItem = document.createElement('li');
                const categoryContent = document.createElement('input');

                categoryContent.type = 'text';
                categoryContent.value = item.bnm;

                categoryItem.append(categoryContent);
                if (item.bcd > 2) {
                    const categoryDelete = document.createElement('button');
                    const categoryOrdUp = document.createElement('button');
                    const categoryOrdDown = document.createElement('button');

                    // TODO: X, 화살표 아이콘으로 바꿔야함
                    categoryDelete.innerText = 'X';
                    categoryOrdUp.innerText = '↑';
                    categoryOrdDown.innerText = '↓';

                    //수정
                    categoryContent.addEventListener('focusout',() => {
                        updCategory(item.bcd, categoryContent.value);
                    });

                    //삭제
                    categoryDelete.addEventListener('click', () => {
                        if (confirm('삭제 하시겠습니까?')) {
                            delCategory(item.bcd, item.cord);
                        }
                    });

                    //순서 ↑
                    categoryOrdUp.addEventListener('click', () => {
                        updCategoryOrd('up',item.cord);
                    });

                    //순서 ↓
                    categoryOrdDown.addEventListener('click', () => {
                        updCategoryOrd('down',item.cord);
                    });

                    categoryItem.append(categoryDelete);
                    categoryItem.append(categoryOrdUp);
                    categoryItem.append(categoryOrdDown);
                } else {
                    categoryContent.readOnly = true;
                }
                categoryList.append(categoryItem);
            });
        });
}

// 카테고리 등록
const categoryElem = document.getElementById('txtCategory');

categoryElem.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        regCategory();
    }
});

function regCategory() {

    fetch('/admin/category', {
        method: 'POST',
        body: JSON.stringify({
            bnm: categoryElem.value
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
            if (data.result === 1) {
                categoryElem.value = '';
                getCategoryList();
            } else {
                alert('등록 실패');
            }
        });
}

// 카테고리 수정
function updCategory(bcd, bnm) {
    fetch('/admin/category', {
        method: 'PATCH',
        body: JSON.stringify({
            bcd: bcd,
            bnm: bnm
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
                alert('수정 실패')
            } else {
                getCategoryList();
            }
        });
}

// 카테고리 삭제
function delCategory(bcd, cord) {

    fetch('/admin/category', {
        method: 'DELETE',
        body: JSON.stringify({
            bcd: bcd,
            cord: cord
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
                alert('삭제 실패');
            } else {
                getCategoryList();
            }
        });
}

// 카테고리 순서변경
function updCategoryOrd(ordType, cord) {
    fetch('/admin/category/ord', {
        method: 'PATCH',
        body: JSON.stringify({
            cord: cord,
            ordType: ordType
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
            if (data.result === 0){
                alert('수정 실패');
            } else {
                getCategoryList();
            }
        });
}