package com.koreait.alsamo.alcohol;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/alcohol")
public class AlcoholController {

    final String URI = "https://ko.wikipedia.org/wiki/";
    final String IMGCLASS = "img.thumbimage";
    final String ALCOHOLNAME = "#firstHeading";
    final String USERAGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109";
    final String TABLE = ".infobox.hrecipe.hproduct";

    @RequestMapping("/alcoholList")
    public String alcoholList(Model model) {
//        Document doc1 = null;
//        Elements name1 = null;
//        Elements contents1 = null;
//        Elements img1 = null;
//        Elements table1 = null;
//        String kinds = "위스키";
//
//        List<Element> elemList1 = new ArrayList<>();
//        AlcoholVO vo = new AlcoholVO();
//        StringBuilder sb = new StringBuilder();
//
//        try {
//            doc1 = Jsoup.connect(URI + kinds).userAgent(USERAGENT).get();
//            name1 = doc1.select(ALCOHOLNAME);
//            contents1 = doc1.select("p");
//            img1 = doc1.select(IMGCLASS);
//            table1 = doc1.select(TABLE);
//            for (Element content : contents1) {
//                elemList1.add(content);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        if (elemList1.size() > 5) {
//            int maxCount = 5;
//            for (int i = 0; i < maxCount; i++) {
//                sb.append(elemList1.get(i).text());
//            }
//        } else {
//            for (int i = 0; i < elemList1.size(); i++) {
//                sb.append(elemList1.get(i).text());
//            }
//        }
//        vo.setName(name1.text());
//        vo.setContent(sb.toString());
//        vo.setAlImg(img1.attr("src"));
//        vo.setAlTable(table1.html());
//
//        model.addAttribute("alcohol", vo);
        return "alcohol/alcoholList";
    }

    @ResponseBody
    @RequestMapping(value = "/alcoholList", method = RequestMethod.POST)
    public AlcoholVO searchName(@RequestBody AlcoholVO param) {
        Document doc2 = null;
        Elements name2 = null;
        Elements contents2 = null;
        Elements img2 = null;
        Elements table2 = null;


        List<Element> elemList2 = new ArrayList<>();
        AlcoholVO vo = new AlcoholVO();
        StringBuilder sb = new StringBuilder();

        try {
            doc2 = Jsoup.connect(URI + param.getName()).userAgent(USERAGENT).get();
            name2 = doc2.select(ALCOHOLNAME);
            contents2 = doc2.select("#content");
            img2 = doc2.select(IMGCLASS);
            table2 = doc2.select(TABLE);


            for (Element content : contents2) {
                elemList2.add(content);
            }

            if (elemList2.size() > 5) {
                int maxCount = 5;
                for (int i = 0; i < maxCount; i++) {
                    sb.append(elemList2.get(i).text());
                }
            } else {
                for (int i = 0; i < elemList2.size(); i++) {
                    sb.append(elemList2.get(i).text());
                }
            }

            vo.setContent(contents2.html());
            vo.setName(name2.text());
            vo.setAlTable(table2.html());
            vo.setAlImg(img2.attr("src"));

            System.out.println(vo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vo;

    }
}
