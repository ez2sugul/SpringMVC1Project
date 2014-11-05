package com.multicampus.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// 1. �˻��� �Խñ� ��ȣ(seq) ����
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. ���� ȭ�� ����
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return "getBoard.jsp";
	}

}



