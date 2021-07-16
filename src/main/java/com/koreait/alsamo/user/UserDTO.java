package com.koreait.alsamo.user;

import lombok.Data;

@Data
public class UserDTO {
    private int startIdx;
    private int cntPerPage;
    private int page = 1;

    private String searchText;

    private int authno;
}
