package com.koreait.alsamo.board.reply;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardReplyMapper {
    int insReply(BoardReplyEntity param);
    int insReReply(BoardReplyEntity param);

    List<BoardReplyEntity> selReplyList(BoardReplyEntity param);

    int updReReply(BoardReplyEntity param);
    int updReply(BoardReplyEntity param);

    int delReply(BoardReplyEntity param);
}
