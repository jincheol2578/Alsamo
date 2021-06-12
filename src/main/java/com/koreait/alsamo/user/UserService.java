package com.koreait.alsamo.user;

import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper mapper;

    String userLogin(UserEntity param){
        UserEntity result = mapper.selUser(param);
        if(result == null){
            //아이디 없음'
            return "login";
        }else if (result.getUpw().equals(param.getUpw())){  // TODO: BCrypt 적용하기
            //로그인
            return "/board/list";
        }else{
            //비번다름
            return "login";
        }
    }

}
