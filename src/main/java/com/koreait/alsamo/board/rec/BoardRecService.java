package com.koreait.alsamo.board.rec;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardRecService {
    @Autowired
    BoardRecMapper mapper;
    @Autowired
    MyUtils myUtils;

    public int insRec(BoardDTO param){
        int result = 0;

        try{
            if(myUtils.getLoginUser() != null){param.setUno(myUtils.getUserPk());}
            result = mapper.insRec(param);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
    public int selRec(int bno){
        return mapper.selRec(bno);
    }

    public List<BoardDomain> selTodayRecList(BoardDTO param){
        return mapper.selTodayRecList(param);
    }
    public List<BoardDomain> selWeekendRecList(BoardDTO param){
        return mapper.selWeekendRecList(param);
    }

    public int delRec(BoardDTO param){
        int result = 0;

        try{
            if(myUtils.getLoginUser() != null){param.setUno(myUtils.getUserPk());}
            result = mapper.delRec(param);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
