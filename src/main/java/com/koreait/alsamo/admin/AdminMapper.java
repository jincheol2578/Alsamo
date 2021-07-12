package com.koreait.alsamo.admin;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    UserEntity selAdmin(UserEntity param);
    BoardDomain selBoardList(BoardDTO param);
    int selBoardCount(BoardDTO param);

    int insTag(String tname);
    List<String> selTags();
    int delTag(String tname);
}
