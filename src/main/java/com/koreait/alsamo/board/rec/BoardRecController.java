package com.koreait.alsamo.board.rec;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.board.model.BoardRecDTO;
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
    public Map<String, Integer> regRec(@RequestBody BoardRecDTO param) {
        Map<String, Integer> data = new HashMap<>();
        data.put("result", service.insRec(param));
        return data;
    }

    @GetMapping("/rec/{bno}")
    public Map<String, Object> getRec(@PathVariable int bno,BoardRecDTO param) {
        Map<String, Object> result = new HashMap<>();
        param.setBno(bno);
        result.put("recCheck", service.selRecChk(param));
        result.put("result", service.selRec(param));
        return result;
    }

    @GetMapping("rec/today")
    public List<BoardDomain> getTodayRecList(BoardDTO param) {
        return service.selTodayRecList(param);
    }

    @GetMapping("rec/weekend")
    public List<BoardDomain> getWeekendRecList(BoardDTO param) {
        return service.selWeekendRecList(param);
    }

    @DeleteMapping("/rec/{bno}")
    public int delRec(@PathVariable int bno, BoardRecDTO param) {
        param.setBno(bno);
        return service.delRec(param);
    }

}
