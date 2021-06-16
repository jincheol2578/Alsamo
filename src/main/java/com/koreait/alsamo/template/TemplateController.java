package com.koreait.alsamo.template;

import com.koreait.alsamo.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @Autowired
    BoardService boardService;

    @GetMapping("header")
    public void category(Model model){
        System.out.println(boardService.selBoardCategory());
        model.addAttribute("categoryList", boardService.selBoardCategory());
    }
}
