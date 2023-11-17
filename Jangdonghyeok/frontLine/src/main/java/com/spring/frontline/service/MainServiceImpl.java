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
	
	//��Ÿ� ���
	@Override
	public void insertPlay(BoardDTO boardDTO) {
		mainDAO.insertPlay(boardDTO);
	}
	//��Ÿ� ����Ʈ
	@Override
	public List getPlayList() {
		List playList = mainDAO.getPlayList();
		return playList;
	}
	// ��Ÿ� ����
	@Override
	public BoardDTO getPlaycorr(BoardDTO boardDTO) {
		BoardDTO playOne = mainDAO.playcorr(boardDTO);
		
		return playOne;
	}
	//��Ÿ� ����
	@Override
	public void updatePlay(BoardDTO boardDTO) {
		mainDAO.updatePlay(boardDTO);
	}
	//��Ÿ� ����
		@Override
		public int deletePlay(BoardDTO boardDTO) {
			int delete = mainDAO.deletePlay(boardDTO);
			return delete;
		}
	
}
