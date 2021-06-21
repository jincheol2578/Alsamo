package com.koreait.alsamo.tiles;

import com.koreait.alsamo.board.BoardService;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("menuPreparer")
public class MenuPreparer implements ViewPreparer {
    @Autowired
    BoardService service;

    @Override
    public void execute(Request request, AttributeContext attributeContext) {
        attributeContext.putAttribute("menuList", new Attribute(service.selBoardCategory()),true);
    }
}
