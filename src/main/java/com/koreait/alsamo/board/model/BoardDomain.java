package com.koreait.alsamo.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardDomain extends BoardEntity{
    private String writer = "익명";
    private String bnm;
    private int rec;
}
