function makeUl(count) {
    let targets = document.getElementById(count);

    targets.classList.toggle('userId');

    let divElem = document.createElement('div');
    let ulElem = document.createElement('ul');
    let liWhatWriteElem = document.createElement('li');
    let liWhatReplElem = document.createElement('li');
    let liWhoElem = document.createElement('li');
    let aTagElemPrf=document.createElement('a');
    let aTagElemWhatWrt=document.createElement('a');
    let aTagElemRep=document.createElement('a');

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
        aTagElemPrf.setAttribute('href','/user/info');
        aTagElemWhatWrt.setAttribute('href','/user/info');
        aTagElemRep.setAttribute('href','/user/info');

        targets.append(divElem);

    } else {
        document.getElementById('info' + count).remove();
    }
}

