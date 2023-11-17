<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page import="com.javabeans.userDto" %> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
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
</script>
<style>
/*표*/
.table {
	display: flex;
	justify-content: center;
}

table {
	border-collapse: collapse;
	border: 0;
	margin: auto;
	width: 50%;
	height: 50px;
	
}

input{
	width:150px;
}

th, td {
	border: 1px solid #aaa;
	padding: rem;
	text-align: center;
	margin: auto;
}

thead th, tbody th {
	background-color: #f8f8f8;
}

.members {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.play_image {
	heigth: 100px;
	width: 100px;
}

.page_wrap {
	display: flex;
	align-items: center;
}
</style>
</head>

<body>
	<jsp:include page="../header.jsp"/>
	<main>
		<jsp:include page="../admin_aside.jsp"/>
		<section>
			<div class="members">
			<div class="table">
			<form action="playUpdate" method="post">
				<table id="tb">
					<thead>
						<tr>
							<th>게시물번호</th>
							<th>게시물등록자</th>
							<th>지역</th>
							<th>상호명</th>
							<th>주소</th>
							<th>전화번호</th>
							<th>영업시간</th>
							<th>휴무일</th>
							<th>상세설명</th>
							<th>등록날짜</th>

						</tr>
					</thead>
					<tbody>
							<tr>
								<td>${play.boardSeq}</td>
								<td>${play.userSeq}</td>
								<td><input name="regionSeq" value="${play.regionSeq}"></td>
								<td><input name="boardTitle" value="${play.boardTitle}"></td>
								<td><input name="boardAddress" value="${play.boardAddress}"></td>
								<td><input name="boardPhone" value="${play.boardPhone}"></td>
								<td><input name="boardOpen" value="${play.boardOpen}"></td>
								<td><input name="boardBreak" value="${play.boardBreak}"></td>
								<td><input name="boardDetail" value="${play.boardDetail}"></td>
								<td>${play.boardRegDate}</td>
							
							</tr>
					</tbody>
				</table>
			
			<br>
			<input type="hidden" name="boardSeq" value="${play.boardSeq}">
			<input type="submit" value="수정하기">
			</form>
			
			</div>
			<form action="playDelete">
			<input type="hidden" name="boardSeq" value="${play.boardSeq}">
			<input type="submit" value="삭제하기">
			</form>
		</div>
		</section>
	</main>
</body>
</html>