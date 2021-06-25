package com.koreait.alsamo.board.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/board/view")
public class BoardReplyController {

    @Autowired
    BoardReplyService service;

    @GetMapping("/reply")
    public Map<String, Integer> insReply(){
        Map<String, Integer> data = new HashMap<>();
        return data;
    }
}
