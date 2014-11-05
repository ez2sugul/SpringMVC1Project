package com.multicampus.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. 사용자 입력정보 추출(검색 기능은 나중에...)
		
		// 2. DB 연동
		BoardVO vo = new BoardVO();

		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo); 
		
		ModelAndView mav = new ModelAndView();
		// 3. 응답 화면 구성
		
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		// ModelAndView에 저장된 데이터는 request에 자동으로 등록된다.
		return mav;
	}

}




