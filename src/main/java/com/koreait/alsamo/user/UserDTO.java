package com.koreait.alsamo.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO extends UserEntity{
    private int startIdx;
    private int cntPerPage;
    private int page = 1;
    private String searchText;
    private int authno;
    private String upwChck;
}
