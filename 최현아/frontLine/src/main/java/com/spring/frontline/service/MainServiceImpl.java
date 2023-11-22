package com.spring.frontline.service;

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
	public List travelList() {
		return mainDAO.travelList();
		
	}

	@Override
	public void travelNew(BoardDTO dto) {
		 mainDAO.travelNew(dto);
	}

	@Override
	public void travelDelete(String[] boardDelete) {
		mainDAO.travelDelete(boardDelete);
	}

	@Override
	public BoardDTO travelUpdate(BoardDTO dto) {
		return mainDAO.travelUpdate(dto);
	}

	@Override
	public void setBoard(BoardDTO dto) {
		mainDAO.setBoard(dto);		
	}

	@Override
	public List boardPick1(BoardDTO dto) {
		return mainDAO.boardPick1(dto);
		
	}

	@Override
	public List boardPick2(BoardDTO dto) {
		return mainDAO.boardPick2(dto);
		
	}

	@Override
	public List boardPick3(BoardDTO dto) {
		return mainDAO.boardPick3(dto);
		
	}

	@Override
	public List boardPick4(BoardDTO dto) {
		return mainDAO.boardPick4(dto);
		
	}

	@Override
	public void insertDummy(int loop) {
		for(int i = 0; i<loop; i++) {
			// dto를 반복문 밖에서 생성하면 기존게 남아있을 수 있어서 for문 안에다 생성
			BoardDTO dto = new BoardDTO();
			dto.setBoardTitle("testTitle" + i);
			dto.setBoardAddress("testAddress" + i);
			dto.setBoardDetail("testDetail" + i);
			dto.setBoardPhone("testPhone" + i);
			dto.setRegionSeq(i/15);
			dto.setUserSeq(i);
			dto.setTypeSeq(0);
			dto.setBoardOpen("x");
			dto.setBoardBreak("x");
			System.out.println(dto.getBoardTitle());
			
			mainDAO.insertDummy(dto);
		}
		
		
	}

	
}
