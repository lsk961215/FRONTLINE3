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
	
	// 관리자 - 여행지
	List travelList();
	void travelNew(BoardDTO dto);
	void travelDelete(String[] boardDelete);
	BoardDTO travelUpdate(BoardDTO dto);
	void setBoard(BoardDTO dto);
	List boardPick1(BoardDTO dto);
	List boardPick2(BoardDTO dto);
	List boardPick3(BoardDTO dto);
	List boardPick4(BoardDTO dto);
	
	// 페이징
	int insertDummy(BoardDTO dto);
	// 팝업
	List popup1();
	Map popupReadyUpdate(Map map);
	void popupUpdate(Map map);
	
	// 비밀번호 찾기
	UserDTO sameId(UserDTO userDTO);
	void updateNewPw(UserDTO userDTO);
	
}
