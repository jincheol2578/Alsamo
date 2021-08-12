package com.koreait.alsamo.admin;

import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.user.UserDTO;
import com.koreait.alsamo.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdminMapper {
    UserEntity selAdmin(UserEntity param);

    List<BoardDomain> selBoardList(AdminDTO param);
    int selBoardCount(AdminDTO param);
    int delBoard(AdminDTO param);

    int insTag(BlockTags tags);
    List<BlockTags> selTags();
    int delTag(int tno);

    int insCategory(BoardCategoryDTO param);
    List<BoardCategoryDTO> selCategoryList();
    int updCategory(BoardCategoryDTO param);
    int updCategoryUp(int cord);
    int updCategoryDown(int cord);
    int updCategoryOrd(BoardCategoryDTO param);
    int delCategory(BoardCategoryDTO param);

    int selUserCount(UserDTO param);
    List<UserEntity> selUserList(UserDTO param);
    int updUser(UserDTO param);
}
