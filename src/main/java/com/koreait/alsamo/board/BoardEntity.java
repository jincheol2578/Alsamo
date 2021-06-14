package com.koreait.alsamo.board;

import lombok.Data;

@Data
public class BoardEntity {
    private int ibaord;
    private int iuser;
    private int bcode;
    private String title;
    private String content;
    private String regdate;
    private int gNo;
    private int gOrd;
    private int gLayer;
}
