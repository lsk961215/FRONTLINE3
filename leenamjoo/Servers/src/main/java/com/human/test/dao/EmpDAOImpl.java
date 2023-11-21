package com.human.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.test.dto.EmpDTO;

@Repository
public class EmpDAOImpl implements EmpDAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List selectEmp() {

		// db 접속 준비(url, id, pw 등을 확보, driver 파악)
		// db 접속
		// sql 실행 준비
		// sql 실행
		// 결과를 확보
		// 결과를 가공
		List<EmpDTO> empList = sqlSession.selectList("id_emp.selectEmp");
		
		System.out.println("empList.size : "+ empList.size());
		System.out.println("empList.get(0) : "+ empList.get(0));
		
		return empList;
	}

	public List selectEmp20() {

		List empList = sqlSession.selectList("id_emp.selectEmp20");
		
		return empList;
	}

	@Override
	public List deptno(int deptno) {
		
		List empList = sqlSession.selectList("id_emp.deptno", deptno);
		
		return empList;
	}

	@Override
	public EmpDTO ename(EmpDTO dto) {
//		EmpDTO empDTO = sqlSession.selectOne("id_emp.ename", dto);
		EmpDTO empDTO = sqlSession.selectOne("id_emp.ename_like", dto);
		return empDTO;
	}

	@Override
	public List searchEmp(EmpDTO dto) {
		List empList = sqlSession.selectList("id_emp.if_ename_like", dto);
		return empList;
	}

	@Override
	public List foreach(List list) {
		List empList = sqlSession.selectList("id_emp.foreach", list);
		return empList;
	}

	@Override
	public List selectEmp2() {
		List empList = sqlSession.selectList("id_emp.selectEmp2");
		return empList;
	}

	@Override
	public int updateEmp2(Map map) {
		
		int result = sqlSession.update("id_emp.updateEmp2", map);
		System.out.println("result : "+ result);
		
//		sqlSession.insert("id_emp.updateEmp2", map);
//		sqlSession.delete("id_emp.updateEmp2", map);
		return result;
	}

	@Override
	public int insertDummy(EmpDTO dto) {
		int result = sqlSession.insert("id_emp.insertDummy", dto);
		System.out.println("insertDummy result : "+ result);
		
		return result;
	}

	@Override
	public List emp2page(EmpDTO dto) {
		List<EmpDTO> empList = sqlSession.selectList("id_emp.emp2page", dto);
		return empList;
	}

	@Override
	public int emp2total() {
		int total = sqlSession.selectOne("id_emp.emp2total");
		return total;
	}
	
	

}
