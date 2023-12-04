package com.spring.frontline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.UserDTO;

@Repository
public class MainDAOImpl implements MainDAO {

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

	// ��Ÿ� ���
	@Override
	public void insertPlay(BoardDTO boardDTO) {
		sqlSession.insert("board.insertBoard", boardDTO);
	}

	// ��Ÿ� ����Ʈ ��ȸ
	@Override
	public List getPlayList() {
		List PlayList = sqlSession.selectList("board.selectBoardPlay");

		return PlayList;
	}

	// ��Ÿ� ����
	@Override
	public BoardDTO playcorr(BoardDTO boardDTO) {
		System.out.println("baordDAO" + boardDTO.getBoardSeq());
		BoardDTO PlayOne = sqlSession.selectOne("board.selectPlayOne", boardDTO);
		System.out.println("DAOimpl : " + PlayOne);
		return PlayOne;
	}

	// ��Ÿ� ����
	@Override
	public void updatePlay(BoardDTO boardDTO) {
		sqlSession.update("board.updatePlay", boardDTO);
	}

	// ��Ÿ� ����
	@Override
	public int deletePlay(BoardDTO boardDTO) {
		int delete = sqlSession.update("board.playDelete", boardDTO);
		return delete;
	}

	// ��Ÿ� ���� ����¡
	@Override
	public List Paging(BoardDTO boardDTO) {
		List playList = sqlSession.selectList("board.playPage",boardDTO );

		
		return playList;
	}

	// ��Ÿ� �Ѱ���
	@Override
	public int pageTotal() {
		int total = sqlSession.selectOne("board.boardTotal");

		return total;
	}
	// ��Ÿ� ������ ����¡
		
	@Override
		public List morePaging(BoardDTO boardDTO) {
			List playList = sqlSession.selectList("board.playMorePage",boardDTO );

			return playList;
		}
	// ��Ÿ� ������ �Ѱ���
		@Override
		public int moreTotal(BoardDTO boardDTO) {
			int total = sqlSession.selectOne("board.playTotal",boardDTO);

			return total;
		}
	
}
