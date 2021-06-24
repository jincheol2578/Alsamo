package com.koreait.alsamo.board.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("board/view")
public class BoardReplyController {

    @Autowired
    BoardReplyService service;


}
