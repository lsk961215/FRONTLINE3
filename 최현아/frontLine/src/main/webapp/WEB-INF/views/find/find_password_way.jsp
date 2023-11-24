<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 헤더 자바스크립트 -->
    <script src="resources/js/header.js"></script>
    <!-- 헤더 스타일 -->
    <link rel="stylesheet" href="resources/css/header.css">
    <!-- 푸터 스타일 -->
    <link rel="stylesheet" href="resources/css/footer.css">
</head>
<script>

</script>
<style>


body {
  display: flex;
  align-items: center;
  flex-direction: column;
}
 .box {
 width: 700px;
 height: 350px;
 border-radius: 10px;
 border: 1px solid #dadce0;
 text-align: center;
 
 display: flex;
 justify-content: center;
 flex-direction: column;
 margin-bottom:150px;
 margin-top:100px;
}

#title{
 font-size: 1.5em;
  font-weight: bold;
}

.box > div {
  margin: 10px 0;
}

form {
  margin-top: 20px;
}

form > div {
  margin-bottom: 10px;
}

input[type="text"] {
  padding: 5px;
  box-sizing: border-box;
}

input[type="submit"] {
  padding: 10px;
  background-color: #5498FF;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
h4{
	margin-block-end: 0;
}
#goid:hover {
  background-color: #3a7bd5;
}
#goid{
width: 100px;
margin-top:20px;
}
#phonenum{
margin-right:90px;
}
#findEmailColor{
color:#5498FF;
}
#fontSizeSmall{
font-size:small;
}
#emailAddressMargin{
	position: relative;
    left: 20px;
    margin-left: 5px;
}

</style>
<body>
<jsp:include page="../header.jsp"/>
<div class="box">
<span id="title">비밀번호 찾기</span>
<h4><span>회원정보에 등록된 이메일로 인증</span>&nbsp<span id="findEmailColor"><!-- (${idDto.userEmail}) --></span></h2>
<div id="fontSizeSmall">본인확인 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.</div>
	<div>
	<form action="getNumber">
	이메일 주소<input id="emailAddressMargin" type="text" name="receivedEmail">
	<input id="emailAddressMargin"type="submit" value="인증번호 받기">
	<input type="hidden" name="userEmail" value="${idDto.userEmail}">
	<input type="hidden" name="userName" value="${idDto.userName}">
	</form>
	</div>
<form action="checkNumber">
	<div id="phonenum">인증번호 입력 <input id="emailAddressMargin" type="text" name="putKey" placeholder="숫자만 입력">
	<input id="emailAddressMargin" type="submit" value="인증번호 확인">
	<input type="hidden" name="num" value="${num}">
	</div>
	
</form>
	<input type="submit" id="goid" value="다음">
</div>
 <jsp:include page="../footer.jsp"/>
</body>
</html>