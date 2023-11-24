package com.spring.frontline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.CommentDTO;
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

	@Override
	public boolean checkId(Map map) {
		UserDTO userDTO = sqlSession.selectOne("user.checkId", map);
		
		if(userDTO == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkEmail(Map map) {
		UserDTO userDTO = sqlSession.selectOne("user.checkEmail", map);
		
		if(userDTO == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkPhone(Map map) {
		UserDTO userDTO = sqlSession.selectOne("user.checkPhone", map);
		
		if(userDTO == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List selectBoardList(Map map) {
		return sqlSession.selectList("board.selectBoardList", map);
	}
	
	@Override
	public List selectBoardPage(Map map) {
		List boardList = sqlSession.selectList("board.selectBoardPage", map);

		return boardList;
	}
	
	@Override
	public int selectBoardTotal(Map map) {
		int total = sqlSession.selectOne("board.selectBoardTotal", map);

		return total;
	}

	@Override
	public List selectRegionNames() {
		return sqlSession.selectList("board.selectRegionNames");
	}

	@Override
	public BoardDTO selectBoard(BoardDTO boardDTO) {
		return sqlSession.selectOne("board.selectBoard", boardDTO);
	}

	@Override
	public void addComment(CommentDTO commentDTO) {
		sqlSession.insert("comment.insertComment", commentDTO);
	}

	@Override
	public List getComment(BoardDTO boardDTO) {
		return sqlSession.selectList("comment.selectComment", boardDTO);
	}

}
