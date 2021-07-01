package com.koreait.alsamo.utils;

import com.koreait.alsamo.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
@Component
public class MyUtils {
// TODO: 가능하면 static으로 바꾸기
    @Autowired
    HttpSession session;

    // Session에 "loginUser" 키값으로 저장된 UserEntity 객체를 리턴해주는 메소드
    public UserEntity getLoginUser(){
        try {
            return (UserEntity) session.getAttribute("loginUser");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    // Session에서 가져온 User객체의 uno 리턴해주는 메소드
    public int getUserPk(){
        return getLoginUser() == null ? 0 : getLoginUser().getUno();
    }
}
