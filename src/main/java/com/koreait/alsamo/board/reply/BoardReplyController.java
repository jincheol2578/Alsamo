package com.koreait.alsamo.board.reply;

import com.koreait.alsamo.board.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardReplyController {

    @Autowired
    BoardReplyService service;

    @GetMapping("/reply/{bno}")
    public List<BoardReplyDomain> selReplyList(BoardReplyEntity param, @PathVariable int bno){
        param.setBno(bno);
        return service.selReplyList(param);
    }

    @PostMapping("/reply")
    public Map<String, Integer> insRelpy(@RequestBody BoardReplyEntity param){
        int result = service.insReply(param);
        Map<String,Integer> data = new HashMap<>();

        data.put("result", result);
        return data;
    }

    @DeleteMapping("/reply")
    public Map<String, Integer> delReply(@RequestBody BoardReplyEntity param){
        int result = service.delReply(param);
        Map<String,Integer> data = new HashMap<>();

        data.put("result", result);
        return data;
    }
}
