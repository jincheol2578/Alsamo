package com.koreait.alsamo.user.info;

import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.board.model.BoardEntity;
import com.koreait.alsamo.board.model.BoardReplyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InfoMapper {
    List<BoardDomain> selAllBoardWho(int param);
    List<BoardReplyEntity> selAllRepWho(int param);
    int countAllWrite(int param);
    int countAllReply(int param);
}
