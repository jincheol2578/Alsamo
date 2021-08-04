function active(uno, page) {
    location.href = '/user/infowrite?uno=' + uno + '&page=' + page;
}

function moveToPage(uno, page) {
    const url = '/user/infowrite?uno=' + uno + '&page=' + page;
    location.href = url;
}
