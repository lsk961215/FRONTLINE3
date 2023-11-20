<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 헤더 자바스크립트 -->
<!-- 어드민 헤더만 자바스크립트로 헤더 스타일 변경해줌 -->
<script src="resources/js/header_admin.js"></script>
<!-- 헤더 스타일 -->
<link rel="stylesheet" href="resources/css/header.css">
<!-- 관리자 메뉴 스타일 -->
<link rel="stylesheet" href="resources/css/admin_aside.css">
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<script>
	$("document").ready(function(){
		// 수정버튼
		$("input[class=editButton]").click(function(){
			$("input[name=userSeq]").val($(this).parent().parent().find("input[type=checkbox]").attr("name"))
			$("input[id=getUser]").click()
		})
		
		// 페이지 이동
		$("a[id=page_num_button]").click(function(){
			$("#page_num").val($(this).attr("value"))
			$("#page_num_submit").click()
		})
		
		// prev 버튼
		$("input[id=prevPage]").click(function(){
			$("input[id=pageNumber]").val(${pageNumber}-1);
		})
		
		// next 버튼
		$("input[id=nextPage]").click(function(){
			$("input[id=pageNumber]").val(${pageNumber}+1);
		})
	})
</script>
<style>
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<main>
		<jsp:include page="admin_aside.jsp"/>
		<section>
			<div class="section_title">
				<h1>회원 목록</h1>
			</div>
			
			<form action="deleteUser">
			
			<table border=1>
				<thead>
					<tr>
						<th>선택</th>
						<th>번호</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이름</th>
						<th>등급</th>
						<th>성별</th>
						<th>생일</th>
						<th>이메일</th>
						<th>전화번호</th>
						<th>가입일</th>
						<th>사용자번호</th>
						<th>수정</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${userList}" varStatus="i">
						<tr>
							<td><input type="checkbox" name="${item.userSeq}"></td>
							<td>${i.count}</td>
							<td>${item.userId}</td>
							<td>${item.userPw}</td>
							<td>${item.userName}</td>
							<td>
								<c:choose>
									<c:when test="${item.gradeSeq == 0}">user</c:when>
									<c:when test="${item.gradeSeq == 1}">owner</c:when>
									<c:when test="${item.gradeSeq == 2}">admin</c:when>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${item.genderSeq == 0}">남자</c:when>
									<c:when test="${item.genderSeq == 1}">여자</c:when>
								</c:choose>
							</td>
							<td>${item.userBirth}</td>
							<td>${item.userEmail}</td>
							<td>${item.userPhone}</td>
							<td>${item.userRegDate}</td>
							<td>${item.userSeq}</td>
							<td><input type="button" value="수정" class="editButton">
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="submit" value="삭제">
			</form>
				
			<form action="getUser">
				<input type="text" name="userSeq">
				<input type="submit" id="getUser">
			</form>
			
		</section>
	</main>
</body>
</html>