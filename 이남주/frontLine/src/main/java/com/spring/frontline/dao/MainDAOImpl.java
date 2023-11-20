package com.spring.frontline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.UserDTO;

@Repository
public class MainDAOImpl implements MainDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List selectUserList() {
		return sqlSession.selectList("user.selectUserList");
	}
	
	@Override
	public UserDTO selectUser(UserDTO userDTO) {
		return sqlSession.selectOne("user.selectUser", userDTO);
	}

	@Override
	public void insertUser(UserDTO userDTO) {
		sqlSession.insert("user.insertUser", userDTO);
	}

	@Override
	public UserDTO loginUser(Map map) {
		return sqlSession.selectOne("user.loginUser", map);
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		sqlSession.update("user.updateUser", userDTO);
	}

	@Override
	public void deleteUser(List list) {
		sqlSession.delete("user.deleteUser", list);
	}

	@Override
	public void insertBoardDTO(BoardDTO dto) {
		sqlSession.insert("user.insertBoard", dto);
	}
	
	@Override
	public List getBoardInfoList() {
		return sqlSession.selectList("user.selectBoard");
	}
	
	@Override
	public BoardDTO detailBoardDTO(BoardDTO dto) {
		return sqlSession.selectOne("user.selectDetailBoard", dto);
	}
	
	@Override
	public void updateBoardDTO(BoardDTO dto) {
		return sqlSession.update("user.updateDetailBoard", dto);
	}
	
}
