package com.koreait.alsamo.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private int iboard;
    private int bcode;
    private String bnm;
    private int iuser;
    private int startIdx;
    private int recordCnt;
    private int searchType;
    private String searchText;
    private int page = 1;
    private int modify;
    private String board_pw;


}
