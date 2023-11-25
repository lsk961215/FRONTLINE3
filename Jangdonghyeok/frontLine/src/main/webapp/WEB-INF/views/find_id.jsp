<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 헤더 자바스크립트 -->
<script src="resources/js/header.js"></script>
<!-- 헤더 스타일 -->
<link rel="stylesheet" href="resources/css/header.css">
<!-- 푸터 스타일 -->
<link rel="stylesheet" href="resources/css/footer.css">
<style>
    body {
    	display: flex;
    	flex-direction: column;
    	align-items: center;
    }
    main {
    	display: flex;
    	justify-content: center;
			
		width: 1280px;
    }
    section {
    	height: 1000px;
    }
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
    <main>
		<section>
			<form action="findId">
				이메일 주소를 입력하세요 <input type="text" name="userEmail"> <input type="submit" value="아이디 찾기">
			</form>
		</section>
	</main>
    <jsp:include page="footer.jsp"/>
</body>
</html>