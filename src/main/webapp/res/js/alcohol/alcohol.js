ajaxAl('위스키');

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
            console.log(myJson.name);
            console.log(myJson.content);
            console.log(myJson.alImg);
            console.log(myJson.alTable);
            document.getElementById('alcoholContent').innerHTML = myJson.content;
            document.getElementById('alcoholName').innerText = myJson.name;
            if (myJson.alImg == null) {
                alert('구체적인 검색어를 입력해 주세요.')
            } else {
                document.getElementById('alImg').src = myJson.alImg;
            }

            document.getElementById('alcoholTable').innerHTML = myJson.alTable;

            addSrc();
            hindUselss();
        })

}

function addSrc() {
    const container = document.querySelector('.contentContainer');
    const a = container.getElementsByTagName('a');

    for (var i = 0; i < a.length; i++) {
        var origin = a[i].getAttribute('href');
        var sufix = "https://ko.wikipedia.org/";
        a[i].href = sufix + origin;
        console.log(a[i].href);
        console.log(origin);
    }
}

function searchName() {
    const value = document.querySelector('.form-control').value;
    const name = {
        name: value
    };
    ajaxAl(name);
}

function enterKey() {
    if (window.event.keyCode == 13) {
        searchName();
    }

}

function hindUselss() {
    document.querySelector('#p-lang-btn').style.display = 'none';
}

