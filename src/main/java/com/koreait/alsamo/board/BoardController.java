package com.koreait.alsamo.board;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.board.model.BoardEntity;
import com.koreait.alsamo.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService service;

    int listCnt = 0;

    @GetMapping("/list")
    public String list(Model model, BoardDTO param) {
        listCnt = service.selBoardCount(param);
        Pagination pagination = new Pagination(listCnt, param.getPage());
        param.setStartIdx(pagination.getStartIndex());
        param.setCntPerPage(pagination.getPageSize());

        model.addAttribute("paging", pagination);
        model.addAttribute("boardList", service.selBoardList(param));
        return "board/list";
    }

    @ResponseBody
    @GetMapping("/mainList/{bcd}")
    public Map<String,List<BoardDomain>> getBoardList(@PathVariable int bcd) {
        Map<String,List<BoardDomain>> data = new TreeMap<>();
        data.put("board", service.selMainBoardList(bcd));
        return data;
    }


    @GetMapping("/write")
    public String write(Model model, BoardDTO param) {
        BoardDomain board = service.selBoard(param);
        if (param.getBno() == 0) { //원글 작성시
            model.addAttribute("categoryList", service.selBoardCategory());
        } else if (param.getModify() == 1) { //수정버튼 클릭시
            if (board.getBpw().equals(param.getBpw())) {
                model.addAttribute("board", board);
            } else {
                return "board/errpage";
            }
        } else {// 답글 작성시
            model.addAttribute("reBoard", service.selBoard(param));
        }
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardEntity param) {
        System.out.println(param);
        if (param.getBidx() == 0) {
            service.insBoard(param);
        } else {
            service.updReBoard(param);
            service.insReBoard(param);
        }
        return "redirect:list?bcd=" + param.getBcd();
    }

    @GetMapping("/view")
    public String view(Model model, BoardDTO param) {
        service.updBoardHit(param.getBno());
        model.addAttribute("board", service.selBoard(param));
        return "board/view";
    }

    @GetMapping("/delete")
    public String delete(Model model, BoardDTO param) {
        model.addAttribute("board", service.selBoard(param));
        return "board/check";
    }

    @PostMapping("/delete")
    public String delete(BoardEntity param) {
        int result = service.delBoard(param);
        if (result == 0) {
            return "redirect:/errpage?code=" + result;
        }
        return "redirect:list?bcd=" + param.getBcd();
    }

    @GetMapping("/modify")
    public String modify(Model model, BoardDTO param) {
        model.addAttribute("board", service.selBoard(param));
        return "board/check";
    }

    @PostMapping("/modify")
    public String modify(BoardEntity param) {
        int result = service.updBoard(param);
        if (result == 0) {
            return "redirect:/errpage?code=" + result;
        }
        return "redirect:view?bcd=" + param.getBcd() + "&bno=" + param.getBno();
    }


}
