<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html lang="en">

<head>
</head>    
    
<style>
footer {
            font-family: 'Noto Sans KR', sans-serif;
            /* font-family: 'Roboto', sans-serif; */
            font-weight: 400;
            color: #FFFFFF;
            font-size: 17px;
/*             line-height: 50px; */ 
			height: 194px;         
			margin-top: 10%;
            background-color: #474747;            
            
        }

        footer .footer_div {
/*             padding-top: 10px;
            padding-bottom: 10px; */
            margin-left: 10px;
            margin-right: 10px;
            /* border: solid 1px red; */
        }

        footer .textdiv {
            display: inline-block;
            padding-top: 30px;
            margin-left: 20px;
            margin-bottom: 15px;
            /* padding-left: 30px; */
        }

        footer .number {
            font-size: 15px;
            font-weight: 600;
            /* margin-right: 34px; */
            margin-right: 20px;
            /* margin-bottom:30px; */
            margin-top: 20px;
        }

        footer .rightText {
            text-align: right;
            font-weight: 200;
            /* margin-right: 34px; */
            /* vertical-align: top; */
            margin-right: 25px;
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
        
        footer .logo_footer img{
        	margin-top: 20px;
            margin-left: 20px;
            width: 100px;
        }
        
        footer a {
            color: #fff; text-decoration: none; outline: none
        }
</style>

<body>    
	<footer>
        <div class="footer_wrap">
        
            <div class="footer_top">
                <div class="textdiv">
                    <span><a href="./terms.html">이용약관</a>&nbsp;</span>
                    <span><a href="./terms.html">개인정보처리방침</a>&nbsp;</span>
                    <span><a href="./serviceCenter.html">고객센터</a></span>
                </div>
            </div>
    
            <div class="footer_bottom">
            
            <div class="logo_footer">
                    <a href="./main.html"><img id="logo" src="https://github.com/Jominsang1/FrontLine_Project/blob/main/images/%EB%86%80%EC%95%84%EC%9C%A0_white.png?raw=true"></a>
            </div>
                
                <div class="text_footer">
                    <div class="number">고객센터 1313-1212</div>
                </div>
            </div>
                    
            
        </div>
    </footer>
</body>

</html>    