package com.spring.frontline.dao;

import java.util.List;
import java.util.Map;

import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.CommentDTO;
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
	List selectBoardList(Map map);
	List selectBoardPage(Map map);
	int selectBoardTotal(Map map);
	List selectRegionNames();
	BoardDTO selectBoard(BoardDTO boardDTO);
	void addComment(CommentDTO commentDTO);
	List selectCommentList(BoardDTO boardDTO);
	List selectCommentPage(Map map);
	int selectCommentTotal();
	CommentDTO selectComment(CommentDTO commentDTO);
	void updateComment(CommentDTO commentDTO);
	void deleteComment(List list);
}
