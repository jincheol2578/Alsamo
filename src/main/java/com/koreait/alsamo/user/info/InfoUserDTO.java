package com.koreait.alsamo.user.info;

import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.board.model.BoardReplyEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class InfoUserDTO {
    private int uno;
    private List<BoardDomain> boardList;
    private int countBoardList;
    private List<InfoReplyDTO> replyList;
    private int countReplyList;
    private int startIdx;
    private int cntPerPage;
    private int page = 1;
}
