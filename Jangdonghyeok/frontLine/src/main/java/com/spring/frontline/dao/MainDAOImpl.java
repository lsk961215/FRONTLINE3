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

	//놀거리 등록
	@Override
	public void insertPlay(BoardDTO boardDTO) {
		sqlSession.insert("board.insertBoard", boardDTO);
	}
	//놀거리 리스트 조회
	@Override
	public List getPlayList() {
		List PlayList = sqlSession.selectList("board.selectBoardPlay");
		
		return PlayList;
	}
	// 놀거리 선택
	@Override
	public BoardDTO playcorr(BoardDTO boardDTO) {
		System.out.println("baordDAO" + boardDTO.getBoardSeq());
		BoardDTO PlayOne = sqlSession.selectOne("board.selectPlayOne", boardDTO);
		System.out.println("DAOimpl : " +PlayOne);
		return PlayOne;
	}
	//놀거리 수정
		@Override
		public void updatePlay(BoardDTO boardDTO) {
			sqlSession.update("board.updatePlay",boardDTO);
		}
		//놀거리 삭제
		@Override
		public int deletePlay(BoardDTO boardDTO) {
			int delete = sqlSession.update("board.playDelete",boardDTO);
			return delete;
		}
	

}
