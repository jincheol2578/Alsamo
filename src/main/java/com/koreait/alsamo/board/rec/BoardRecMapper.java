package com.koreait.alsamo.board.rec;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.board.model.BoardRecDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRecMapper {
    int insRec(BoardRecDTO param);
    BoardRecDTO selRecChk(BoardRecDTO param);
    List<BoardRecDTO> selRec(BoardRecDTO param);
    List<BoardDomain> selTodayRecList(BoardDTO param);
    List<BoardDomain> selWeekendRecList(BoardDTO param);
    int delRec(BoardRecDTO param);
}
