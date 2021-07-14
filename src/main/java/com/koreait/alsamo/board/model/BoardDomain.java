package com.koreait.alsamo.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardDomain extends BoardEntity{
    private String writer;
    private int uLev;
    private int uExp;
    private String uicon;
    private String bnm;
}
