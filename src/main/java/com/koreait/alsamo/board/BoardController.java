package com.koreait.alsamo.board;

import com.koreait.alsamo.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService service;

    @GetMapping("/list")
    public String list(Model model, BoardDTO param){
        model.addAttribute("boardList", service.selBoardList(param));
        return "board/list";
    }

    @GetMapping("/write")
    public String write(Model model,BoardDTO param){
        if(param.getIboard() == 0){ //원글 작성시
            model.addAttribute("categoryList",service.selBoardCategory());
        }else{ // 답글 작성시

        }

        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardEntity param) {
        System.out.println(param);
        return "redirect:detail?iboard="+service.insBoard(param);
    }

    @GetMapping("/detail")
    public String detail(Model model, BoardDTO param){
        model.addAttribute("board", service.selBoard(param));
        return "board/detail";
    }


}
