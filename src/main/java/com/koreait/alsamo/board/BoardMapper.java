package com.koreait.alsamo.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity param);
    List<BoardDomain> selBoardCategory();
    List<BoardDomain> selBoardList(BoardDTO param);
}
