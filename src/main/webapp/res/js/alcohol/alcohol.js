let newAlcoholCon = document.getElementById('newAlcoholContainer');

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
function getVodka(){
    const innerHTML = document.getElementById('Vodka').innerText;
    const name={
      name:  innerHTML
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
            document.getElementById('alcoholContent').innerText = myJson.content;
            document.getElementById('alcoholName').innerText = myJson.name;
        })

}

