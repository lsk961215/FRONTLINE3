package com.spring.frontline.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.frontline.dao.MainDAO;
import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.UserDTO;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDAO mainDAO;

	@Override
	public List getUserList() {
		return mainDAO.selectUserList();
	}

	@Override
	public UserDTO getUser(UserDTO userDTO) {
		return mainDAO.selectUser(userDTO);
	}

	@Override
	public void insertUser(UserDTO userDTO) {
		mainDAO.insertUser(userDTO);
	}

	@Override
	public UserDTO doLogin(Map map) {
		return mainDAO.loginUser(map);
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		mainDAO.updateUser(userDTO);
	}

	@Override
	public void deleteUser(List list) {
		mainDAO.deleteUser(list);
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) {

		mainDAO.insertBoard(boardDTO);

	}

	@Override
	public int deleteBoard(String delete) {
		
		
		int deleteBoard = mainDAO.deleteBoard(delete);

		return deleteBoard;
	}
	
	@Override
	public BoardDTO updatePage(BoardDTO boardDTO) {

		return mainDAO.updatePage(boardDTO);
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		mainDAO.updateBoard(boardDTO);

	}

	@Override
	public Map pageBoard(int pageNum, int countPerPage) {

		int startNum = 0, endNum = 0;

		// 이전 페이지의 마지막 숫자 + 1
		startNum = ((pageNum - 1) * countPerPage) + 1;
		// pageNum이 1일때는 1 ~ 10 2일때는 11 ~ 20을 보여줌
		System.out.println("startNum : " + startNum);
		endNum = pageNum * countPerPage;
		System.out.println("endNum : " + endNum);
//				endNum = startNum + countPerPage - 1;

		BoardDTO dto = new BoardDTO();
		dto.setStartNum(startNum); // 1 , 11, 21
		dto.setEndNum(endNum); // 10, 20, 30

		// 보여줄 리스트만 쏙 뽑았음
		List list = mainDAO.pageBoard(dto); // 1 ~ 10 // 11 ~ 20 등등...
		System.out.println("list : " + list);

		// 전체 회원수를 뽑았음
		int total = mainDAO.pageTotal();
		System.out.println("total : " + total);

		Map map = new HashMap();
		map.put("list", list);
		map.put("total", total);

		return map;
	}

	@Override
	public List boardPick1(BoardDTO boardDTO) {
		System.out.println("pickService 1 : " + boardDTO);
		return mainDAO.boardPick1(boardDTO);
	}

	@Override
	public List boardPick2(BoardDTO boardDTO) {
		System.out.println("pickService 2 : " + boardDTO);
		return mainDAO.boardPick2(boardDTO);
	}


}
