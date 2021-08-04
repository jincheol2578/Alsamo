package com.koreait.alsamo.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AdminDTO {
    private int[] delChk;
    private int bcd;
    private String bnm;
    private List<BlockTags> tags;

    private int startIdx;
    private int cntPerPage;
    private int page = 1;
}
