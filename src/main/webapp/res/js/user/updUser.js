const pwElem = document.getElementById('inputPassword');
const pwChckElem = document.getElementById('inputPasswordChck');
const chckPwMsgElem = document.getElementById('checkPwMsg');
pwChckElem.addEventListener('focusout', chckPw);
pwElem.addEventListener('focusout', chckPw);
function chckPw(){
    if(pwElem.value != pwChckElem.value){
        if(pwChckElem.value == ''){
            chckPwMsgElem.innerText = '비밀번호를 확인 다시 해주세요!';
            chckPwMsgElem.style.color = 'red';
            return false;
        }else{
            chckPwMsgElem.innerText = '비밀번호가 일치 하지 않습니다.';
            chckPwMsgElem.style.color = 'red';
            return false;
        }
    }else{
        chckPwMsgElem.innerText = '비밀번호가 일치 합니다.';
        chckPwMsgElem.style.color = 'green';
        return true;
    }

}
function chckPw2(){
    if(pwElem.value != pwChckElem.value){
        if(pwChckElem.value == ''){
            chckPwMsgElem.innerText = '비밀번호를 확인 다시 해주세요!';
            chckPwMsgElem.style.color = 'red';
            return false;
        }else{
            chckPwMsgElem.innerText = '비밀번호가 일치 하지 않습니다.';
            chckPwMsgElem.style.color = 'red';
            return false;
        }
    }else{
        chckPwMsgElem.innerText = '비밀번호가 일치 합니다.';
        chckPwMsgElem.style.color = 'green';
        return true;
    }
}