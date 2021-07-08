package com.koreait.alsamo.board.notice;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardNoticeService {
    @Autowired
    BoardNoticeMapper mapper;

    @Autowired
    MyUtils myUtils;

    public List<BoardDomain> selNoticeList(BoardDTO param){
        return mapper.selNoticeList(param);
    }

    public int insNotice(BoardDTO param){
        int userAuth = myUtils.getLoginUser().getAuthno();
        if(userAuth != 0 || userAuth != 1){
            return 0;
        }
        return mapper.insNotice(param);
    }

    public int delNotice(BoardDTO param){
        int userAuth = myUtils.getLoginUser().getAuthno();
        if(userAuth != 0 || userAuth != 1){
            return 0;
        }
        return mapper.delNotice(param);
    }
}
