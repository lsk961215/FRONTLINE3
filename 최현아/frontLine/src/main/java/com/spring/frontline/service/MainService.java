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
	List travelList();
	void travelNew(BoardDTO dto);
	void travelDelete(String[] boardDelete);
	BoardDTO travelUpdate(BoardDTO dto);
	void setBoard(BoardDTO dto);
	List boardPick1(BoardDTO dto);
	List boardPick2(BoardDTO dto);
	List boardPick3(BoardDTO dto);
	List boardPick4(BoardDTO dto);
	// ����¡ ���
	void insertDummy(int loop);
	
	// �˾�
	List popup1();
	Map popupReadyUpdate(Map map);
	void popupUpdate(Map map);
	
	// ��й�ȣ ã��
	UserDTO sameId(UserDTO userDTO);
}
