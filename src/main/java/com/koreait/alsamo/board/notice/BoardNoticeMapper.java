package com.koreait.alsamo.board.notice;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardNoticeMapper {
     List<BoardDomain> selNoticeList(BoardDTO param);
     int insNotice(BoardDTO param);
     int delNotice(BoardDTO param);
}
