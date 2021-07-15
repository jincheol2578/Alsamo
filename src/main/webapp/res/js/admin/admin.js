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
            console.log(data);
        })
}

getTags();

function delTag(tno) {
    fetch('/admin/tag/' + tno, {
        method: 'DELETE'
    })
        .then((res) => {
            return res.json();
        })
        .then((data)=>{
            console.log(data);
            getTags();
        })
}