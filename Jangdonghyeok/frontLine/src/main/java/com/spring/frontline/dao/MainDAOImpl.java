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

	// ³î°Å¸® µî·Ï
	@Override
	public void insertPlay(BoardDTO boardDTO) {
		sqlSession.insert("board.insertBoard", boardDTO);
	}

	// ³î°Å¸® ¸®½ºÆ® Á¶È¸
	@Override
	public List getPlayList() {
		List PlayList = sqlSession.selectList("board.selectBoardPlay");

		return PlayList;
	}

	// ³î°Å¸® ¼±ÅÃ
	@Override
	public BoardDTO playcorr(BoardDTO boardDTO) {
		System.out.println("baordDAO" + boardDTO.getBoardSeq());
		BoardDTO PlayOne = sqlSession.selectOne("board.selectPlayOne", boardDTO);
		System.out.println("DAOimpl : " + PlayOne);
		return PlayOne;
	}

	// ³î°Å¸® ¼öÁ¤
	@Override
	public void updatePlay(BoardDTO boardDTO) {
		sqlSession.update("board.updatePlay", boardDTO);
	}

	// ³î°Å¸® »èÁ¦
	@Override
	public int deletePlay(BoardDTO boardDTO) {
		int delete = sqlSession.update("board.playDelete", boardDTO);
		return delete;
	}

	// ³î°Å¸® °ü¸® ÆäÀÌÂ¡
	@Override
	public List Paging(BoardDTO boardDTO) {
		List playList = sqlSession.selectList("board.playPage",boardDTO );

		
		return playList;
	}

	// ³î°Å¸® ÃÑ°¹¼ö
	@Override
	public int pageTotal() {
		int total = sqlSession.selectOne("board.boardTotal");

		return total;
	}
	// ³î°Å¸® ´õº¸±â ÆäÀÌÂ¡
		
	@Override
		public List morePaging(BoardDTO boardDTO) {
			List playList = sqlSession.selectList("board.playMorePage",boardDTO );

			return playList;
		}
	// ³î°Å¸® ´õº¸±â ÃÑ°¹¼ö
		@Override
		public int moreTotal(BoardDTO boardDTO) {
			int total = sqlSession.selectOne("board.playTotal",boardDTO);

			return total;
		}
	
}
