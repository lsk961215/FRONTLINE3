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
    <!-- 푸터 스타일 -->
    <link rel="stylesheet" href="resources/css/footer.css">
    <script>
        window.addEventListener("load", function(){
            eye()
            check_password()
            button()
            check_all()
            submit_block()
        })
        
        function submit_block(){
        	document.querySelector(".main_form").addEventListener("keydown", function(event){
        		if(event.keyCode == 13){
        			event.preventDefault();
        		}	
        	})
        }

        function eye(){
            let eye = document.querySelectorAll(".eye")
            let password = document.querySelectorAll(".input_password input")
            
            for(let i = 0; i<eye.length; i++){
                eye[i].addEventListener("click", function(){
                //eye_dark 면 eye_light으로 아니면 반대로
                if(eye[i].getAttribute("src") == "resources/images/eye_dark.png"){
                    eye[i].setAttribute("src", "resources/images/eye_light.png")
                    password[i].setAttribute("type", "text")
                } else {
                    eye[i].setAttribute("src", "resources/images/eye_dark.png")
                    password[i].setAttribute("type", "password")
                }
            })
        }}

        function check_password(){
            // console.log("1")
            let password = document.querySelectorAll(".input_password input")

            for(let i = 0; i<password.length; i++){
                // console.log("1")
                password[i].addEventListener("keyup", function(){
                    // console.log(password[i].value)
                    if(password[0].value == password[1].value){
                        document.querySelector(".check_password").style.display = "none"
                    } else {
                        document.querySelector(".check_password").style.display = "block"
                    }
                })
            }
        }

        function button(){
            let button = document.querySelector(".button2")
            let count = 0;
            button.addEventListener("click", function(){
                if(count == 0){
                    location.href="frontLine/Join"
                }
            })
        }

        function check_all(){
            let count = 0;
            let input_all = document.querySelectorAll(".input_text")
            let password = document.querySelectorAll(".input_password input")

            for(let i = 0; i<input_all.length; i++){
                input_all[i].addEventListener("keyup", function(){
                    for(let j = 0; j<input_all.length; j++){
                        if (input_all[j].value !== ""){
                            count += 1;
                        }
                    }
                    
                    if(count == input_all.length && password[0].value == password[1].value){
                        document.querySelector(".button1").style.display = "none"
                        document.querySelector(".button2").style.display = "block"
                    } else {
                        document.querySelector(".button2").style.display = "none"
                        document.querySelector(".button1").style.display = "block"
                    }

                    count = 0;
                })
            }
        }
    </script>
    
    <style>
        div {
            /* border: 1px solid red; */
        }
        .input_main {
            width: 300px;
        }

        .input_top {
            border: 2px solid lightgray;
            border-radius: 15px;
            padding-left: 5px;
            padding-right: 5px;
            margin-bottom: 20px;
        }

        .input_bottom {
            border: 2px solid lightgray;
            border-radius: 15px;
            padding-left: 5px;
            padding-right: 5px;
            margin-bottom: 30px;
        }
        .section {
            display: flex;
            align-items: center;
        }

        .top {
            border-top: 2px solid lightgray;
        }
        .button1 {
            height: 40px;
            width: 300px;

            color: white;
            font-weight: bolder;
            border-radius: 7px;
            background-color: lightgray;
            
            text-align: center;
            line-height: 40px;

        }
        .button2 {
            cursor: pointer;
            height: 40px;
            width: 300px;

            color: white;
            font-weight: bolder;
            border-radius: 7px;
            background-color: #5498FF;
            
            text-align: center;
            line-height: 40px;
            display: none;
        }

        input {
            border: 1px solid white;
            border-radius: 15px;
            width: 95%;
            height: 30px;
            outline: none;
        }

        .wrap img {
            height: 20px;
        }

        .eye {
            cursor: pointer;
        }

        .check_password {
            display: none;
            color: red;
            font-size: 12px;
            padding-left: 3px;
            margin-bottom: 6px;
        }

        .wrap {
            display: flex;
            flex-direction: column;
            align-items: center;

            margin-top: 5%;
            margin-bottom: 20%; 
        }

        h1 {
            margin-bottom: 60px;
        }
    </style>

<style>
        
    /* 푸터 */
    footer {
        font-family: 'Noto Sans KR', sans-serif;
        /* font-family: 'Roboto', sans-serif; */
        font-weight: 400;
        color: #FFFFFF;
        font-size: 25px;
        line-height: 34.05px;

        position : relative;
        
        top : 100%;

        /* border: 1px solid red; */
        width: 100%;
        height: 245px;
        background-color: #474747;
        
        
        
    }

    footer .footer_div {
        padding-top: 10px;
        padding-bottom: 10px;
        margin-left: 10px;
        margin-right: 10px;
        /* border: solid 1px red; */
    }

    footer .textdiv {
        display: inline-block;
        padding-top: 30px;
        /* padding-left: 30px; */
        margin-left: 40px;
    }

    footer .icondiv {
        /* display: flex;
        justify-content: flex-end;
        display: inline-block; */
        padding-top: 30px;
        margin-right: 40px;
    }

    footer #logo {
        /* position: relative; */
        /* top: 61px;
        left: 50px; */
    }

    footer .number {
        font-size: 35px;
        font-weight: 600;
        text-align: right;
        /* margin-right: 34px; */
        margin-right: 25px;
        /* margin-bottom:30px; */
        margin-top: -35px;
    }

    footer .rightText {
        text-align: right;
        font-weight: 600;
        /* margin-right: 34px; */
        /* vertical-align: top; */
        margin-right: 25px;
        margin-bottom:20px;
        margin-top: -30px;
    }

    footer .footer_top {
        /* border: 1px solid red; */
        display: flex;
        justify-content: space-between;
        border-bottom: 1px solid white;
        /* border-bottom: 1px solid white; */
    
    }

    footer .footer_bottom {
        /* height: 500px; */
        /* border: 1px solid red; */
        padding: 0px;
        display: flex;
        justify-content: space-between;
    }

    footer .text_footer {
        display: flex;
        flex-direction: column;
        align-items: flex-end;
    }
    
    footer .logo_footer{
        margin-left: 40px;
        margin-top: -15px;
    }
    
    footer a {
        color: #fff; text-decoration: none; outline: none
    }
</style>

</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="wrap">
        <h1>회원가입 및 이용약관</h1>
        <div class="input_main">
        	<form class="main_form" action="doJoin">
            	<div class="input_top">
                	<div class="section input_name"><img src="resources/images/icon_human.png"><input class="input_text" type="text" placeholder="이름" name="userName"></div>
                	<div class="section top input_id"><img src="resources/images/icon_check.png"><input class="input_text" type="text" placeholder="아이디" name="userId"></div>
                	<div class="section top input_password"><img src="resources/images/icon_password_before.png"><input class="input_text" type="password" placeholder="비밀번호"><img class="eye" src="resources/images/eye_dark.png"></div>
                	<div class="section top input_password"><img src="resources/images/icon_password_before.png"><input class="input_text" type="password" placeholder="비밀번호 확인" name="userPw"><img class="eye" src="resources/images/eye_dark.png"></div>
                	<div class="check_password">비밀번호가 일치하지 않습니다.</div>
            	</div>
            	<div class="input_bottom">
                	<div class="section input_email"><img src="resources/images/icon_message.png"><input class="input_text" type="text" placeholder="이메일" name="userEmail"></div>
                	<div class="section top input_phone"><img src="resources/images/icon_call.png"><input class="input_text" type="text" placeholder="휴대폰 번호" name="userPhone"></div>
                	<div class="section top input_birth"><img src="resources/images/icon_gift.png"><input class="input_text" type="text" placeholder="생년월일 8자리" name="userBirth"></div>
                	<div class="section top input_gender"><img src="resources/images/icon_human.png">
                		<input type="text" placeholder="성별" disabled>
                		<select name="genderSeq">
                			<option value="0">남자</option>
                			<option value="1">여자</option>
                		</select>
                	</div>
            	</div>
            	<div class="button1">가입하기</div>
            	<input type="submit" class="button2" value="가입하기">
            </form>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>