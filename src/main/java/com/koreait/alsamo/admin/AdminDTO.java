package com.koreait.alsamo.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminDTO {
    private int[] delChk;
    private int bcd;
    private String bnm;
    private String[] tags;
}
