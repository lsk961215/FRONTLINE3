<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<body>
	<jsp:include page="../header.jsp"/>
    
    
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
                <p4>천안<br>
                    베스트 여행지</p4>
            </div>
            <div class="items">
                <div class="itemss">
                   
                </div>
            </div>
            <div style="margin-top : 5px;"></div>
            <div class="btns">
                <input type="button" id="btn1">
                <div id="count"> 1 / 4 </div>
                <input type="button" id="btn2">
            </div>
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
            </a></span><br><br>

        </div>

        <div class="best_food">
           
        </div><br>


        <div class="second_line">
            <span>
                <p4>대충 나만의 여행을 위한</p4>
            </span><br>
            <div style="margin-top : 5px;"></div>
            <span>
                <p5>대충 유명한 천안의 이색장소</p5>
            </span><a href="./cheonAn_playMore.html" class="item_more">
                <p5>더보기</p5>
            </a></span><br><br>
        </div>

        <div class="best_play">
           
        </div><br><br>


        <div class="best_sleep">

            <div id="sleep_img">
               
            </div>


            <div id="sleep_more">
                <div id="logoimg"><img
                        src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/simbol_white.png?raw=true">
                </div>
                <div id="moreinn" style="color: white;">
                    <p4>멋진 숙소를 만나보세요</p4><br><br><br>
                    <button type="button" class="sleep_more_btn">
                        <p6>숙소 더보기</p6>
                </div>
            </div>
        </div><br><br><br>
        <div style="text-align : center;">
            <p4>충청남도 관광도시</p4>
        </div><br><br>

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