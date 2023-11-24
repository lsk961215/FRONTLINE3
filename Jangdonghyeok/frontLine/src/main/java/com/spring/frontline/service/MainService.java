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
	//놀거리 등록
	void insertPlay(BoardDTO boardDTO);
	//놀거리 리스트
	List getPlayList();
	//놀거리 선택
	BoardDTO getPlaycorr(BoardDTO boardDTO);
	//놀거리 수정
	void updatePlay(BoardDTO boardDTO);
	//놀거리 삭제
	int deletePlay(BoardDTO boardDTO);
	//놀거리 관리 페이징
	Map getPage(int pageNum, int countPerPage);
	//놀거리 더보기 페이징
	Map getMorePage(int regiSeq ,int pageNum, int countPerPage, int typeSeq);

}


