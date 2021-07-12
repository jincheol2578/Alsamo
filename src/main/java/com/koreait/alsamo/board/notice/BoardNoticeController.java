package com.koreait.alsamo.board.notice;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/board")
@RestController
public class BoardNoticeController {
    @Autowired
    BoardNoticeService service;

    @GetMapping("/notice")
    public List<BoardDomain> selNoticeList(BoardDTO param){

        return service.selNoticeList(param);
    }

    @PostMapping("/notice")
    public Map<String, Integer> insNotice(BoardDTO param){
        Map<String,Integer> data = new HashMap<>();
        data.put("notice", service.insNotice(param));
        return data;
    }

    @DeleteMapping("/notice")
    public Map<String, Integer> delNotice(BoardDTO param){
        Map<String,Integer> data = new HashMap<>();
        data.put("notice", service.delNotice(param));
        return data;
    }
}
