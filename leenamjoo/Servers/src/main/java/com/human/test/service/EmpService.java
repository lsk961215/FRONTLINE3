package com.human.test.service;

import java.util.List;
import java.util.Map;

import com.human.test.dto.EmpDTO;

public interface EmpService {

	List empList();
	List empList20();
	List deptno(int deptno);
	EmpDTO ename(EmpDTO dto);
	List searchEmp(EmpDTO dto);
	List foreach(List list);
	List getEmp2();
	int setEmp2(Map map);
	
	void insertDummy(int loop);
	
	Map getEmp2Page(int pageNum, int countPerPage);
}
