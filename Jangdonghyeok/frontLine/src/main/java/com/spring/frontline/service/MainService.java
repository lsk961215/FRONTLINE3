package com.spring.frontline.service;

import java.util.List;
import java.util.Map;

import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.UserDTO;

public interface MainService {
	UserDTO getUser(UserDTO userDTO);
	List getUserList();
	void insertUser(UserDTO userDTO);
	UserDTO doLogin(Map map);
	void updateUser(UserDTO userDTO);
	void deleteUser(List list);
	//��Ÿ� ���
	void insertPlay(BoardDTO boardDTO);
	//��Ÿ� ����Ʈ
	List getPlayList();
	//��Ÿ� ����
	BoardDTO getPlaycorr(BoardDTO boardDTO);
	//��Ÿ� ����
	void updatePlay(BoardDTO boardDTO);
	//��Ÿ� ����
	int deletePlay(BoardDTO boardDTO);
}


