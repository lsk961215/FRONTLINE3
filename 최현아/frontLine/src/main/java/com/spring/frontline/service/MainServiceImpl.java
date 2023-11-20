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

	
}
