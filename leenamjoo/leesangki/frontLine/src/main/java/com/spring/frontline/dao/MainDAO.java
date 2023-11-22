package com.spring.frontline.dao;

import java.util.List;
import java.util.Map;

import com.spring.frontline.dto.UserDTO;

public interface MainDAO {
	List selectUserList();
	UserDTO selectUser(UserDTO userDTO);
	void insertUser(UserDTO userDTO);
	UserDTO loginUser(Map map);
	void updateUser(UserDTO userDTO);
	void deleteUser(List list);
	int selectUserTotal();
	List selectUserPage(Map map);
	void insertDummy(UserDTO userDTO);
	UserDTO findId(UserDTO userDTO);
	UserDTO findPw(UserDTO userDTO);
	boolean checkId(Map map);
	boolean checkEmail(Map map);
	boolean checkPhone(Map map);
}
