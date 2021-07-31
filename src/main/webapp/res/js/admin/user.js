//유저 리스트
function getUserList(authno, page) {
    fetch('/admin/user/list', {
        method: 'POST',
        body: JSON.stringify({
            authno: authno,
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
            makeList(data.userList);
        });
}

function makeList(item) {
    console.log(item);
}

getUserList('1',1);