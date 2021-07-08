package com.koreait.alsamo.board.rec;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRecMapper {
    int insRec(BoardDTO param);
    int delRec(BoardDTO param);
    int selRec(int bno);
    List<BoardDomain> selTodayRecList(BoardDTO param);
    List<BoardDomain> selWeekendRecList(BoardDTO param);
}
