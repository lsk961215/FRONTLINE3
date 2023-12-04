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
	public void insertBoard(BoardDTO boardDTO) {
		
		sqlSession.insert("user.insertBoard", boardDTO);
	}

	@Override
	public int deleteBoard(String delete) {
											// <-									
		int deleteBoard = sqlSession.delete("user.deleteBoard", delete);
		// 삭제를 하면 1을 돌려줌
		
		return deleteBoard;
		
	}

	@Override
	public BoardDTO updatePage(BoardDTO boardDTO) {

		return sqlSession.selectOne("user.updatePage", boardDTO);
	}
	
	@Override
	public void updateBoard(BoardDTO boardDTO) {
//		System.out.println("boardDTO : " + boardDTO);
		sqlSession.update("user.updateBoard", boardDTO);
		
	}

	@Override
	public List pageBoard(BoardDTO boardDTO) {
		
	    List pageBoard = sqlSession.selectList("user.pageBoard", boardDTO);
	    
		return pageBoard;
	}

	@Override
	public int pageTotal() {
		
		int total = sqlSession.selectOne("user.pageTotal");
		return total;
	}

	@Override
	public List boardPick1(BoardDTO boardDTO) {
		System.out.println("pickDAO 1 : " + boardDTO);
		List list = sqlSession.selectList("user.boardPick1", boardDTO);
		System.out.println("dao list pick1 : " + list);
		return list;
	}

	@Override
	public List boardPick2(BoardDTO boardDTO) {
		System.out.println("pickDAO 1 : " + boardDTO);
		return sqlSession.selectList("user.boardPick2", boardDTO);

	}



	

}
