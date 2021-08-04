package com.koreait.alsamo.user.info;

import com.koreait.alsamo.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class InfoUserController {
    @Autowired
    private InfoService service;
    int listCnt = 0;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String infoUser(@RequestParam("uno") int param, Model model) {
        InfoUserDTO dto = new InfoUserDTO();
        dto.setUno(param);
        dto.setBoardList(service.selAllWrite(dto));
        dto.setReplyList(service.selAllReply(dto));
        dto.setCountReplyList(service.selAllReplyCount(param));
        dto.setCountBoardList(service.selAllWriteCount(param));


        model.addAttribute("infoUser", dto);
        return "user/info";
    }

    @RequestMapping(value = "/infowrite", method = RequestMethod.GET)
    public String infoUserWriteGet(@RequestParam("uno") int param,
                                   @RequestParam("page") int page, Model model) {
        InfoUserDTO dto = new InfoUserDTO();
        dto.setUno(param);
        listCnt = service.selBoardCount(dto);

        Pagination pagination = new Pagination(listCnt, page);
        dto.setStartIdx(pagination.getStartIndex());
        dto.setCntPerPage(pagination.getPageSize());

        dto.setBoardList(service.selAllWrite(dto));
        dto.setCountBoardList(service.selAllWriteCount(param));

        model.addAttribute("paging", pagination);
        model.addAttribute("infoUser", dto);
        return "user/infoWrite";
    }

    @RequestMapping(value = "/inforeply", method = RequestMethod.GET)
    public String infoUserReply(@RequestParam("uno") int param,
                                @RequestParam("page") int page, Model model) {
        InfoUserDTO dto = new InfoUserDTO();
        dto.setUno(param);
        listCnt = service.selReplyCount(dto);

        Pagination pagination = new Pagination(listCnt, page);
        dto.setStartIdx(pagination.getStartIndex());
        dto.setCntPerPage(pagination.getPageSize());

        dto.setReplyList(service.selAllReply(dto));
        dto.setCountReplyList(service.selAllReplyCount(param));
        model.addAttribute("paging", pagination);
        model.addAttribute("infoUser", dto);
        return "user/infoReply";
    }


}
