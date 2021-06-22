
package com.koreait.alsamo.user;


import com.koreait.alsamo.mailsender.MailHandler;
import com.koreait.alsamo.mailsender.TempKey;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession session;

    @Autowired
    private JavaMailSender mailSender;


    public int join(UserEntity param) throws MessagingException, UnsupportedEncodingException {
        if (param.getUpw() != null) {
            String crypPw = BCrypt.hashpw(param.getUpw(), BCrypt.gensalt());
            param.setUpw(crypPw);

            String key = new TempKey().getKey(50, false);
            param.setAuthKey(key);

/* 포트번호 바뀔시 메일 링크 포트번호 바꾸기 */
            MailHandler sendMail = new MailHandler(mailSender);
            sendMail.setSubject("Alsamo 서비스 이메일 인증");
            sendMail.setText(new StringBuffer().append("<h1>이메일인증</h1>")
                    .append("<a href='http://localhost:8080/user/emailConfirm?userEmail=")
                    .append(param.getUemail())
                    .append("&AuthKey=")
                    .append(key)
                    .append("' target='_blank'>이메일 인증 확인</a>").toString());
            sendMail.setFrom("heckevil12@gmail.com", "alsamo");
            sendMail.setTo(param.getUemail());
            sendMail.send();


            return mapper.insUser(param);

        } else {
            return mapper.insGoogleUser(param);
        }
    }

    public String login(UserEntity param) {

        UserEntity result = mapper.selUser(param);

        if (result == null) {
            //아이디 없음
            return "/user/login?err=1";
        } else if (BCrypt.checkpw(param.getUpw(), result.getUpw())) {
            //로그인 성공
            result.setUpw(null);
            session.setAttribute("loginUser", result);
            return "/board/list";
        } else {
            //비밀번호 틀림
            return "/user/login?err=2";
        }

    }

    public int googleLogin(UserEntity user) {
        UserEntity exsistUser = mapper.checkSocialUserExsist(user);
        System.out.println(exsistUser);
        if (exsistUser == null) {
            //가입 필요 /user/googleJoin
            mapper.insGoogleUser(user);
            return 1;

        } else {

            //이미 가입 완료 /board/list
            return 0;
        }
    }

    public int chckAuthkey(UserEntity param) {
        UserEntity result = mapper.chckAuthkey(param);
        if (result == null) {

            //인증이 옳바르지 않음
            return 0;
        } else {
            //인증 성공
            return 1;
        }
    }

    public int upAuthorize(UserEntity param) {
        return mapper.upAuthorize(param);
    }
}