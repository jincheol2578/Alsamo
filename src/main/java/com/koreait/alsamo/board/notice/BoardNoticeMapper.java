package com.koreait.alsamo.board.notice;

import com.koreait.alsamo.board.model.BoardDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardNoticeMapper {
     List<BoardDomain> selNoticeList(int bcd);
     List<BoardDomain> selMainNoticeList();
     int insNotice(int bno);
     int delNotice(int bno);
     int selNotice(int bno);
}
