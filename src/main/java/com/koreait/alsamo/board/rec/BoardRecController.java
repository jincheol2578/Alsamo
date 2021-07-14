package com.koreait.alsamo.board.rec;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/board")
@RestController
public class BoardRecController {
    @Autowired
    BoardRecService service;

    @PostMapping("/rec")
    public int insRec(BoardDTO param){

        return service.insRec(param);
    }

    @GetMapping("/rec/{bno}")
    public Map<String, Integer> getRec(@PathVariable int bno){
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.selRec(bno));
        return result;
    }

    @GetMapping("rec/today")
    public List<BoardDomain> getTodayRecList(BoardDTO param){
        return service.selTodayRecList(param);
    }

    @GetMapping("rec/weekend")
    public List<BoardDomain> getWeekendRecList(BoardDTO param){
        return service.selWeekendRecList(param);
    }

    @DeleteMapping("/rec")
    public int delRec(BoardDTO param){
        return service.delRec(param);
    }

}
