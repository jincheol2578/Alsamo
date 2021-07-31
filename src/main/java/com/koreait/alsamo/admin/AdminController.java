package com.koreait.alsamo.admin;

import com.koreait.alsamo.common.Pagination;
import com.koreait.alsamo.user.UserDTO;
import com.koreait.alsamo.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping()
    public String login() {
        return "/admin/login";
    }

    //    로그인
    @PostMapping("/login")
    public String login(UserEntity param, Model model) {
        return "redirect:" + service.login(param);
    }

    //    로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

    //    메인화면
    @GetMapping("/main")
    public String main() {
        return "admin/main";
    }

    //    게시판관리
    @GetMapping("/board")
    public String board() {
        return "admin/board";
    }

    @GetMapping("/user")
    public String user() {
        return "admin/user";
    }

    @ResponseBody
    @PostMapping("/user/list")
    public Map<String, Object> getUserList(@RequestBody UserDTO param) {
        int listCnt = service.getUserCount(param);
        Pagination pagination = new Pagination(listCnt, param.getPage());
        Map<String, Object> data = new HashMap<>();

        param.setStartIdx(pagination.getStartIndex());
        param.setCntPerPage(pagination.getPageSize());
        data.put("paging", pagination);
        data.put("userList", service.getUserList(param));
        return data;
    }

    @ResponseBody
    @PatchMapping("/user")
    public Map<String, Integer> updUser(@RequestBody UserDTO param) {
        Map<String, Integer> data = new HashMap<>();
        data.put("result", service.updUser(param));
        return data;
    }

    //    게시판 리스트
    @ResponseBody
    @PostMapping("/board")
    public Map<String, Object> getBoardList(@RequestBody AdminDTO param) {
        param.setTags(service.getTags());
        int listCnt = service.getBoardCount(param);
        Pagination pagination = new Pagination(listCnt, param.getPage());
        Map<String, Object> data = new HashMap<>();

        param.setStartIdx(pagination.getStartIndex());
        param.setCntPerPage(pagination.getPageSize());
        data.put("paging", pagination);
        data.put("boardList", service.getBoardList(param));
        return data;
    }

    //    게시글 선택 삭제
    @ResponseBody
    @DeleteMapping("/board")
    public Map<String, Integer> delBoard(@RequestBody AdminDTO param) {
        Map<String, Integer> data = new HashMap<>();
        data.put("result", service.delBoard(param));
        return data;
    }

    //    카테고리 관리
    @ResponseBody
    @PostMapping("/category")
    public Map<String, Integer> regCategory(@RequestBody BoardCategoryDTO param) {
        Map<String, Integer> data = new HashMap<>();
        data.put("result", service.regCategory(param));
        return data;
    }

    @ResponseBody
    @GetMapping("/category")
    public Map<String, List<BoardCategoryDTO>> getCategoryList() {
        Map<String, List<BoardCategoryDTO>> data = new TreeMap<>();
        data.put("result", service.getCategoryList());
        return data;
    }

    @ResponseBody
    @PatchMapping("/category")
    public Map<String, Integer> updCategory(@RequestBody BoardCategoryDTO param) {
        Map<String, Integer> data = new HashMap<>();
        data.put("result", service.updCategory(param));
        return data;
    }

    @ResponseBody
    @PatchMapping("/category/ord")
    public Map<String, Integer> updCategoryOrd(@RequestBody BoardCategoryDTO param) {
        Map<String, Integer> data = new HashMap<>();
        data.put("result", service.updCategoryOrd(param));
        return data;
    }

    @ResponseBody
    @DeleteMapping("/category")
    public Map<String, Integer> delCategory(@RequestBody BoardCategoryDTO param) {
        Map<String, Integer> data = new HashMap<>();
        System.out.println(param);
        data.put("result", service.delCategory(param));
        return data;
    }

    //    태그관리
    @ResponseBody
    @PostMapping("/tag")
    public Map<String, Integer> regTag(@RequestBody BlockTags tags) {
        int result = service.regTag(tags);
        Map<String, Integer> data = new HashMap<>();
        data.put("result", result);
        return data;
    }

    @ResponseBody
    @GetMapping("/tag")
    public Map<String, List<BlockTags>> getTags() {
        Map<String, List<BlockTags>> data = new HashMap<>();
        data.put("tags", service.getTags());
        return data;
    }

    @ResponseBody
    @DeleteMapping("/tag/{tno}")
    public Map<String, Integer> delTag(@PathVariable int tno) {
        int result = service.delTag(tno);
        Map<String, Integer> data = new HashMap<>();
        data.put("result", result);
        return data;
    }


}


