

function onSignIn(googleUser) {
    // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();
    console.log("ID: " + profile.getId()); // Don't send this directly to your server!
    var googleUid = profile.getId();
    console.log('Full Name: ' + profile.getName());
    var googleUname = profile.getName();
    console.log('Given Name: ' + profile.getGivenName());
    console.log('Family Name: ' + profile.getFamilyName());
    console.log("Image URL: " + profile.getImageUrl());
    console.log("Email: " + profile.getEmail());
    var goodleEmail = profile.getEmail();


    // The ID token you need to pass to your backend:
    var id_token = googleUser.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);


    var param = {
        uid: googleUid,
        unm : googleUname,
        uemail :goodleEmail
    }
     console.log(param);
    insGoogleUserAjax(param);


    function insGoogleUserAjax(param) {
        const init = {
            method: 'post',
            body: JSON.stringify(param),
            headers: {
                'accept': 'application/json',
                'content-type': 'application/json;charset=UTF-8'
            }
        };

        fetch('googleJoin', init,{headers : {
                'Accept': 'application/json'
            }})
            .then(function (res) {
                return res.json();
            })
            .then(function (myJson) {
                console.log('exsist?: ' + myJson);
                switch (myJson){
                    case 1:

                        location.href='/board/list';

                        break;
                    case 0:
                        location.href='/board/list';
                        break;
                }
            })


    }

}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
}


