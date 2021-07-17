function makeUl(count) {
    let targets = document.getElementById(count);
    let divElem = document.createElement('div');
    let ulElem = document.createElement('ul');
    let liWhatWriteElem = document.createElement('li');
    let liWhatReplElem = document.createElement('li');
    let liWhoElem = document.createElement('li');
    let highlightElem = document.createElement('em');


    liWhoElem.innerText = '프로필';
    liWhatWriteElem.innerText = '작성글';
    liWhatReplElem.innerText = '댓글';

    ulElem.append(liWhoElem);
    ulElem.append(liWhatWriteElem);
    ulElem.append(liWhatReplElem);

    divElem.append(ulElem);
    divElem.setAttribute('id', count);
    divElem.setAttribute('class', 'infoUser');

    targets.append(divElem);
    console.log(targets);


}

// whereBoxs.forEach(function (whereBox) {
//     whereBox.addEventListener('click', makeUl);
//
//
// })
