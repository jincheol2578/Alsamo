package com.koreait.alsamo.board;

import com.koreait.alsamo.board.model.BoardDTO;
import com.koreait.alsamo.board.model.BoardDomain;
import com.koreait.alsamo.board.model.BoardEntity;
import com.koreait.alsamo.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardMapper mapper;

    @Autowired
    private MyUtils myUtils;

    //게시글 등록
    public int insBoard(BoardEntity param) {
        if (myUtils.getLoginUser() != null) {
            param.setUno(myUtils.getUserPk());
        }
        return mapper.insBoard(param);
    }

    //게시판 메뉴
    public List<BoardDTO> selBoardCategory() {
        return mapper.selBoardCategory();
    }

    //게시글 리스트 가져오기
    public List<BoardDomain> selBoardList(BoardDTO param) {
        return mapper.selBoardList(param);
    }

    //메인 게시판 리스트 가져오기
    public List<BoardDomain> selMainBoardList(int bcd) {
        return mapper.selMainBoardList(bcd);
    }

    //게시글 가져오기
    public BoardDomain selBoard(BoardDTO param) {
        return mapper.selBoard(param);
    }

    //조회수 증가
    public int updBoardHit(int bno) {
        return mapper.updBoardHit(bno);
    }

    //페이징 처리 (페이징)
    public int selBoardCount(BoardDTO param) {
        return mapper.selBoardCount(param);
    }

    //게시글 답글 등록
    public int insReBoard(BoardEntity param) {
        if (myUtils.getLoginUser() != null) {
            param.setUno(myUtils.getUserPk());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < param.getBdept(); i++) {
            sb.append("　");
        }
        sb.append("└　");
        sb.append(param.getBtitle());
        param.setBtitle(sb.toString());
        return mapper.insReBoard(param);
    }

    //게시글 답글 등록-2 순서 정리를 위한 업데이트
    public int updReBoard(BoardEntity param) {
        return mapper.updReBoard(param);
    }

    //게시글 삭제
    public int delBoard(BoardEntity param) {
        if (myUtils.getLoginUser() != null) {
            param.setUno(myUtils.getUserPk());
        }
        return mapper.delBoard(param);
    }

    //게시글 수정
    public int updBoard(BoardEntity param) {
        if (myUtils.getLoginUser() != null) {
            param.setUno(myUtils.getUserPk());
        }
        return mapper.updBoard(param);
    }
}
