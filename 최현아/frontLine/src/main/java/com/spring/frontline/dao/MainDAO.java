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
	List travelList();
	void travelNew(BoardDTO dto);
}
