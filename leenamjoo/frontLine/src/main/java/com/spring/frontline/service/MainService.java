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
	void insertBoardDTO(BoardDTO dto);
	List getBoardInfoList(int pageNum, int countPerPage);
	BoardDTO detailBoardDTO(BoardDTO dto);
	void updateBoardDTO(BoardDTO dto);
	void deleteBoardDTO(List list);
}
