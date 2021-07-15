package com.koreait.alsamo.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private int bno;
    private int bcd;
    private String bnm;

    private int uno;

    private int startIdx;
    private int cntPerPage;
    private int page = 1;

    private String searchType;
    private String searchText;

    private int modify;
    private int delChk;

    private String bpw;

    private String[] tags;
}
