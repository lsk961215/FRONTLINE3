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
    <!-- 지역 메인 css -->
    <link rel="stylesheet" href="resources/css/cheonAn_main.css">
	<!-- 지역 메인 js -->
    <script src="resources/js/cheonAn_main.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    

</head>
<style>
.room_wrap {
	display: flex;
	justify-content: space-evenly;
}
.room_section {
	border: 1px solid black;
	border-radius: 10px;
	display: flex;
	flex-direction: column;
	text-align: center;
	
	width: 200px;
	height: 200px;
}
.room_section img {
	width: 100%;
	height: 170px;
	
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
}
.room_page {
	display: none;
}
</style>
<script>
	$(function(){
		
		$(".room_view").click(function(){
			console.log("hi")
			$(this).parent().find("input[type=submit]").click()
		})
	})
</script>
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


		<div class="room_wrap">
           <c:forEach var="item" items="<%=EatDB.getEatList()%>" varStatus="i">
           		<div class="room_section">
           			<a class="room_view">
           				<img class="room_image" src="${item.getImage()}"><br>
           				<span class="room_title">${item.getTitle()}</span>
           			</a>
           			<form class="room_page" action="/frontLine/EatPage">
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

		<div class="room_wrap">
           <c:forEach var="item" items="<%=TravelDB.getTravelList()%>" varStatus="i">
           		<div class="room_section">
           			<a class="room_view">
           				<img class="room_image" src="${item.getImage()}"><br>
           				<span class="room_title">${item.getTitle()}</span>
           			</a>
           			<form class="room_page" action="/frontLine/TravelPage">
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




       <div class="room_wrap">
           <c:forEach var="item" items="<%=PlayDB.getPlayList()%>" varStatus="i">
           		<div class="room_section">
           			<a class="room_view">
           				<img class="room_image" src="${item.getImage()}"><br>
           				<span class="room_title">${item.getTitle()}</span>
           			</a>
           			<form class="room_page" action="/frontLine/PlayPage">
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
        <div class="room_wrap">
           <c:forEach var="item" items="<%=RoomDB.getRoomList()%>" varStatus="i">
           		<div class="room_section">
           			<a class="room_view">
           				<img class="room_image" src="${item.getRoomImage()}"><br>
           				<span class="room_title">${item.getRoomTitle()}</span>
           			</a>
           			<form class="room_page" action="/frontLine/RoomPage">
           				<input type="text" name="page" value="${i.index}">
           				<input type="submit" value="move">
           			</form>
           		</div>
           </c:forEach>
        </div>
        <%--------------------%>









        <div class="select_place_list">
            <div class="select_place_img">
                <img src="https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(1).png?raw=true"
                    id="sp_1">

            </div>

            <div class="select_place_img">
                <img src="https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(2).png?raw=true"
                    id="sp_2">

            </div>

            <div class="select_place_img">
                <img src="https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(3).png?raw=true"
                    id="sp_3">

            </div>

            <div class="select_place_img">
                <img src="https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(4).png?raw=true"
                    id="sp_4">

            </div>

            <div class="select_place_img">
                <img src="https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(5).png?raw=true"
                    id="sp_5">

            </div>

            <div class="select_place_img">
                <img src="https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(6).png?raw=true"
                    id="sp_6">

            </div>
        </div>

        <div class="chungnam_city">
            
        </div>
        <div>

        </div>

        <jsp:include page="footer.jsp"/>

    </div>

</body>

</html>