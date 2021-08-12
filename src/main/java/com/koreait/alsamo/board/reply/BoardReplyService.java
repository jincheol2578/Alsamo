package com.koreait.alsamo.board.reply;

import com.koreait.alsamo.board.model.BoardReplyDomain;
import com.koreait.alsamo.board.model.BoardReplyEntity;
import com.koreait.alsamo.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardReplyService {

    @Autowired
    BoardReplyMapper mapper;

    @Autowired
    MyUtils myUtils;

    public List<BoardReplyDomain> selReplyList(BoardReplyEntity param){
        return mapper.selReplyList(param);
    }

    public int insReply(BoardReplyEntity param){
        if(param.getRepnm() == null && myUtils.getLoginUser() != null){
            param.setUno(myUtils.getUserPk());
            param.setRepnm(myUtils.getLoginUser().getUnm());
        }
        return mapper.insReply(param);
    }
    public int insReReply(BoardReplyEntity param){
        if(param.getRepnm() == null && myUtils.getLoginUser() != null){
            param.setUno(myUtils.getUserPk());
            param.setRepnm(myUtils.getLoginUser().getUnm());
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<param.getRepdept(); i++) {
            sb.append("　");
        }
        sb.append("└　");
        sb.append(param.getRepctnt());
        param.setRepctnt(sb.toString());
        mapper.updReReply(param);
        return mapper.insReReply(param);
    }

    public int delReply(BoardReplyEntity param) {
        if(myUtils.getLoginUser() != null){
            param.setUno(myUtils.getUserPk());
        }
        return mapper.delReply(param);
    }

    public int updReply(BoardReplyEntity param){
        if(myUtils.getLoginUser() != null){
            param.setUno(myUtils.getUserPk());
        }
        return mapper.updReply(param);
    }
}
