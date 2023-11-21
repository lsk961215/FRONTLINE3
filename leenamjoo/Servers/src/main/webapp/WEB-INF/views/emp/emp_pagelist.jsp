<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- emp2 목록 표시 -->
<div style="">
총 글의 개수 : ${data.total } 개
</div>
<table border=1>
	<thead>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${data.list }">
			<tr>
				<td>${dto.empno }</td>
				<td>${dto.ename }</td>
				<td>${dto.job }</td>
				<td>${dto.mgr }</td>
				<td>${dto.hiredate }</td>
				<td>${dto.sal }</td>
				<td>${dto.comm }</td>
				<td>${dto.deptno }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div>
<%@ page import="java.util.*" %>

<%
	// model에 넣은 "data" 가져오기
	Map data = (Map) request.getAttribute("data");

	int total = (Integer) data.get("total");
	int pageNum = (Integer) data.get("pageNum");
	// 한번에 보여줄 글의 개수
	int countPerPage = (Integer) data.get("countPerPage");
	
	
	// 전체 페이지의 수
	// 올림 ( 전체 글의 수 / 한번에 보여줄 글의 수 )
	// 12 / 5 >> 2.4 >> ceil결과 3.0 >> int 변수에 저장 >> 3
	int totalPaging = (int) Math.ceil( (double)total / countPerPage );
	
	// 한번에 보여줄 페이지의 개수
	int groupCount = 10;
	
	// 현제 페이지가 몇번째 그룹에 있는지
	int position = (int) Math.ceil( (double)pageNum / groupCount );
	
	// 현재 그룹에 첫번째 페이지 번호
	int beginPaging = ((position-1) * groupCount) + 1;
	int endPaging = position * groupCount;
	
	if(endPaging > totalPaging){
		endPaging = totalPaging;
	}

	
	if(beginPaging == 1){
		out.println("[이전]");
	} else {
		out.println("<a href='emp2page?pageNum="+ (beginPaging-1) +"'>[이전]</a>");
	}

	for(int i=beginPaging; i<=endPaging; i++){
		if(i == pageNum){
			out.println("<a href='emp2page?pageNum="+ i +"'><strong>["+ i +"]</strong></a>");
		} else {
			out.println("<a href='emp2page?pageNum="+ i +"'>["+ i +"]</a>");
		}
	}
	
	if(endPaging == totalPaging){
		out.println("[다음]");
	} else {
		out.println("<a href='emp2page?pageNum="+ (endPaging+1) +"'>[다음]</a>");
	}
%>
</div>




</body>
</html>