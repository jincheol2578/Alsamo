package com.koreait.alsamo.board.rec;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.board.model.BoardRecDTO;
import com.koreait.alsamo.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardRecService {
    @Autowired
    BoardRecMapper mapper;
    @Autowired
    MyUtils myUtils;

    public int insRec(BoardRecDTO param) {
        if(myUtils.getLoginUser() != null) {
            param.setUno(myUtils.getUserPk());
            return mapper.insRec(param);
        } else {
            return 0;  // 등록실패 (이미 추천되어있음)
        }
    }

    public List<BoardRecDTO> selRec(BoardRecDTO param) {
        return mapper.selRec(param);
    }
    public BoardRecDTO selRecChk(BoardRecDTO param){
        if(myUtils.getLoginUser() != null) {
            param.setUno(myUtils.getUserPk());
            return mapper.selRecChk(param);
        }else{
            return null;
        }
    }

    public List<BoardDomain> selTodayRecList(BoardDTO param) {
        return mapper.selTodayRecList(param);
    }

    public List<BoardDomain> selWeekendRecList(BoardDTO param) {
        return mapper.selWeekendRecList(param);
    }

    public int delRec(BoardRecDTO param) {
        if (myUtils.getLoginUser() != null) {
            param.setUno(myUtils.getUserPk());
            return mapper.delRec(param);
        } else {
            return 0;
        }
    }
}
