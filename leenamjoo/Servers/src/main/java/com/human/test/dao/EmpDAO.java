package com.human.test.dao;

import java.util.List;
import java.util.Map;

import com.human.test.dto.EmpDTO;

public interface EmpDAO {

	public abstract List selectEmp();
	List selectEmp20();
	List deptno(int deptno);
	EmpDTO ename(EmpDTO dto);
	List searchEmp(EmpDTO dto);
	List foreach(List list);
	
	List selectEmp2();
	int updateEmp2(Map map);
	
	int insertDummy(EmpDTO dto);
	
	List emp2page(EmpDTO dto);
	int emp2total();
}
