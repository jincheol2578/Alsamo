package com.koreait.alsamo.board.notice;

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

    @GetMapping("/notice/{bcd}")
    public List<BoardDomain> selNoticeList(@PathVariable int bcd){
        return service.selNoticeList(bcd);
    }

    @PostMapping("/notice/{bno}")
    public Map<String, Integer> insNotice(@PathVariable int bno){
        Map<String,Integer> data = new HashMap<>();
        data.put("notice", service.insNotice(bno));
        return data;
    }

    @DeleteMapping("/notice/{bno}")
    public Map<String, Integer> delNotice(@PathVariable int bno){
        Map<String,Integer> data = new HashMap<>();
        data.put("notice", service.delNotice(bno));
        return data;
    }
}
