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
	public void insertBoardDTO(BoardDTO dto) {
		// TODO Auto-generated method stub
		mainDAO.insertBoardDTO(dto);
	}

	@Override
	public List getBoardInfoList() {
		 return mainDAO.getBoardInfoList();
	}
	
	@Override
	public BoardDTO detailBoardDTO(BoardDTO dto) {
		 return mainDAO.detailBoardDTO(dto);
	}
	
	@Override
	public void updateBoardDTO(BoardDTO dto) {
		 mainDAO.updateBoardDTO(dto);
	}
	
}
