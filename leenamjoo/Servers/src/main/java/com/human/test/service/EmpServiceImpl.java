package com.human.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.test.dao.EmpDAO;
import com.human.test.dto.EmpDTO;

@Service
public class EmpServiceImpl implements EmpService {

//	EmpDAO empDAO = new EmpDAOImpl();
	@Autowired
	EmpDAO empDAO;
	
	@Override
	public List empList() {
		
		List empList = empDAO.selectEmp();
		
		return empList;
	}

	@Override
	public List empList20() {
		List empList = empDAO.selectEmp20();
		
		return empList;
	}

	@Override
	public List deptno(int deptno) {
		List empList = empDAO.deptno(deptno);
		
		return empList;
	}

	@Override
	public EmpDTO ename(EmpDTO dto) {
		EmpDTO empDTO = empDAO.ename(dto);
		return empDTO;
	}
	
	@Override
	public List searchEmp(EmpDTO dto) {
		List empList = empDAO.searchEmp(dto);
		return empList;
	}

	@Override
	public List foreach(List list) {
		List empList = empDAO.foreach(list);
		return empList;
	}

	@Override
	public List getEmp2() {
		List empList = empDAO.selectEmp2();
		return empList;
	}

	@Override
	public int setEmp2(Map map) {
		
		return empDAO.updateEmp2(map);
	}

	@Override
	public void insertDummy(int loop) {
		
		for(int i=0; i<loop; i++) {
			EmpDTO dto = new EmpDTO();
			
			/*ename, 
			deptno, 
			sal, */
			dto.setEname("사원"+i);
			dto.setSal(i*100);
			
			// 10, 20, 30, 40 번갈아 가면서 넣기
			int deptno = ((i % 4) + 1) * 10;
			dto.setDeptno(deptno);

			empDAO.insertDummy(dto);
		}
		
	}

	@Override
	public Map getEmp2Page(int pageNum, int countPerPage) {
		
		int startNum = 0, endNum = 0;
		
		// 이전 페이지의 마지막 숫자 + 1
		startNum = ( (pageNum-1) * countPerPage ) + 1;
		endNum = pageNum * countPerPage;
//		endNum = startNum + countPerPage - 1;
		
		EmpDTO dto = new EmpDTO();
		dto.setStartNum(startNum);
		dto.setEndNum(endNum);
		
		// 보여줄 리스만 쏙 뽑았음
		List list = empDAO.emp2page(dto);
		
		// 전체 회원수를 뽑았음
		int total = empDAO.emp2total();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("total", total);
		
		return map;
	}
}
