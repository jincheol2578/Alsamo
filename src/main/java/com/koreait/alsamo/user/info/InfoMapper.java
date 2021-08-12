package com.koreait.alsamo.user.info;

import com.koreait.alsamo.board.model.BoardDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InfoMapper {
    List<BoardDomain> selAllBoardWho(InfoUserDTO param);

    List<InfoReplyDTO> selAllRepWho(InfoUserDTO param);

    int countAllWrite(int param);

    int countAllReply(int param);

    int countBoardList(InfoUserDTO param);
}
