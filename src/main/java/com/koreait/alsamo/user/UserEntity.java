package com.koreait.alsamo.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEntity {
    private int uno;
    private int authno;
    private String uemail;
    private String uid;
    private String upw;
    private String unm;
    private String urdt;
    private String authkey;
    private String profileImg;
}