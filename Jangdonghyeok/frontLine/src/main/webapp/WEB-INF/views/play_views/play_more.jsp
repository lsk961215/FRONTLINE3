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
<!-- 리스트페이지 스타일 -->
<link rel="stylesheet" href="resources/css/page_more.css">

<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous">
	
</script>
<body>
	<jsp:include page="../header.jsp"/>
	<div class="best_play">
		<div id="play_img">
			<c:forEach var="play" items="${list}">
				<div class="play">
					<a href="playPage?boardSeq=${play.boardSeq}">
					<img src=" play.img ">
						</a>
					<div class="playTitle">
						<p>${play.boardTitle}<p>
					</div>
					<div class="address">
						<p1>${play.boardAddress}</p1>
					</div>
					<div class="price">
						<p2>${play.boardDetail}</p2>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="page_wrap">
					
					<%@ page import="java.util.*"%>
					<%
					// model에 넣은 "data" 가져오기
					Map data = (Map) request.getAttribute("data");
					int total = (Integer) data.get("total");
					
					int pageNum = (Integer) data.get("pageNum");
					//한번에 보여줄 글의 개수
					int countPerPage = (Integer) data.get("countPerPage");
					//전체 페이지의 수 
					// 올림 (전체 글의 수/ 한번에 보여줄 글의 수)
					// 12/ 5 >> 2.4 >> ceil결과 3.0 >> int 변수에 저장 >>3
					int totalPaging = (int) Math.ceil((double) total / countPerPage);

					//한번에 보여줄 페이지의 개수
					int groupCount = 5;

					// 현재 페이지가 몇번째 그룹에 있는지
					int position = (int) Math.ceil((double) pageNum / groupCount);

					// 현재 그룹에 첫번째 페이지 번호
					int beginPaging = ((position - 1) * groupCount) + 1;
					int endPaging = position * groupCount;

					if (endPaging > totalPaging) {
						endPaging = totalPaging;
					}

					if (beginPaging == 1) {
						out.println("[이 전]");
					} else {
						out.println("<a href='playMoreView?pageNum=" + (beginPaging - 1) + "'>[이 전]</a>");
					}

					for (int i = beginPaging; i <= endPaging; i++) {
						if (i == pageNum) {
							out.println("<a href='playMoreView?pageNum=" + i + "'><strong>[" + i + "]</strong></a>");
						} else {
							out.println("<a href='playMoreView?pageNum=" + i + "'>[" + i + "]</a>");
						}
					}

					if (endPaging == totalPaging) {
						out.println("[다 음]");
					} else {
						out.println("<a href='playMoreView?pageNum=" + (endPaging + 1) + "'>[다 음]</a>");
					}
					%>

				</div>
	</div>

</body>
	<jsp:include page="../footer.jsp" />
</html>