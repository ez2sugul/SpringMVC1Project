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
		// 1. ����� �Է����� ����(�˻� ����� ���߿�...)
		
		// 2. DB ����
		BoardVO vo = new BoardVO();

		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo); 
		
		ModelAndView mav = new ModelAndView();
		// 3. ���� ȭ�� ����
		
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		// ModelAndView�� ����� �����ʹ� request�� �ڵ����� ��ϵȴ�.
		return mav;
	}

}




