package com.koreait.alsamo.user;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public int join(UserEntity param){
        String crypPw = BCrypt.hashpw(param.getUpw(),BCrypt.gensalt());
        param.setUpw(crypPw);
        return mapper.insUser(param);
    }
}