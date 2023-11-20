package com.spring.frontline.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.frontline.dao.MainDAO;
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
	public Map getUserPage(int pageNum, int countPerPage) {
		
		Map selectMap = new HashMap();
		
		int startNum = 0;
		int endNum = 0;
		
		startNum = (pageNum-1)*countPerPage+1;
		endNum = pageNum*countPerPage;
		
		selectMap.put("startNum", startNum);
		selectMap.put("endNum", endNum);
		
		List list = mainDAO.selectUserPage(selectMap);
		int total = mainDAO.selectUserTotal();
		
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
			return mainDAO.checkId(map);
		} else if("checkEmail".equals(map.get("target"))) {
			return mainDAO.checkEmail(map);
		} else {
			return mainDAO.checkPhone(map);
		}
	}
}
