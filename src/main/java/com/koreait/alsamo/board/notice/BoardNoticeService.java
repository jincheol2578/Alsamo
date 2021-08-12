package com.koreait.alsamo.board.notice;

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

    public int selNotice(int bno) {
        return mapper.selNotice(bno);
    }
    public List<BoardDomain> selNoticeList(int bcd){
        return mapper.selNoticeList(bcd);
    }
    public List<BoardDomain> selMainNoticeList() {
        return mapper.selMainNoticeList();
    }

    public int insNotice(int bno){
        int userAuth = myUtils.getLoginUser().getAuthno();
        if(userAuth == 1 || userAuth == 2){
            return mapper.insNotice(bno);
        }
        return 0;
    }

    public int delNotice(int bno){
        int userAuth = myUtils.getLoginUser().getAuthno();
        if(userAuth == 1 || userAuth == 2){
            return mapper.delNotice(bno);
        }
        return 0;
    }
}
