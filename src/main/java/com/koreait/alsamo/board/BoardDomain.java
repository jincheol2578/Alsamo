package com.koreait.alsamo.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDomain extends BoardEntity{
    private String writer;
    private int uLev;
    private int uExp;
    private String uicon;
    private String bnm;
}
