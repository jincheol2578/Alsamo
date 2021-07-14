package com.koreait.alsamo.admin;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.user.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper mapper;
    @Autowired
    HttpSession session;

    // 로그인
    public String login(UserEntity param) {
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

    // 게시판 관리
    public List<BoardDomain> getBoardList(BoardDTO param) {
        return mapper.selBoardList(param);
    }

    public int getBoardCount(BoardDTO param) {
        return mapper.selBoardCount(param);
    }

    public int delBoard(AdminDTO param) {
        return mapper.delBoard(param);
    }

    // 게시판 태그 관리
    public int regTag(BlockTags tags) {
        return mapper.insTag(tags);
    }

    public List<BlockTags> getTags() {
        return mapper.selTags();
    }

    public int delTag(int tno) {
        return mapper.delTag(tno);
    }

    // 카테고리 관리
    public int regCategory(BoardCategoryDTO param) {
        try {
            mapper.updCategoryUp(param.getCord());
            return mapper.insCategory(param);
        } catch (Exception e) {
            return 0;
        }
    }
    public List<BoardCategoryDTO> getCategoryList() {
        return mapper.selCategoryList();
    }

    public int updCategory(BoardCategoryDTO param) {
        return mapper.updCategory(param);
    }

    public int updCategoryOrd(BoardCategoryDTO param) {
        return mapper.updCategoryOrd(param);
    }

    public int delCategory(BoardCategoryDTO param) {
        try {
            mapper.updCategoryDown(param.getCord());
            return mapper.delCategory(param);
        } catch (Exception e) {
            return 0;
        }
    }
}
