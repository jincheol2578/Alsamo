package com.koreait.alsamo.board;

import com.koreait.alsamo.MyUtils;
import com.koreait.alsamo.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;

    @Autowired
    private MyUtils myUtils;

    //게시글 등록
    public int insBoard(BoardEntity param){
        param.setUno(myUtils.getUserPk());
        return mapper.insBoard(param);
    }

    //게시판 메뉴
    public List<BoardDTO> selBoardCategory(){
        return mapper.selBoardCategory();
    }
    //게시글 리스트 가져오기
    public List<BoardDomain> selBoardList(BoardDTO param){
        param.setUno(myUtils.getUserPk());
        return mapper.selBoardList(param);
    }
    //게시글 가져오기
    public BoardDomain selBoard(BoardDTO param){
        param.setUno(myUtils.getUserPk());
        return mapper.selBoard(param);
    }
    //페이징 처리 (페이징)
    public int selBoardCount(BoardDTO param){
        return mapper.selBoardCount(param);
    }
    //게시글 답글 등록
    public int insReBoard(BoardEntity param){
        param.setUno(myUtils.getUserPk());
        return mapper.insReBoard(param);
    }
    //게시글 답글 등록-2 순서 정리를 위한 업데이트문
    public int updReBoard(BoardEntity param){
        return mapper.updReBoard(param);
    }
    //게시글 삭제
    public int delBoard(BoardEntity param){
        param.setUno(myUtils.getUserPk());
        try {
            return mapper.delBoard(param);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    //게시글 수정
    public int updBoard(BoardEntity param){
        param.setUno(myUtils.getUserPk());
        try{
            return mapper.updBoard(param);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
