package com.spring.frontline.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.frontline.dao.MainDAO;
import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.CommentDTO;
import com.spring.frontline.dto.UserDTO;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	MainDAO mainDAO;
	
	@Override
	public List getUserList() {
		return mainDAO.selectUserList();
	}
	
	@Override
	public UserDTO getUser(UserDTO userDTO) {
		return mainDAO.selectUser(userDTO);
	}
	
	@Override
	public void insertUser(UserDTO userDTO) {
		mainDAO.insertUser(userDTO);
	}

	@Override
	public UserDTO doLogin(Map map) {
		return mainDAO.loginUser(map);
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		mainDAO.updateUser(userDTO);
	}

	@Override
	public void deleteUser(List list) {
		mainDAO.deleteUser(list);
	}

	@Override
	public Map getUserPage(Map selectMap) {
		int pageNum = (Integer) selectMap.get("pageNum");
		int countPerPage = (Integer) selectMap.get("countPerPage");
		
		int startNum = 0;
		int endNum = 0;
		
		startNum = (pageNum-1)*countPerPage+1;
		endNum = pageNum*countPerPage;
		
		selectMap.put("startNum", startNum);
		selectMap.put("endNum", endNum);
		
		List list = mainDAO.selectUserPage(selectMap);
		int total = mainDAO.selectUserTotal(selectMap);
		
		int groupCount = 5;
		
		int totalPaging = (int) Math.ceil((double)total / countPerPage);
		
		int position = (int) Math.ceil((double)pageNum / groupCount);
		
		int beginPaging = (position-1) * groupCount + 1;
		int endPaging = position * groupCount;
		
		if(endPaging > totalPaging) {
			endPaging = totalPaging;
		}
		
		Map pageMap = new HashMap();
		
		pageMap.put("beginPaging", beginPaging);
		pageMap.put("endPaging", endPaging);
		pageMap.put("totalPaging", totalPaging);
		pageMap.put("list", list);
		
		return pageMap;
	}

	@Override
	public void insertDummy(int loop) {
		UserDTO dto = new UserDTO();
		
		for(int i = 0; i<loop; i++) {
			dto.setUserName("test" + i);
			dto.setGenderSeq(0);
			dto.setGradeSeq(0);
			dto.setUserBirth("12345678");
			dto.setUserEmail("test" + i + "@frontline.com");
			dto.setUserId("test" + i);
			dto.setUserPhone("01012345678"+i);
			dto.setUserPw("1234");
			
			mainDAO.insertDummy(dto);
		}
	}
	
	@Override
	public UserDTO findId(UserDTO userDTO) {
		return mainDAO.findId(userDTO);
	}
	
	@Override
	public UserDTO findPw(UserDTO userDTO) {
		return mainDAO.findPw(userDTO);
	}

	@Override
	public boolean checkJoin(Map map) {
		if("checkId".equals(map.get("target"))) {
			System.out.println("service id 실행");
			return mainDAO.checkId(map);
		} else if("checkEmail".equals(map.get("target"))) {
			System.out.println("service email 실행");
			return mainDAO.checkEmail(map);
		} else {
			System.out.println("service phone 실행");
			return mainDAO.checkPhone(map);
		}
	}

	@Override
	public Map getBoardList(String regionSeq) {
		
		Map selectMap = new HashMap();
		
		Map resultMap = new HashMap();
		
		selectMap.put("regionSeq", regionSeq);
		
		for(int i = 0; i<4; i++) {
			selectMap.put("typeSeq", i);
			
			List list = mainDAO.selectBoardList(selectMap);
			
			resultMap.put("typeSeq"+i, list);
		}
		
		return resultMap;
	}
	
	@Override
	public Map getBoardPage(Map map) {
		
		int startNum = 0;
		int endNum = 0;
		
		int pageNum = (Integer) map.get("pageNum");
		int countPerPage = (Integer) map.get("countPerPage");
		
		startNum = (pageNum-1)*countPerPage+1;
		endNum = pageNum*countPerPage;
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("pageNum", pageNum);
		map.put("countPerPage", countPerPage);
		
		List list = mainDAO.selectBoardPage(map);
		int total = mainDAO.selectBoardTotal(map);
		
		int groupCount = 5;
		
		int totalPaging = (int) Math.ceil((double)total / countPerPage);
		
		int position = (int) Math.ceil((double)pageNum / groupCount);
		
		int beginPaging = (position-1) * groupCount + 1;
		int endPaging = position * groupCount;
		
		if(endPaging > totalPaging) {
			endPaging = totalPaging;
		}
		
		Map pageMap = new HashMap();
		
		pageMap.put("beginPaging", beginPaging);
		pageMap.put("endPaging", endPaging);
		pageMap.put("totalPaging", totalPaging);
		pageMap.put("list", list);
		
		return pageMap;
	}

	@Override
	public List getRegionNames() {
		return mainDAO.selectRegionNames();
	}

	@Override
	public BoardDTO getBoard(BoardDTO boardDTO) {
		return mainDAO.selectBoard(boardDTO);
	}

	@Override
	public void addComment(CommentDTO commentDTO) {
		mainDAO.addComment(commentDTO);
	}

	@Override
	public List getCommentList(BoardDTO boardDTO) {
		return mainDAO.selectCommentList(boardDTO);
	}

	@Override
	public Map getCommentPage(Map selectMap) {
		int pageNum = (Integer) selectMap.get("pageNum");
		int countPerPage = (Integer) selectMap.get("countPerPage");
		
		int startNum = 0;
		int endNum = 0;
		
		startNum = (pageNum-1)*countPerPage+1;
		endNum = pageNum*countPerPage;
		
		selectMap.put("startNum", startNum);
		selectMap.put("endNum", endNum);
		
		List list = mainDAO.selectCommentPage(selectMap);
		int total = mainDAO.selectCommentTotal(selectMap);
		
		int groupCount = 5;
		
		int totalPaging = (int) Math.ceil((double)total / countPerPage);
		
		int position = (int) Math.ceil((double)pageNum / groupCount);
		
		int beginPaging = (position-1) * groupCount + 1;
		int endPaging = position * groupCount;
		
		if(endPaging > totalPaging) {
			endPaging = totalPaging;
		}
		
		Map pageMap = new HashMap();
		
		pageMap.put("beginPaging", beginPaging);
		pageMap.put("endPaging", endPaging);
		pageMap.put("totalPaging", totalPaging);
		pageMap.put("list", list);
		
		return pageMap;
	}

	@Override
	public CommentDTO getComment(CommentDTO commentDTO) {
		return mainDAO.selectComment(commentDTO);
	}

	@Override
	public void updateComment(CommentDTO commentDTO) {
		mainDAO.updateComment(commentDTO);
	}

	@Override
	public void deleteComment(List list) {
		mainDAO.deleteComment(list);
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		mainDAO.insertBoard(boardDTO);
	}
	
	@Override
	public Map getAdminBoardPage(Map selectMap) {
		
		int countPerPage = (Integer)selectMap.get("countPerPage");
		int pageNum = (Integer)selectMap.get("pageNum");
		int startNum = 0;
		int endNum = 0;
		
		startNum = (pageNum-1)*countPerPage+1;
		endNum = pageNum*countPerPage;
		
		selectMap.put("startNum", startNum);
		selectMap.put("endNum", endNum);
		
		List list = new ArrayList();
		
		int total = 0;
		
		if(selectMap.get("searchText") == null || "".equals(selectMap.get("searchText"))) {
			list = mainDAO.selectAdminBoardPage(selectMap);
			total = mainDAO.selectAdminBoardTotal(selectMap);
		} else {
			list = mainDAO.selectAdminBoardSearchPage(selectMap);
			total = mainDAO.selectAdminBoardSearchTotal(selectMap);
		}
		
		
		int groupCount = 5;
		
		int totalPaging = (int) Math.ceil((double)total / countPerPage);
		
		int position = (int) Math.ceil((double)pageNum / groupCount);
		
		int beginPaging = (position-1) * groupCount + 1;
		int endPaging = position * groupCount;
		
		if(endPaging > totalPaging) {
			endPaging = totalPaging;
		}
		
		Map pageMap = new HashMap();
		
		pageMap.put("beginPaging", beginPaging);
		pageMap.put("endPaging", endPaging);
		pageMap.put("totalPaging", totalPaging);
		pageMap.put("list", list);
		
		return pageMap;
	}

	@Override
	public void deleteBoard(List list) {
		mainDAO.deleteBoard(list);
	}

	@Override
	public BoardDTO getAdminBoard(BoardDTO boardDTO) {
		return mainDAO.getAdminBoard(boardDTO);
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		mainDAO.updateBoard(boardDTO);
	}

	@Override
	public List getBoardInfoList() {
		
		 return mainDAO.getBoardInfoList();
	}

	@Override
	public void deleteBoardDTO(List list) {
		 mainDAO.deleteBoardDTO(list);
	}
	
	@Override
	public BoardDTO detailBoardDTO(BoardDTO dto) {
		 return mainDAO.detailBoardDTO(dto);
	}
	
	@Override
	public void updateBoardDTO(BoardDTO dto) {
		 mainDAO.updateBoardDTO(dto);
	}
	
	@Override
	public void travelNew(BoardDTO dto) {
		 mainDAO.travelNew(dto);
	}
	
	@Override
	public List travelList() {
		return mainDAO.travelList();
		
	}
}
