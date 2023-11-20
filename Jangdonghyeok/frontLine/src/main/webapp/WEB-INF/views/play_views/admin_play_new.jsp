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
.playReset{
	display: flex;
	align-items: center;
	width: 500px;
	height: 500px;
}
.local{
display: flex;
	justify-content: space-around;
	align-items: center;
	width: 80px;
	height: 30px;
	font-size: 14px;
	border: 1px solid #aaa;
	border-radius: 6px;
}
.sinput{
	display: flex;
	align-items: center;
	margin:20px;
	width: 500px;
}
.sbtn{
	display: flex;
	justify-content: space-around;
	width: 80px;
	height: 30px;
	font-size: 14px;
	border: 1px solid #aaa;
	border-radius: 6px;
}

.container {
	width: 1240px;
	height: 120px;
	background-color: #474747;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

button {
	background-color: #474747;
	all: unset;
}

.menuMargin {
	margin: 45px;
}

.nav {
	width: 220px;
	height: 790px;
	background-color: #474747;
	padding: 20px;
}

.managerMenu {
	color: #fff;
}

.mainFont {
	margin: 20px;
	line-height: 90px;
	font-size: 40px;
}

.menuFont {
	margin: 20px;
	line-height: 60px;
	font-size: 22px;
}

.active {
	color: #FFD400;
}

.tuning {
	color: #FFF;
}

.clickMenu {
	cursor: pointer;
}

.menuMargin {
	cursor: pointer;
}

.managerMenu {
	cursor: pointer;
}

.blockMenu {
	position: relative;
}

.whiteMenu {
	position: relative;
}

.yellowMenu {
	position: relative;
	left: 156px;
}

.flus {
	display: flex;
}

.members {
	margin-top: 5%;
	margin-left: 6%;
}

.autoPage {
	width: 1280px;
	margin: 0 auto;
}
</style>
</head>

<body>
	<jsp:include page="../header.jsp"/>
	<main>
		<jsp:include page="../admin_aside.jsp"/>
		<section>
			<div class="playReset">
				<div id="hright">
				<div> <h1>놀거리 등록 페이지 입니다. </h1></div><br>
					<form action="playNew">
						<select class="local" name="regionSeq">
							<option value="0" selected="selected">천안</option>
							<option value="1">아산</option>
							<option value="2">태안</option>
							<option value="3">서산</option>
							<option value="4">당진</option>
							<option value="5">예산</option>
							<option value="6">홍성</option>
							<option value="7">청양</option>
							<option value="8">보령</option>
							<option value="9">부여</option>
							<option value="10">서천</option>
							<option value="11">공주</option>
							<option value="12">논산</option>							
							<option value="13">계룡</option>							
							<option value="14">금산</option>
						</select>
						
						<div >
						<input name="boardTitle" class="sinput" type="text" placeholder="상호명">
						</div>
						<div >
						<input name="boardAddress" class="sinput" type="text" placeholder="주소">
						</div>
						<div>
						<input name="boardPhone" class="sinput" type="text" placeholder="번호">
						</div> 

						<div>
						<input name="boardOpen" class="sinput" type="text"placeholder="영업시간"> 
						</div> 

						<div>
						<input name="boardDetail" class="sinput"type="text" placeholder="상세정보"> 
						</div> 

						
						<div>
						<input name="boardBreak"class="sinput" type="text" placeholder="휴무일">
						</div>
						
						<input type="hidden" name="typeSeq" value="1">
						<input type="hidden" name="userSeq" value="${userDTO.getUserSeq()}">
						<div>
						<input class="sbtn" type="submit" value="등록">
						</div> 
					</form>
				</div>
			</div>
		</section>
	</main>
</body>
</html>