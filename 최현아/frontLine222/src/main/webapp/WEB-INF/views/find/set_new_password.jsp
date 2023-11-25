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
<style>


body {
  display: flex;
  align-items: center;
  flex-direction: column;
}
 .box {
 width: 700px;
 height: 300px;
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

#goid:hover {
  background-color: #3a7bd5;
}
#goid{
	 margin-top: 20px;
	 width: 100px;
}
#phonenum{
margin-right:50px;
}
#discord{
	color: red;
}

</style>
<body>
<jsp:include page="../header.jsp"/>
<div class="box">
<span id="title">비밀번호 재설정</span>
<div>새로운 비밀번호를 입력해 주세요.</div>
<form action="inputNewPw">
	<div>새 비밀번호 입력 <input type="text" name="setUserPw" ></div>
	<div>새 비밀번호 확인 <input type="text" name="userPw" ></div>
	<c:if test="${comparison5} == 5">
	<div id="discord">입력한 정보가 일치하지 않습니다.</div>
	</c:if>
	<input type="hidden" name="userEmail" value="${userEmail2}">
	<input type="submit" id="goid" value="확인">
</form>
</div>
 <jsp:include page="../footer.jsp"/>
</body>
</html>