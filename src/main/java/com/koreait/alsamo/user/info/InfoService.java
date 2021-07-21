package com.koreait.alsamo.user.info;

import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.board.model.BoardEntity;
import com.koreait.alsamo.board.model.BoardReplyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoService {
    @Autowired
    private InfoMapper mapper;

    // 글쓴 리스트
    public List<BoardDomain> selAllWrite(int param) { return mapper.selAllBoardWho(param); }

    // 리스트 카운트
    public int selAllWriteCount(int param) {
        return mapper.countAllWrite(param);
    }

    // 리플 리스트
    public List<BoardReplyEntity> selAllReply(int param) {
        return mapper.selAllRepWho(param);
    }

    //리플 카운트
    public int selAllReplyCount(int param) {
        return mapper.countAllReply(param);
    }

}
