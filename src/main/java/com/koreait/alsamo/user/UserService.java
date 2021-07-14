
package com.koreait.alsamo.user;


import com.koreait.alsamo.mailsender.TempKey;
import com.koreait.alsamo.utils.MyUtils;
import org.apache.commons.io.FilenameUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession session;


    @Autowired
    private MyUtils myUtils;

    @Async("threadPoolTaskExecutor")
    public void join(UserEntity param) throws MessagingException, UnsupportedEncodingException {

        if (param.getUpw() != null) {
            String crypPw = BCrypt.hashpw(param.getUpw(), BCrypt.gensalt());
            param.setUpw(crypPw);

            /* 랜덤키 생성 */
            String key = new TempKey().getKey(50, false);
            param.setAuthkey(key);

            /* 메일 작성 */
            String txt = String.format("<a href='http://localhost:8080/user/emailConfirm?userEmail=%S&AuthKey=%s'target='_blank'>이메일 인증 확인</a>", param.getUemail(), key);
            String subject = "<h1>Alsamo 이메일 인증</h1>";
            myUtils.mailSender(param.getUemail(), subject, txt);

            mapper.insUser(param);

        } else {
            mapper.insGoogleUser(param);
        }
    }

    public String login(UserEntity param) {

        UserEntity result = mapper.selUser(param);

        if (result == null) {
            //아이디 없음
            return "/user/loginErr?err=1";
        } else if (BCrypt.checkpw(param.getUpw(), result.getUpw())) {
            //로그인 성공
            result.setUpw(null);
            session.setAttribute("loginUser", result);
            return "/board/list";
        } else {
            //비밀번호 틀림
            return "/user/loginErr?err=2";
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

    public int upAuth_no(UserEntity param) {
        return mapper.upAuth_no(param);
    }

    @Async("threadPoolTaskExecutor")
    public void find(UserEntity param) throws MessagingException, UnsupportedEncodingException {

        /* 메일 작성 */
        UserEntity selUser = mapper.selUser(param);
        String subject = "Alsamo 아이디/비밀번호 찾기 이메일 인증";
        String txt = String.format("<a href='http://localhost:8080/user/femailConfirm?fuserEmail=%s&fAuthKey=%s' target='_blank'>이메일 인증확인</a>", param.getUemail(), selUser.getAuthkey());
        myUtils.mailSender(param.getUemail(), subject, txt);

    }

    public UserEntity findId(UserEntity param) {
        UserEntity user = mapper.selId(param);
        return user;
    }

    public String updUser(UserEntity param) {
        String hashPw = BCrypt.hashpw(param.getUpw(), BCrypt.gensalt());
        param.setUpw(hashPw);
        mapper.updUser(param);
        return "/user/login";
    }




    public String updUserMark(MultipartFile img, int authNo) {
       UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        final String PATH = "D:/springImg/"+authNo;
        String nowMark = mapper.selNowMark(authNo);

        File folder1 = new File(PATH);
        folder1.mkdirs();

        String ext = FilenameUtils.getExtension(img.getOriginalFilename());
        String fileNm = UUID.randomUUID().toString() + "." + ext;

        File target = new File(PATH + "/" + fileNm);
        try {
            img.transferTo(target);

            File defile = new File(PATH+ "/" + nowMark);
            if (defile.exists()) {
                defile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserEntity param = new UserEntity();
        param.setProfileImg(fileNm);
        param.setAuthno(authNo);

        loginUser.setProfileImg(fileNm);

        mapper.updMark(param);
        return "/user/adminpage";
    }


}