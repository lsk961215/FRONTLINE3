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

REST, RESTful, REST api <br>
<br>
C	create	insert	post<br>
R	read	select	get<br>
U	update	update	put<br>
D	delele	delete	delete<br>

<!-- 업데이트를 위한 UI -->
<div style="border: 1px solid gray; border-radius: 10px; margin: 40px 0; padding: 10px;">
	<form action="emp2_update" method="post">
		empno : <input type="text" name="empno"><br>
		ename : <input type="text" name="ename"><br>
		<br>
		<input type="submit" value="수정">
	</form>
</div>

<!-- emp2 목록 표시 -->
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
		<c:forEach var="dto" items="${list }">
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


</body>
</html>