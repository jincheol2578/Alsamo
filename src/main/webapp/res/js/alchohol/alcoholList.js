ajaxAl('위스키');

function goHome() {
    location.href = "/board/list";
}

function getWhiskey() {

    const innerHTML = document.getElementById('Whiskey').innerText;
    const name = {
        name: innerHTML
    };

    ajaxAl(name);
}

function getRum() {

    const innerHTML = document.getElementById('Rum').innerText;
    const name = {
        name: innerHTML
    };

    ajaxAl(name);
}

function getJim() {
    const innerHTML = '진_(술)';
    const name = {
        name: innerHTML
    };

    ajaxAl(name);

}

function getTequila() {
    const innerHTML = document.getElementById('Tequila').innerText;
    const name = {
        name: innerHTML
    };

    ajaxAl(name);
}

function getVodka() {
    const innerHTML = document.getElementById('Vodka').innerText;
    const name = {
        name: innerHTML
    };
    ajaxAl(name);
}

function searchAl(name) {
    location.href = '/alcohol/alcoholList';
    const al = document.getElementById(name);
    const alData = {
        name: al.dataset.name
    };
    console.log(alData);
    ajaxAl(alData);
}

function ajaxAl(name) {
    const init = {
        method: 'post',
        body: JSON.stringify(name),
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json;charset=UTF-8'
        }
    };

    fetch('/alcohol/alcoholList', init)
        .then((res) => {
            return res.json();
        })
        .then((myJson) => {
            document.getElementById('alcoholContent').innerHTML = myJson.content;
            // if (myJson.alImg == null) {
            //     alert('구체적인 검색어를 입력해 주세요.')
            // } else {
            //     document.getElementById('alImg').src = myJson.alImg;
            //     console.log( document.getElementById('alImg'));
            // }

            document.getElementById('alcoholTable').innerHTML = myJson.alTable;

            addSrc();
            // hindUselss();
        })

}

function addSrc() {
    const container = document.querySelector('#downContent');
    const a = container.getElementsByTagName('a');

    for (var i = 0; i < a.length; i++) {
        var origin = a[i].getAttribute('href');
        var sufix = "https://ko.wikipedia.org/";
        a[i].href = sufix + origin;
    }
}

function searchName() {
    let value = document.getElementById('searchWhat');
    let searchWhat = value.value;
    const name = {
        name: searchWhat,
    };
    console.log(value);
    ajaxAl(name);
}

function enterKey() {
    if (window.event.keyCode == 13) {
        searchName();
    }

}

function hindUselss() {
    document.querySelector('#p-lang-btn').style.display = 'none';
    document.querySelector('.nowraplinks ').style.display='none';
}