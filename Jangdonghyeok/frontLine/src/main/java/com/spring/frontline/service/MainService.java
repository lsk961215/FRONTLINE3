package com.spring.frontline.service;

import java.util.List;
import java.util.Map;

import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.CommentDTO;
import com.spring.frontline.dto.UserDTO;

public interface MainService {
	UserDTO getUser(UserDTO userDTO);
	List getUserList();
	void insertUser(UserDTO userDTO);
	UserDTO doLogin(Map map);
	void updateUser(UserDTO userDTO);
	void deleteUser(List list);
	Map getUserPage(int pageNum, int countPerPage);
	void insertDummy(int loop);
	UserDTO findId(UserDTO userDTO);
	UserDTO findPw(UserDTO userDTO);
	boolean checkJoin(Map map);
	Map getBoardList(String regionSeq);
	Map getBoardPage(Map map);
	List getRegionNames();
	BoardDTO getBoard(BoardDTO boardDTO);
	void addComment(CommentDTO commentDTO);
	List getCommentList(BoardDTO boardDTO);
	Map getCommentPage(int pageNum, int countPerPage);
	CommentDTO getComment(CommentDTO commentDTO);
	void updateComment(CommentDTO commentDTO);
	void deleteComment(List list);
}
