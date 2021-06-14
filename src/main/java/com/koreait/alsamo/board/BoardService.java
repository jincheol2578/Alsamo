package com.koreait.alsamo.board;

import com.koreait.alsamo.MyUtils;
import com.koreait.alsamo.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;

    @Autowired
    private HttpSession session;

    @Autowired
    private MyUtils myUtils;

    public int insBoard(BoardEntity param){
        param.setIuser(myUtils.getUserPk());
        mapper.insBoard(param);
        return param.getIbaord();
    }

    public List<BoardDomain> selBoardCategory(){
        return mapper.selBoardCategory();
    }

    public List<BoardDomain> selBoardList(BoardDTO param){
        param.setIuser(myUtils.getUserPk());
        return mapper.selBoardList(param);
    }

}
