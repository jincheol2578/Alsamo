package com.koreait.alsamo.user.info;

import com.koreait.alsamo.board.model.BoardDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {
    @Autowired
    private InfoMapper mapper;

    // 글쓴 리스트
    public List<BoardDomain> selAllWrite(InfoUserDTO param) {
        System.out.println(mapper.selAllBoardWho(param));
        return mapper.selAllBoardWho(param);
    }

    // 리스트 카운트
    public int selAllWriteCount(int param) {
        return mapper.countAllWrite(param);
    }

    // 리플 리스트
    public List<InfoReplyDTO> selAllReply(InfoUserDTO param) {

        return mapper.selAllRepWho(param);
    }

    //리플 카운트
    public int selAllReplyCount(int param) {
        return mapper.countAllReply(param);
    }

    //마지막 페이지 val
    public int selBoardCount(InfoUserDTO param) {
        return mapper.countBoardList(param);
    }
    public int selReplyCount(InfoUserDTO param) { return mapper.countBoardList(param); }


}

