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

    final String uri = "https://ko.wikipedia.org/wiki/";

    @RequestMapping("/alcoholList")
    public String alcoholList(Model model) {
        Document doc1 = null;
        Elements name1 = null;
        Elements contents1 = null;
        String img1 = null;
        String[] kinds1 = {"위스키"};
        List<Element> elemList1 = new ArrayList<>();
        AlcoholVO vo = new AlcoholVO();
        StringBuilder sb = new StringBuilder();
        try {
            doc1 = Jsoup.connect(uri + kinds1[0]).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109").get();
            name1 = doc1.select("#firstHeading");
//            img1 = doc1.select("img").attr("src");
            contents1 = doc1.select("p");

            for (Element content : contents1) {
                elemList1.add(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        vo.setName(name1.text());
        if (elemList1.size() > 5) {
            int maxCount = 5;
            for (int i = 0; i < maxCount; i++) {
                sb.append(elemList1.get(i).text());
            }
        } else {
            for (int i = 0; i < elemList1.size(); i++) {
                sb.append(elemList1.get(i).text());
            }
        }
        vo.setContent(sb.toString());
        model.addAttribute("alcohol", vo);
        return "alcohol/alcoholList";
    }

    @ResponseBody
    @RequestMapping(value = "/alcoholList", method = RequestMethod.POST)
    public AlcoholVO searchName(@RequestBody AlcoholVO param) {
        Document doc2 = null;
        Elements name2 = null;
        Elements contents2 = null;
        String img2 = null;
        List<Element> elemList2 = new ArrayList<>();
        AlcoholVO vo = new AlcoholVO();
        StringBuilder sb = new StringBuilder();

        try {
            doc2 = Jsoup.connect(uri + param.getName()).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109").get();
            name2 = doc2.select("#firstHeading");
            img2 = doc2.select("img").attr("src");
            contents2 = doc2.select("p");

            for (Element content : contents2) {
                elemList2.add(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        vo.setName(name2.text());
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
        vo.setContent(sb.toString());

        System.out.println(vo.toString());
        return vo;

    }
}
