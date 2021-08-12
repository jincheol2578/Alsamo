package com.koreait.alsamo.board.reply;

import com.koreait.alsamo.board.model.BoardReplyDomain;
import com.koreait.alsamo.board.model.BoardReplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/reply/{idx}")
    public Map<String, Integer> insRelpy(@RequestBody BoardReplyEntity param,@PathVariable int idx) {
        int result = 0;
        if(idx == 0){
            result = service.insReply(param);
        }else{
            result = service.insReReply(param);
        }
        Map<String, Integer> data = new HashMap<>();
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

    // 사용 X
/*    @PutMapping("/reply")
    public Map<String, Integer> updReply(@RequestBody BoardReplyEntity param){
        int result = service.updReply(param);
        Map<String,Integer> data = new HashMap<>();

        data.put("result", result);
        return data;
    }*/
}
