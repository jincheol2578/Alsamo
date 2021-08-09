function active(uno, page) {
    location.href = '/user/inforeply?uno=' + uno + '&page=' + page;
}

function moveToPage(uno, page) {
    const url = '/user/inforeply?uno=' + uno + '&page=' + page;
    location.href = url;
}
