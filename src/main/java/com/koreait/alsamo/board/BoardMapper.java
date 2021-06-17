package com.koreait.alsamo.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity param);
    int insReBoard(BoardEntity param);
    List<BoardDTO> selBoardCategory();
    List<BoardDomain> selBoardList(BoardDTO param);
    BoardDomain selBoard(BoardDTO param);
    int updReBoard(BoardEntity param);

}
