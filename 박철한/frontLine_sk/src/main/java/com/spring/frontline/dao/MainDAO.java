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
	
	public void insertBoard(BoardDTO boardDTO);
	public int deleteBoard(String delete);
	
	public BoardDTO updatePage(BoardDTO boardDTO);
	public void updateBoard(BoardDTO boardDTO);
	
	public List pageBoard(BoardDTO boardDTO);
	public int pageTotal();
	
	List boardPick1(BoardDTO dto);
	List boardPick2(BoardDTO dto);
}
