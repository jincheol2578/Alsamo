package com.koreait.alsamo.admin;

import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.user.UserDTO;
import com.koreait.alsamo.user.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        if (result.getUid() == null) {
            //아이디 없음
            return "/admin?err=1";
        } else if (BCrypt.checkpw(param.getUpw(), result.getUpw())) {
            //로그인 성공
            result.setUpw(null);
            session.setAttribute("loginAdmin", result);
            return "/admin/board";
        } else {
            //비밀번호 틀림
            return "/admin?err=2";
        }
    }
    //유저관리
    public int getUserCount(UserDTO param) {
        return mapper.selUserCount(param);
    }

    public List<UserEntity> getUserList(UserDTO param) {
        return mapper.selUserList(param);
    }

    public int updUser(UserDTO param) {
        try {
            UserEntity userEntity = (UserEntity) session.getAttribute("loginAdmin");
            if (userEntity != null && userEntity.getAuthno() == 1) {
                return mapper.updUser(param);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 게시판 관리
    public List<BoardDomain> getBoardList(AdminDTO param) {
        return mapper.selBoardList(param);
    }

    public int getBoardCount(AdminDTO param) {
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
            return mapper.insCategory(param);
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

    @Transactional
    public int delCategory(BoardCategoryDTO param) {
        try {
            mapper.updCategoryDown(param.getCord());
            return mapper.delCategory(param);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
