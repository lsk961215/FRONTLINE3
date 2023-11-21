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
	//놀거리 등록
	void insertPlay(BoardDTO boardDTO);
	//놀거리 조회
	List getPlayList();
	//놀거리 선택
	BoardDTO playcorr(BoardDTO boardDTO);
	//놀거리 수정
	void updatePlay(BoardDTO boardDTO);
	//놀거리삭제
	int deletePlay(BoardDTO boardDTO);
	//놀거리 페이징
	List Paging(BoardDTO boardDTO);
	//페이지 토탈
	int pageTotal();
	//놀거리 더보기 페이징
	List morePaging(BoardDTO boardDTO);
}
