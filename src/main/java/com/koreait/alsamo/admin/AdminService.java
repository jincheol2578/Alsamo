package com.koreait.alsamo.admin;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.user.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminService {
    @Autowired
    AdminMapper mapper;
    @Autowired
    HttpSession session;

    public int regTag(String tname){
        return mapper.insTag(tname);
    }
    public String login(UserEntity param){
        UserEntity result = mapper.selAdmin(param);

        if (result == null) {
            //아이디 없음
            return "아이디가 존재하지 않습니다.";
        } else if (BCrypt.checkpw(param.getUpw(), result.getUpw())) {
            //로그인 성공
            result.setUpw(null);
            session.setAttribute("loginAdmin", result);
            return "로그인 성공";
        } else {
            //비밀번호 틀림
            return "비밀번호를 확인해 주세요.";
        }
    }

    public BoardDomain getBoardList(BoardDTO param){
        return mapper.selBoardList(param);
    }
    public int getBoardCount(BoardDTO param){
        return mapper.selBoardCount(param);
    }
}
