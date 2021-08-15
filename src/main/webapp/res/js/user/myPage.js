const pwElem = document.getElementById('inputPassword');
const pwChckElem = document.getElementById('inputPasswordChck');
const chckPwMsgElem = document.getElementById('checkPwMsg');
pwChckElem.addEventListener('focusout', chckPw);
pwElem.addEventListener('focusout', chckPw);
function chckPw(){
    if(pwElem.value !== '' || pwChckElem.value !== '') {
        if(pwElem.value === pwChckElem.value) {
            chckPwMsgElem.innerHTML = '<i class="far fa-check-circle"></i> 비밀번호가 일치 합니다.';
            chckPwMsgElem.style.color = 'green';
            return true;
        } else {
            chckPwMsgElem.innerHTML = '<i class="far fa-times-circle"></i> 비밀번호가 일치 하지 않습니다.';
            chckPwMsgElem.style.color = 'red';
            return false;
        }
    } else {
        chckPwMsgElem.innerHTML = '<i class="far fa-times-circle"></i> 비밀번호를 입력해주세요';
        chckPwMsgElem.style.color = 'orange';
        return false;
    }

}