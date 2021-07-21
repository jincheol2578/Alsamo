package com.koreait.alsamo.user.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class InfoUserController {
    @Autowired
    private InfoService service;

    @RequestMapping(value = "/info", method=RequestMethod.GET)
    public String infoUser(@RequestParam("uno") int param, Model model){
        InfoUserDTO dto = new InfoUserDTO();

        dto.setBoardList(service.selAllWrite(param));
        dto.setReplyList(service.selAllReply(param));
        dto.setCountReplyList(service.selAllReplyCount(param));
        dto.setCountBoardList(service.selAllWriteCount(param));

        System.out.println(dto);
//        System.out.println(dto.getReplyList());
//        System.out.println(dto.getBoardList());

        model.addAttribute("infoUser",dto);
        return "user/info";
    }
}
