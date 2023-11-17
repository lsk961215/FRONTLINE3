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
				<table id="tb">
					<thead>
						<tr>
							<th>번호</th>
							<th>지역</th>
							<th>상호명</th>
							<th>주소</th>
							<th>전화번호</th>
							<th>영업시간</th>
							<th>상세설명</th>
							<th>이미지</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="play"
							items="<%=PlayDB.getPlayList()%>"
							varStatus="status">
							<c:set var="i" value="${i+1 }" />
							<tr>
								<td>${i}</td>
								<td>${play.getCity()}</td>
								<td>${play.getTitle() }</td>
								<td>${play.getAddress()}</td>
								<td>${play.getTell()}</td>
								<td>${play.getOpenTime() }</td>
								<td>${play.getDetail() }</td>
								<td><img class="play_image" src="${play.getImage()}"></td>
							</tr>

						</c:forEach>
					</tbody>

				</table>
			</div>
			<br>
			<div class="page_wrap">
				<a class="arrow prev" href="#"><button>
						<img
							src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/Group%202187.png?raw=true">
					</button></a>
				<div class="page_nation">
					<a href="#" class="active">1</a> <a href="#">2</a> <a href="#">3</a>
					<a href="#">4</a> <a href="#">5</a> <a href="#">6</a> <a href="#">7</a>
					<a href="#">8</a> <a href="#">9</a> <a href="#">10</a>
				</div>
				<a class="arrow next" href="#"><button>
						<img
							src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/Group%202188.png?raw=true">
					</button></a>
			</div>
		</div>
		</section>
	</main>
</body>
</html>