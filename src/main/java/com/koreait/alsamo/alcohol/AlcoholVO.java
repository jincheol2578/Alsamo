package com.koreait.alsamo.alcohol;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jsoup.select.Elements;

@Getter
@Setter
@ToString
public class AlcoholVO {
    private int pk;
    private String name;
    private String content;
    private String alTable;
    private String alImg;
    private String searchresults;
}
