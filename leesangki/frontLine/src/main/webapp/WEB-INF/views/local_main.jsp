<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- 글꼴 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@600&family=Roboto&display=swap"
        rel="stylesheet">
    <!-- 지역 메인 css -->
    <link rel="stylesheet" href="resources/css/local_main.css">
	<!-- 지역 메인 js -->
    <script src="resources/js/local_main.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    
</head>
<script>
</script>
<style>
.board_wrap {
	display: flex;
	justify-content: space-evenly;
}
.board_section {
	border: 1px solid black;
	border-radius: 10px;
	display: flex;
	flex-direction: column;
	text-align: center;
	
	width: 200px;
	height: 200px;
}
.board_section img {
	width: 100%;
	height: 170px;
	
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
}
.board_page {
	display: none;
}
</style>
<body>
	<jsp:include page="header.jsp"/>
    
    
    <div class="wrap">
        <div class="best_travel">
            <div class="weathers">
                <div class="weather_img">
                    <img class="sunny"
                        src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/Sunny.png?raw=true">
                    <img class="cloudy"
                        src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/Cloudy.png?raw=true">
                    <img class="rain"
                        src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/Rain.png?raw=true">
                    <img class="snow"
                        src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/Snow.png?raw=true">
                </div>
                <div class="weather_wrap"><div id="weather"></div><div>도</div></div>
            </div>
            <div class="title">
                
            </div>
            <div class="items">
                <div class="itemss">
                   
                </div>
            </div>
            <div style="margin-top : 5px;"></div>
            
        </div><br>


        <div class="second_line">
            <span>
                <p4>대충 놓치면 안될 먹거리</p4>
            </span><br>
            <div style="margin-top : 5px;"></div>
            <span>
                <p5>대충 의미 있는 천안맛집</p5>
            </span><a href="./cheonAn_foodMore.html" class="item_more">
                <p5>더보기</p5>
            </a><br><br>

        </div>


		<div class="board_wrap">
           <c:forEach var="item" items="${boardListMap.typeSeq2}" varStatus="i">
           		<div class="board_section">
           			<a class="board_view">
           				<img class="board_image" src="${item.boardImage}"><br>
           				<span class="board_title">${item.boardTitle}</span>
           			</a>
           			<form class="board_page" action="/frontLine/EatPage">
           				<input type="text" name="page" value="${i.index}">
           				<input type="submit" value="move">
           			</form>
           		</div>
           </c:forEach>
        </div><br><br>



        <div class="second_line">
            <span>
                <p4>대충 여행지 고민을 해결해줄</p4>
            </span><br>
            <div style="margin-top : 5px;"></div>
            <span>
                <p5>대충 유명한 천안의 여행지</p5>
            </span><a href="./cheonAn_playMore.html" class="item_more">
                <p5>더보기</p5>
            </a><br><br>
        </div>

		<div class="board_wrap">
           <c:forEach var="item" items="${boardListMap.typeSeq0}" varStatus="i">
           		<div class="board_section">
           			<a class="board_view">
           				<img class="board_image" src="${item.boardImage}"><br>
           				<span class="board_title">${item.boardTitle}</span>
           			</a>
           			<form class="board_page" action="/frontLine/TravelPage">
           				<input type="text" name="page" value="${i.index}">
           				<input type="submit" value="move">
           			</form>
           		</div>
           </c:forEach>
        </div><br><br>




        <div class="second_line">
            <span>
                <p4>대충 나만의 여행을 위한</p4>
            </span><br>
            <div style="margin-top : 5px;"></div>
            <span>
                <p5>대충 유명한 천안의 이색장소</p5>
            </span><a href="./cheonAn_playMore.html" class="item_more">
                <p5>더보기</p5>
            </a><br><br>
        </div>




       <div class="board_wrap">
           <c:forEach var="item" items="${boardListMap.typeSeq1}" varStatus="i">
           		<div class="board_section">
           			<a class="board_view">
           				<img class="board_image" src="${item.boardImage}"><br>
           				<span class="board_title">${item.boardTitle}</span>
           			</a>
           			<form class="board_page" action="/frontLine/PlayPage">
           				<input type="text" name="page" value="${i.index}">
           				<input type="submit" value="move">
           			</form>
           		</div>
           </c:forEach>
        </div><br><br>
        
        
        
        
        
        
        
        
        
        
        
        
        <div class="second_line">
            <span>
                <p4>대충 편안하게 휴식하기 좋은</p4>
            </span><br>
            <div style="margin-top : 5px;"></div>
            <span>
                <p5>대충 유명한 천안의 숙소</p5>
            </span>
            <a href="./cheonAn_playMore.html" class="item_more">
                <p5>더보기</p5>
            </a><br><br>
        </div>
		<%-- 숙소 리스트 --%>
        <div class="board_wrap">
           <c:forEach var="item" items="${boardListMap.typeSeq3}" varStatus="i">
           		<div class="board_section">
           			<a class="board_view">
           				<img class="board_image" src="${item.boardImage}"><br>
           				<span class="board_title">${item.boardTitle}</span>
           			</a>
           			<form class="board_page" action="/frontLine/boardPage">
           				<input type="text" name="page" value="${i.index}">
           				<input type="submit" value="move">
           			</form>
           		</div>
           </c:forEach>
        </div>
        <%--------------------%>



        <footer>
            <div class="footer_div footer_wrap">
                <div class="footer_div footer_top">
                    <div class="footer_div textdiv">
                        <span><a href="../terms.html">이용약관</a>&nbsp;</span>|
                        <span><a href="../terms.html">개인정보처리방침</a>&nbsp;</span>|
                        <span><a href="../serviceCenter.html">고객센터</a></span>
                    </div>
                    <div class="footer_div icondiv">
                        <span><a href="https://www.facebook.com/?locale=ko_KR"><img
                            src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/Facebook.png?raw=true"></a>&nbsp;&nbsp;</span>
                        
                            <span><a href="https://www.youtube.com/"><img
                                src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/YouTube.png?raw=true"></a>&nbsp;&nbsp;</span>
                        
                        
                            <span><a href="https://www.instagram.com/"><img
                                src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/Instagram.png?raw=true"></a></span>
                        
                    </div>
                </div>
                <div class="footer_div line2"></div>
               
        
                <div class="footer_div footer_bottom">
                    <div class="footer_div logo_footer">
                        <a href="../main.html"><img id="logo" src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/%EB%86%80%EC%95%84%EC%9C%A0_white.png?raw=true"></a>
                    </div>
                    
                    <div class="footer_div text_footer">
                        <div class="footer_div rightText">고객센터</div>
                        <div class="footer_div number">1313-1212</div>
                    </div>
                        
                </div>
            </div>
        </footer>

    </div>

</body>

</html>