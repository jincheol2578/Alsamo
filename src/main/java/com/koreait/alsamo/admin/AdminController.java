package com.koreait.alsamo.admin;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.common.Pagination;
import com.koreait.alsamo.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping
    public String main(){
        return "admin/main";
    }
    @GetMapping("board")
    public String board(Model model, BoardDTO param){
        int listCnt = service.getBoardCount(param);
        Pagination pagination = new Pagination(listCnt, param.getPage());

        param.setStartIdx(pagination.getStartIndex());
        param.setCntPerPage(pagination.getPageSize());
        model.addAttribute("boardList", service.getBoardList(param));
        return "admin/board";
    }
    @GetMapping("category")
    public String category(){
        return "admin/category";
    }
    @GetMapping("user")
    public String user(){
        return "admin/user";
    }

    @PostMapping("/login")
    public String login(UserEntity param, Model model){
        model.addAttribute("loginMsg", service.login(param));
        return "redirect:main";
    }
    @ResponseBody
    @PostMapping("/tag") //TODO:tname에 null들어감
    public Map<String,Integer> regTag(String tname){
        int result = service.regTag(tname);
        Map<String,Integer> data = new HashMap<>();
        data.put("result", result);
        return data;
    }
}

