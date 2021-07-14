package com.koreait.alsamo.admin;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    UserEntity selAdmin(UserEntity param);
    List<BoardDomain> selBoardList(BoardDTO param);
    int selBoardCount(BoardDTO param);
    int delBoard(AdminDTO param);

    int insTag(BlockTags tags);
    List<BlockTags> selTags();
    int delTag(int tno);

    int insCategory(String bnm);
    List<BoardCategoryDTO> selCategoryList();
    int updCategory(BoardCategoryDTO param);
    int delCategory(int bcd);
}
