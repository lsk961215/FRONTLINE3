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
	//≥Ó∞≈∏Æ µÓ∑œ
	void insertPlay(BoardDTO boardDTO);
	//≥Ó∞≈∏Æ ¡∂»∏
	List getPlayList();
	//≥Ó∞≈∏Æ º±≈√
	BoardDTO playcorr(BoardDTO boardDTO);
	//≥Ó∞≈∏Æ ºˆ¡§
	void updatePlay(BoardDTO boardDTO);
	//≥Ó∞≈∏ÆªË¡¶
	int deletePlay(BoardDTO boardDTO);
}
