package com.koreait.alsamo.user.info;

import com.koreait.alsamo.board.model.BoardReplyEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class InfoReplyDTO extends BoardReplyEntity {
    private String bnm;
    private int bcd;
    private int bno;
    private String repnm;
}
