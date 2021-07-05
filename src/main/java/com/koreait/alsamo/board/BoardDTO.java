package com.koreait.alsamo.board;

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

    private int searchType;
    private String searchText;

    private int modify;

    private String bpw;


}
