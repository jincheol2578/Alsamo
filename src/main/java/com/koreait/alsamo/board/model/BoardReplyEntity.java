package com.koreait.alsamo.board.model;

import lombok.Data;

@Data
public class BoardReplyEntity {
    private int repno;
    private String repnm;
    private String repctnt;
    private String reprdt;
    private String reppw;
    private int bno;
    private int uno;
    private int bdel;
}
