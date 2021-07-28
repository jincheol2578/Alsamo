/*--------------BoardList-----------------*/

// 게시글 가져오기
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
            pagination(data.paging);
        });
}

// 페이징

function pagination(data) {
    const paginationElem = document.getElementById('pagination');
    const pageBoxElem = document.createElement('ul');

    paginationElem.append(pageBoxElem);
    for (let i = data.startPage; i <= data.endPage; i++) {
        const pageNumElem = document.createElement('li');
        pageNumElem.innerText = i;
        pageNumElem.addEventListener('click',()=>{
            pageBoxElem.innerText = '';
            getBoardList(i);
        })
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
                if (data.result === 1) {
                    getBoardList();
                } else {

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
            if (confirm("삭제하시겠습니까")) {
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
            for (let i = 0; i < data.length; i++) {
            }
        })
}

// 카테고리 등록
function regCategory() {
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
        .then((res) => {
            return res.json();
        })
        .then((data) => {
        })
}