package com.koreait.alsamo.board;

import com.koreait.alsamo.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService service;

    @GetMapping("/list")
    public String list(Model model, BoardDTO param){
        int listCnt = service.selBoardCount(param);
        Pagination pagination = new Pagination(listCnt, param.getPage());

        param.setStartIdx(pagination.getStartIndex());
        param.setCntPerPage(pagination.getPageSize());
        model.addAttribute("paging",pagination);
        model.addAttribute("boardList", service.selBoardList(param));
        return "board/list";
    }

    @GetMapping("/write")
    public String write(Model model,BoardDTO param){
        if(param.getBno() == 0){ //원글 작성시
            param.setBcd(1);
            model.addAttribute("categoryList",service.selBoardCategory());
        }else if(param.getModify() == 1){ //수정버튼 클릭시
            model.addAttribute("board",service.selBoard(param));
        }else {// 답글 작성시
            model.addAttribute("board",service.selBoard(param));
        }
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardEntity param) {
        if(param.getBidx() == 0){
            service.insBoard(param);
        }else{
            service.updReBoard(param);
            service.insReBoard(param);
        }
        return "redirect:list?bcd="+param.getBcd();
    }

    @GetMapping("/view")
    public String view(Model model, BoardDTO param){
        model.addAttribute("board", service.selBoard(param));
        return "board/view";
    }
    @GetMapping("/delete")
    public String delete(Model model,BoardDTO param){
        model.addAttribute("board", service.selBoard(param));
        return "board/check";
    }

    @PostMapping("/delete")
    public String delete(BoardEntity param){
        int result = service.delBoard(param);
        if(result == 0){
            return "redirect:/errpage?code="+result;
        }
        return "redirect:list?bcd="+param.getBcd();
    }

    @GetMapping("/modify")
    public String modify(Model model,BoardDTO param){
        model.addAttribute("board", service.selBoard(param));
        return "board/check";
    }

    @PostMapping("/modify")
    public String update(BoardEntity param){
        int result = service.updBoard(param);
        if(result == 0){
            return "redirect:/errpage?code="+result;
        }
        return "redirect:view?bcd="+param.getBcd()+"&bno="+param.getBno();
    }


}
