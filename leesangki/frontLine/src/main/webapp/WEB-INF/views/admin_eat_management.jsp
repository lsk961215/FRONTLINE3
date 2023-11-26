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
<link rel="stylesheet" href="resources/css/header_admin.css">

<!-- 초기화 스타일 -->
<link rel="stylesheet" href="resources/css/style.css">

<!-- 관리자 메뉴 스타일 -->
<link rel="stylesheet" href="resources/css/admin_aside.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script>
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
</script>
<style>
main{
justify-content: center;
}

/*셀렉트*/
/* .head {
	display: block;
} */

select {
	height : 30px;
}

.inputbuttons {
	display: flex;
	justify-content: flex-end;
	margin-right: 31px;
}

#updateValue, #updateValue2{
	display: none;
}

.members{
	color: #474747;
	font-weight: bold;
	font-size: 30px;
	margin-top: 5%;
	margin-left: 31px;
}

.sinput {
	width: 150px;
	height: 30px;
	font-size: 14px;
	text-align: center;
	border: 1px solid #aaa;
	border-radius: 6px;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-right: 2px;
}

.sbtn {
	width: 50px;
	height: 30px;
	font-size: 14px;
	border: 1px solid #aaa;
	border-radius: 6px;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-right: 5px;
}

.sbtn2 {
	width: 80px;
	height: 30px;
	font-size: 14px;
	border: 1px solid #aaa;
	border-radius: 6px;
	margin-top: 10px;
	margin-bottom: 10px;
}

/*표*/
table {
	border-collapse: collapse;
	margin: 0 auto;	
	width: 95%;
}

#tablemain th, td {
	border: 1px solid #aaa;
 	text-align: center; 
}

#tablemain input {
	width: 80%;
	text-align: center;
	border: none;
/* 	margin: 0 auto;	 */
}

#tablemain input[type="checkbox"]{
	margin: 3px 3px 3px 3px;
	padding: 0px;
}

#tablemain .eventnone{
	pointer-events: none;
}

/*페이징*/
.page_wrap {
	margin-top: 30px;
	text-align: center;
}

.page_nation {
	display: inline-block;
}

.page_nation .none {
	display: none;
}

.page_nation a {
	margin: 0px;
	float: left;
	border: 1px solid #e6e6e6;
	width: 28px;
	height: 28px;
	line-height: 27px;
	background-color: #fff;
	font-size: 14px;
	color: #999999;
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

button {
	background-color: #474747;
	all: unset;
}
</style>


<style>

#wrap{
    max-width: 1280px;
    margin: 0 auto;
}

/* ===== 리셋 구간 ===== */

body {
    margin: 0;
    font-family: 'Noto Sans KR', sans-serif;
  }
  
  h1, h2, h3, h4, h5, h6 {
    font-size: inherit;
    font-weight: normal;
    margin: 0;
  }
  
  p {
    margin: 0;
  }
  
  strong, em {
    font-weight: inherit;
    font-style: normal;
  }
  
  ul, ol {
    margin: 0;
    padding: 0;
    list-style-type: none;
  }
  
  dl { margin: 0; }
  dd {
    margin: 0;
    display: inline;
  }
  
  figure { margin: 0; }
  
  a {
    text-decoration: none;
    color: inherit;
  }
  
  th { font-weight: normal; }
  
  address { font-style: inherit; }

	.tableTop {
		display: flex;
		width: 100%;
		
		padding-left: 50px;
		
	}
</style>
</head>
<body>
	<jsp:include page="header_admin.jsp"/>
			
			<main>
		<section>
			<br>
			<div class="section_title">
				<p style="font-weight: bold; font-size: 50px;">맛집 관리</p>
				<br>
			</div>
			<div class="tableTop">
				<input type="button" value="신규등록">
			</div>
			<br>
		<form action="adminEatDelete">
			<table border=1>
				<thead>
					<tr>
						<th>선택</th>
						<th>사용자 번호</th>
						<th>지역명</th>
						<th>상호명</th>
						<th>주소</th>
						<th>전화번호</th>
						<th>오픈시간</th>
						<th>상세 내용</th>
						<th>이미지</th>
						<th>등록일</th>
						<th>수정</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dto" items="${list }">
						<tr>
							<td><input type="checkbox" name="ck" value="${dto.boardSeq}"></td>
							<td>${dto.userSeq}</td>
							<td>${dto.regionSeq }</td>
							<td>${dto.boardTitle }</td>
							<td>${dto.boardAddress }</td>
							<td>${dto.boardPhone }</td>
							<td>${dto.boardOpen }</td>
							<td>${dto.boardDetail }</td>
							<td><img style="width: 200px; height:150px;" src="${dto.boardImage }"></td>
							<td>${dto.boardRegDate }</td>
							<td><a href="adminEatDetail?boardSeq=${dto.boardSeq}">수정하기</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="submit" value="삭제">
		</form>		
	
	</section>
</main>
</body>
</html>