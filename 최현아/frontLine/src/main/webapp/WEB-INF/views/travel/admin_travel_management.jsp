<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행지 관리</title>
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

<style>
/*셀렉트*/
.members {
	padding-left: 10%;
}
.table {
	width: 70%;
}

.table textarea {
	width: 100px;
}
.eat_image {
	width: 100px;
	height: 100px;
}

textarea {
	resize: none;
}
</style>
<style>
/*페이징*/
.page_wrap {
	text-align: center;
	font-size: 0;
}

.page_nation {
	display: inline-block;
}

.page_nation .none {
	display: none;
}

.page_nation a {
	display: block;
	margin: 0px;
	float: left;
	border: 1px solid #e6e6e6;
	width: 28px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	background-color: #fff;
	font-size: 14px;
	color: #999999;
	text-decoration: none;
}

.page_nation .arrow {
	border: 1px solid #ccc;
}

.page_nation .prev {
	background: #f8f8f8 url('') no-repeat center center;
	margin-right: 6px;
}

.page_nation .next {
	background: #f8f8f8 url('') no-repeat center center;
	margin-left: 6px;
}

.page_nation a.active {
	background-color: #42454c;
	color: #fff;
	border: 1px solid #42454c;
}

.arrow.prev {
	margin-right: 10px;
}

.arrow.next {
	margin-left: 10px;
}

.travel_image {
	width:100px;
	heigth:100px;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<main>
	<jsp:include page="../admin_aside.jsp"/>
	<section>
	<div class="members">
				<!--=========================== 팝업창 ================================== 
				<div class="menu_wrap viewBar menu_ul"
					style="position: absolute; top: 90px; right: 70px;">
					<a><div>로그아웃</div></a> <a><div>내정보</div></a>
				</div>
				===================================================================== -->
<!-- 				<div class="head"> -->
					<div id="hright">
						<select class="sb" name="ss">
							<option value="all" selected="selected">전체</option>
							<option value="num">글번호</option>
							<option value="date">지역</option>
							<option value="date">상호명</option>
							<option value="date">작성일</option>
							<option value="id">사용자번호</option>
						</select>

						<form id="search" method="GET" action="">
							<input class="sinput" type="text" placeholder="검색어를 입력해주세요">
							<input class="sbtn" type="submit" value="검색">
						</form>
					</div>
				<br>
			<form action="travelDelete">
				<div class="table">
					<table id="tb" border="1">
						<thead>
							<tr>
								<th>선택</th>
								<th>글번호</th>
								<th>카테고리번호</th>
								<th>지역</th>
								<th>상호명</th>
								<th>주소</th>
								<th>오픈시간</th>
								<th>상세글</th>
								<th>작성일</th>
								<th>브레이크</th>
								<th>전화번호</th>
								<th>사용자번호</th>
								<th>수정</th>
							</tr>
						</thead>
						<tbody>
<%-- 									<td>${status.count}</td> --%>
<!-- 									<td><input type="checkbox"></td> -->
							<c:forEach var="dto" items="${travelList}" varStatus="status"> 
								<tr>
									<td><input type="checkbox" name="boardDelete" value="${dto.boardSeq}" ></td>
									<td>${dto.boardSeq}</td>
									<td>${dto.typeSeq}</td>
									<td>${dto.regionSeq  }</td>
									<td>${dto.boardTitle}</td>
									<td>${dto.boardAddress}</td>
									<td>${dto.boardOpen }</td>
									<td>${dto.boardDetail}</td>
									<td>${dto.boardRegDate}</td>
									<td>${dto.boardBreak}</td>
									<td>${dto.boardPhone}</td>
									<td>${dto.userSeq}</td>
									<td><a href="travelUpdate?boardSeq=${dto.boardSeq}"	><input type="button" value="수정" name="${dto.boardSeq}"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input type="submit" value="삭제">
				</div>
			</form>
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
<!-- 				</div> -->
			</div>
	</section>
	</main>	
</body> 
</html>