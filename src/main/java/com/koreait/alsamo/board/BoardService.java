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
        return mapper.insBoard(param);
    }
    public int insReBoard(BoardEntity param){
        param.setIuser(myUtils.getUserPk());
        return mapper.insReBoard(param);
    }

    public List<BoardDTO> selBoardCategory(){
        return mapper.selBoardCategory();
    }

    public List<BoardDomain> selBoardList(BoardDTO param){
        param.setIuser(myUtils.getUserPk());
        return mapper.selBoardList(param);
    }
    public BoardDomain selBoard(BoardDTO param){
        param.setIuser(myUtils.getUserPk());
        return mapper.selBoard(param);
    }

    public int updReBoard(BoardEntity param){
        return mapper.updReBoard(param);
    }
    public int delBoard(BoardEntity param){return mapper.delBoard(param);}
}
