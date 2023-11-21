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
	public List travelList() {
		return sqlSession.selectList("user.travelList");
	}

	@Override
	public void travelNew(BoardDTO dto) {
		sqlSession.insert("user.travelNew", dto);
		
	}

	@Override
	public void travelDelete(String[] boardDelete) {
		sqlSession.delete("user.travelDelete", boardDelete);
	}

	@Override
	public BoardDTO travelUpdate(BoardDTO dto) {
		return sqlSession.selectOne("user.travelUpdate", dto);
	}

	@Override
	public void setBoard(BoardDTO dto) {
		sqlSession.update("user.setBoard", dto);
		
	}

	@Override
	public List boardPick1(BoardDTO dto) {
		System.out.println("boardPick1()에서dto.getSearch : " + dto.getBoardSearch());
		return sqlSession.selectList("user.boardPick1",dto);
	}

	@Override
	public List boardPick2(BoardDTO dto) {
		System.out.println("boardPick2()에서dto.getSearch : " + dto.getBoardSearch());
		return sqlSession.selectList("user.boardPick2",dto);
		
	}

	@Override
	public List boardPick3(BoardDTO dto) {
		System.out.println("boardPick3()에서dto.getSearch : " + dto.getBoardSearch());
		return sqlSession.selectList("user.boardPick3",dto);
	}

	@Override
	public List boardPick4(BoardDTO dto) {
		System.out.println("boardPick4()에서dto.getSearch : " + dto.getBoardSearch());
		return sqlSession.selectList("user.boardPick4",dto);
	}


	

}
