package com.koreait.alsamo.admin;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.common.Pagination;
import com.koreait.alsamo.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
//    게시판 리스트
    @ResponseBody
    @GetMapping("/board")
    public Map<String,Object> getBoardList(@RequestBody BoardDTO param){
        int listCnt = service.getBoardCount(param);
        Pagination pagination = new Pagination(listCnt, param.getPage());
        Map<String,Object> data = new HashMap<>();

        param.setStartIdx(pagination.getStartIndex());
        param.setCntPerPage(pagination.getPageSize());
        data.put("paging", pagination);
        data.put("boardList", service.getBoardList(param));
        return data;
    }
//    게시글 선택 삭제
//    요청 예제
//   {
//    "delChk": [
//        1,
//        2,
//        3
//    ]
//}
//
    @ResponseBody
    @DeleteMapping("/board")
    public Map<String,Integer> delBoard(@RequestBody AdminDTO param){
        Map<String,Integer> data = new HashMap<>();
        System.out.println(param);
        data.put("result", service.delBoard(param));
        return data;
    }

//    카테고리 관리
    @ResponseBody
    @PostMapping("/category")
    public Map<String,Integer> regCategory(@RequestBody BoardCategoryDTO param){
        Map<String,Integer> data = new HashMap<>();
        data.put("result",service.regCategory(param));
        return data;
    }
    @ResponseBody
    @GetMapping("/category")
    public List<BoardCategoryDTO> getCategoryList() {
        return service.getCategoryList();
    }
    @ResponseBody
    @PatchMapping("/category")
    public Map<String,Integer> updCategory(@RequestBody BoardCategoryDTO param){
        Map<String,Integer> data = new HashMap<>();
        data.put("result", service.updCategory(param));
        return data;
    }
    @ResponseBody
    @PatchMapping("/category/ord")
    public Map<String,Integer> updCategoryOrd(@RequestBody BoardCategoryDTO param){
        Map<String,Integer> data = new HashMap<>();
        data.put("result", service.updCategoryOrd(param));
        return data;
    }
    @ResponseBody
    @DeleteMapping("/category")
    public Map<String,Integer> delCategory(@RequestBody BoardCategoryDTO param){
        Map<String,Integer> data = new HashMap<>();
        data.put("result", service.delCategory(param));
        return data;
    }

//    유저 관리
    @GetMapping("/user")
    public String user(){
        return "admin/user";
    }
//    로그인
    @PostMapping("/login")
    public String login(UserEntity param, Model model){
        model.addAttribute("loginMsg", service.login(param));
        return "redirect:main";
    }
//    태그관리
    @ResponseBody
    @PostMapping("/tag")
    public Map<String,Integer> regTag(@RequestBody BlockTags tags){
        int result = service.regTag(tags);
        Map<String,Integer> data = new HashMap<>();
        data.put("result", result);
        return data;
    }
    @ResponseBody
    @GetMapping("/tag")
    public List<BlockTags> getTags(){
        return service.getTags();
    }
    @ResponseBody
    @DeleteMapping("/tag/{tno}")
    public Map<String,Integer> delTag(@PathVariable int tno){
        int result = service.delTag(tno);
        Map<String, Integer> data = new HashMap<>();
        data.put("result",result);
        return data;
    }


}

