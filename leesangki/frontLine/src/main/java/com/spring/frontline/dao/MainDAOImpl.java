package com.spring.frontline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public int selectUserTotal() {
		return sqlSession.selectOne("user.userTotal");
	}

	@Override
	public List selectUserPage(Map map) {
		
		List userList = sqlSession.selectList("user.userPage", map);
		
		return userList;
	}

	@Override
	public void insertDummy(UserDTO userDTO) {
		sqlSession.insert("user.insertDummy", userDTO);
	}

	@Override
	public UserDTO findId(UserDTO userDTO) {
		return sqlSession.selectOne("user.findId", userDTO);
	}
	
	@Override
	public UserDTO findPw(UserDTO userDTO) {
		return sqlSession.selectOne("user.findPw", userDTO);
	}

}
