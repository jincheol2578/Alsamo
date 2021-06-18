package com.koreait.alsamo.board;

import lombok.Data;

@Data
public class BoardEntity {
    private int iboard;
    private int iuser;
    private int bcode;
    private int group_idx;
    private int group_ord;
    private int group_dept;
    private String title;
    private String content;
    private String regdate;
    private int delete_val;
    private String bpw;
}
