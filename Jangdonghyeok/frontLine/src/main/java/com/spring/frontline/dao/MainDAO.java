package com.spring.frontline.dao;

import java.util.List;
import java.util.Map;

import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.UserDTO;

public interface MainDAO {
	List selectUserList();
	UserDTO selectUser(UserDTO userDTO);
	void insertUser(UserDTO userDTO);
	UserDTO loginUser(Map map);
	void updateUser(UserDTO userDTO);
	void deleteUser(List list);
	//��Ÿ� ���
	void insertPlay(BoardDTO boardDTO);
	//��Ÿ� ��ȸ
	List getPlayList();
	//��Ÿ� ����
	BoardDTO playcorr(BoardDTO boardDTO);
	//��Ÿ� ����
	void updatePlay(BoardDTO boardDTO);
	//��Ÿ�����
	int deletePlay(BoardDTO boardDTO);
}
