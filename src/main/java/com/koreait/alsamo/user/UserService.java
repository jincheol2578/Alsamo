package com.koreait.alsamo.user;

import com.koreait.alsamo.MyUtils;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession session;

    public String userLogin(UserEntity param){
        UserEntity result = mapper.selUser(param);
        if(result == null){
            //아이디 없음'
            return "login";
        }else if (result.getUpw().equals(param.getUpw())){  // TODO: BCrypt 적용하기
            //로그인
            result.setUpw(null);
            session.setAttribute("loginUser", result);
            return "/board/list";
        }else{
            //비번다름
            return "login";
        }
    }

}
