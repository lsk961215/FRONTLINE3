<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 | 휴먼</title>
</head>
<body>
<h1>emp 검색</h1>
<!-- <form method="get" action="../search"> -->
<form method="get" action="/mybatis/search">
	ename : <input type="text" name="ename"><br>
	deptno : <input type="text" name="deptno" value="0"><br>
	sal : <input type="text" name="sal" value="0"><br>
	<br>
	<input type="submit" value="검색">
</form>
</body>
</html>