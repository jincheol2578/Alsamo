package com.koreait.alsamo.board.reply;

import com.koreait.alsamo.board.model.BoardReplyDomain;
import com.koreait.alsamo.board.model.BoardReplyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardReplyMapper {
    int insReply(BoardReplyEntity param);
    int insReReply(BoardReplyEntity param);

    List<BoardReplyDomain> selReplyList(BoardReplyEntity param);

    int updReReply(BoardReplyEntity param);
//    int updReply(BoardReplyEntity param); X

    int delReply(BoardReplyEntity param);
}
