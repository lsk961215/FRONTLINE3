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

	public void insertBoard(BoardDTO boardDTO);
	public int deleteBoard(String delete);
	
	public BoardDTO updatePage(BoardDTO boardDTO);
	public void updateBoard(BoardDTO boardDTO);
	
	public Map pageBoard(int pageNum, int countPerPage);
	
	public List boardPick1(BoardDTO boardDTO);
	public List boardPick2(BoardDTO boardDTO);
}
