window.addEventListener("load", function () {

    let html = '';
    let html_travel = '';
    let html_food = '';
    let html_play = '';
    let html_sleep = '';
    let html_location = '';
    let html_name = '';

    $.ajax({
        url: "resources/data/ch_data.html",
        dataType: 'html',
        success: function (ch) {


            let htmlDom = new DOMParser().parseFromString(ch, 'text/html');
            let tableDom = htmlDom.documentElement

            // 천안 관련 카테고리 테이블 image class 배열값 dom
            let arr_ch_travel_img = tableDom.querySelectorAll(".ch_travel .image")
            let arr_ch_travel_title = tableDom.querySelectorAll(".ch_travel .title")

            let arr_ch_food_img = tableDom.querySelectorAll(".ch_food .image")
            let arr_ch_food_title = tableDom.querySelectorAll(".ch_food .title")
            let arr_ch_food_address = tableDom.querySelectorAll(".ch_food .address")

            let arr_ch_play_img = tableDom.querySelectorAll(".ch_play .image")
            let arr_ch_play_title = tableDom.querySelectorAll(".ch_play .title")
            let arr_ch_play_address = tableDom.querySelectorAll(".ch_play .address")

            let arr_ch_sleep_img = tableDom.querySelectorAll(".ch_sleep .image")
            let arr_ch_sleep_title = tableDom.querySelectorAll(".ch_sleep .title")

            let arr_location_img = tableDom.querySelectorAll(".locations .image")
            let arr_location_title = tableDom.querySelectorAll(".locations .title")

            // console.log(arr_location_img)

            // 천안 여행지관련 배열 길이만큼 for문 <여행지이미지 및 여행지타이틀>
            for (let i = 0; i < arr_ch_travel_img.length; i++) {
                let ch_travel_img = arr_ch_travel_img[i].querySelector('img')
                let ch_travel_title = arr_ch_travel_title[i].innerHTML
                // console.log(ch_travel_img) // ch_travel_img 이미지 태그값 출력값 확인
                // console.log(a[i]) // a[배열]값 consol 출력값 확인

                html_travel += `<div class="item">${ch_travel_img.outerHTML}</div>`
            }

            // 천안 맛집관련 배열 길이만큼 for문 <맛집이미지 및 맛집타이틀>
            for (let i = 0; i < 5; i++) {
                let ch_food_img = arr_ch_food_img[i].querySelector('img')
                // let ch_food_title = arr_ch_food_title[i].innerHTML
                // let ch_food_address = arr_ch_food_address[i].innerHTML

                html_food += `<div class="food">${ch_food_img.outerHTML}</div>`

            }


            //  천안 놀거리관련 배열 길이만큼 for문 <놀거리이미지 및 놀거리타이틀>
            for (let i = 0; i < 5; i++) {
                let ch_play_img = arr_ch_play_img[i].querySelector('img')
                // let ch_play_title = arr_ch_play_title[i].innerHTML
                // let ch_address_title = arr_ch_play_address[i].innerHTML

                html_play += `<div class="play">${ch_play_img.outerHTML}</div>`
            }

            //  천안 숙소관련 배열 길이만큼 for문 <숙소이미지 및 숙소타이틀>
            for (let i = 0; i < arr_ch_sleep_img.length; i++) {
                let ch_sleep_img = arr_ch_sleep_img[i].querySelector('img')

                // let ch_sleep_title = arr_ch_sleep_title[i].innerHTML

                html_sleep += `<div class="sleep">${ch_sleep_img.outerHTML}</div>`

            }

            //  천안 시군관련 배열 길이만큼 for문 <시군이미지 및 시군타이틀>
            // for (let i = 0; i < arr_location_img.length; i++) {
            //     let cn_location_img = arr_location_img[i]

            //     let cn_location_title = arr_location_title[i].innerHTML
            //     html_location += `<a href="#" class="btn location${i}">${cn_location_title}</a>`
            // }

            // console.log(html) // html 출력값 확인
            // console.log(html_travel)
            // document.querySelector('.names').innerHTML = html_name
			
          

            header_menu();
            header_search();
            header_pop();
            leftbtn();
            rightbtn();
            sleep_slide();
            sleep_more_btn();
            init();

            let foods = document.querySelectorAll('.food')
            for (let i = 0; i < foods.length; i++) {
                foods[i].addEventListener('click', function () {
                    console.log(i)
                    if (i == 0) {
                        location.href = "ch_food_detail.jsp"
                    }
                    if (i == 1) {
                        location.href = "ch2_food_detail.html"
                    }
                    if (i == 2) {
                        location.href = "ch3_food_detail.html"
                    }
                    if (i == 3) {
                        location.href = "ch4_food_detail.html"
                    }
                    if (i == 4) {
                        location.href = "ch5_food_detail.html"
                    }

                })
            }

            let plays = document.querySelectorAll('.play')
            for (let i = 0; i < plays.length; i++) {
                plays[i].addEventListener('click', function () {
                    console.log(i)
                    if (i == 0) {
                        location.href = "ch_play_detail.html"
                    }
                    if (i == 1) {
                        location.href = "ch2_play_detail.html"
                    }
                    if (i == 2) {
                        location.href = "ch3_play_detail.html"
                    }
                    if (i == 3) {
                        location.href = "ch4_play_detail.html"
                    }
                    if (i == 4) {
                        location.href = "ch5_play_detail.html"
                    }

                })
            }

        }
    });
});


let result = new Array(2);

for (let i = 0; i < result.length; i++) {
    result[i] = new Array(2);
}

result[0][0] = "천안"


result[0][1] = "nx=63&ny=110"



const time = Date.now();
const data = new Date(time)
const data2 = new Date(time - (1000 * 60 * 60))

let year = data.getFullYear()
let month = Number(data.getMonth() + 1)
let date = data.getDate()
let hours = data.getHours()
let hours2 = data2.getHours()
let minutes = data.getMinutes()

let input_hours;
let check_hours;

if (Number(month) < 10) {
    month = "0" + month
}

if (Number(date) < 10) {
    date = "0" + date
}

if (Number(hours) < 10) {
    hours = "0" + hours
}

if (Number(hours2) < 10) {
    hours2 = "0" + hours
}

if (Number(minutes) < 30) {
    input_hours = hours2
    check_hours = hours
} else {
    input_hours = hours
    check_hours = Number(hours) + 1
}

if (Number(check_hours) < 10) {
    hours = "0" + hours
}

if (Number(check_hours) == 24) {
    check_hours = "00"
}

// console.log("123", check_hours)
for (let i = 0; i < result.length; i++) {
    let input_xy = result[i][1];
    let xhr = new XMLHttpRequest();
    //초단기예보조회 30분 기준
    let url = 'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst?serviceKey=p0SoGFiG3aqjvtpKGf3bVNkapK4cNQI6JDbPef4r6tHfXxZ7oWt%2F4Re%2Bbf8yQ2cSbE7zjUONKkBaZXRbgqh1vA%3D%3D&dataType=JSON&numOfRows=1000&pageNo=1&base_date=' + year.toString() + month + date + '&base_time=' + (input_hours).toString() + '30' + '&nx=63&ny=110'
    // console.log(url)
    xhr.open("GET", url);
    xhr.send();
    xhr.onload = function () {
        let data = JSON.parse(xhr.responseText)

        // console.log(xhr.responseText)
        // console.log(data)
        // for문 돌려서 배열 data값 일치할때만 출력

        let item = data.response.body.items.item

        for (let j = 0; j < item.length; j++) {

            // console.log(item[29])
            if (item[j].fcstTime == check_hours + "00") {
                // console.log(item[j].category, item[j].fcstValue)
                if (item[j].category == "PTY") {
                    result[i][2] = item[j].fcstValue
                }
                if (item[j].category == "SKY") {
                    result[i][3] = item[j].fcstValue
                }
                if (item[j].category == "T1H") {
                    result[i][4] = item[j].fcstValue
                }
                if (item[j].category == "REH") {
                    result[i][5] = item[j].fcstValue
                }
            }
        }
        // console.log("123",result[2][4])
        let weather = document.querySelector("#weather")
        let html_weather = '';

        for (let i = 4; i < 5; i++) {

            html_weather += result[0][4];

            // console.log(html_weather)
            
        }

        weather.innerHTML = html_weather;
        check(result[0]);
    }
}





function check(result) {
    let weather_img = document.querySelectorAll(".weather_img img")
    for (let i = 0; i < weather_img.length; i++) {
        weather_img[i].style.display = "none"
    }

    if (result[2] == 0) {
        if (result[3] == 1) {
            document.querySelector(".sunny").style.display = "block"
        } else {
            document.querySelector(".cloudy").style.display = "block"
        }
    } else {
        if (result[2] == 1 || result[2] == 2 || result[2] == 5 || result[2] == 6) {
            document.querySelector(".rain").style.display = "block"
        } else {
            document.querySelector(".snow").style.display = "block"
        }
    }

    // pty=2  0없음 1비 2비/눈 3눈 5빗방울 6빗방울눈날림 7눈날림
    // sky=3  1맑음 3구름많음 4흐림
    // t1h=4
    // reh=5
}


// check(result[0]);



// 숙소 더보기 클릭 메소드
function sleep_more_btn() {
    let sleep_more_btn = document.querySelector('.sleep_more_btn')
    sleep_more_btn.addEventListener('click', function () {
        location.href = "reservation.jsp"
    })
}



// 여행지 우클릭 슬라이드
let currentSlide = 1;
function rightbtn() {


    document.getElementById('btn2').addEventListener('click', function () {
        // let counter = 1;
        // console.log(counter)
        let slides = document.querySelector('.itemss')
        let slideimg = document.querySelectorAll('.item').length;
        let imgcount = document.querySelector('#count')
        if (currentSlide == 4) {
            imgcount.innerHTML = ("1" + " " + "/" + " " + "4")
        } else {
            imgcount.innerHTML = (currentSlide + 1 + " " + "/" + " " + 4)
        }
        // counter =-1;
        // console.log(slideimg)
        console.log(currentSlide);
        if (currentSlide >= slideimg - 2) {
            currentSlide = 0;
        }
        slides.style.transform = "translateX(-" + currentSlide * "415" + "px)";
        slides.style.transition = "transform 0.4s ease-in-out";
        currentSlide++;
    });

}
// 여행지 좌클릭 슬라이드           
function leftbtn() {
    // let currentSlide = 1;

    document.getElementById('btn1').addEventListener('click', function () {
        let slides = document.querySelector('.itemss')
        let slideimg = document.querySelectorAll('.item').length;
        let imgcount = document.querySelector('#count')
        if (currentSlide == 1) {
            imgcount.innerHTML = (4 + " " + "/" + " " + 4)
        } else {
            imgcount.innerHTML = (currentSlide - 1 + " " + "/" + " " + 4)
        }
        console.log("abc :", imgcount)
        // console.log('no2 :',slideimg)
        // console.log('no2 :', currentSlide)
        if (currentSlide === 1) {
            console.log(currentSlide)
            currentSlide = slideimg - 2;
        } else {
            currentSlide--;
        }
        slides.style.transform = "translateX(-" + (currentSlide - 1) * "415" + "px)";
        slides.style.transition = "transform 0.4s ease-in-out";

    });

}

// 숙소 사진 슬라이드        
let currentIndex = 1;
function sleep_slide() {
    let slides = document.querySelector('#sleep_img')
    let slideimg = document.querySelectorAll('.sleep').length;
    // console.log(currentIndex)
    if (currentIndex >= slideimg) {
        currentIndex = 0;
    }
    setInterval(function () {
        slides.style.transform = "translateX(-" + currentIndex * "1240" + "px)";
        slides.style.transition = "transform 0.4s ease-in-out";
        currentIndex++;
        //  console.log(currentIndex)

        if (currentIndex === 6) {
            currentIndex = - 1;
        }
    }, 2000);
}


// 하단 지역별 마우스 이벤트 및 a태그 이동

function init() {

    let sel = document.getElementById('sp_1');

    sel.addEventListener('mouseenter', function () {
        // console.log("마우스 올라감")
        sel.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D%20(1).png?raw=true");
    })

    sel.addEventListener('mouseleave', function () {
        sel.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(1).png?raw=true");
        // console.log("마우스 벗어남")
    })


    let sel_2 = document.getElementById('sp_2');

    sel_2.addEventListener('mouseenter', function () {
        // console.log("마우스 올라감")
        sel_2.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D%20(2).png?raw=true");
    })

    sel_2.addEventListener('mouseleave', function () {
        sel_2.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(2).png?raw=true");
        // console.log("마우스 벗어남")
    })

    let sel_3 = document.getElementById('sp_3');

    sel_3.addEventListener('mouseenter', function () {
        // console.log("마우스 올라감")
        sel_3.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D%20(3).png?raw=true");
    })

    sel_3.addEventListener('mouseleave', function () {
        sel_3.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(3).png?raw=true");
        // console.log("마우스 벗어남")
    })

    let sel_4 = document.getElementById('sp_4');

    sel_4.addEventListener('mouseenter', function () {
        // console.log("마우스 올라감")
        sel_4.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D%20(4).png?raw=true");
    })

    sel_4.addEventListener('mouseleave', function () {
        sel_4.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(4).png?raw=true");
        // console.log("마우스 벗어남")
    })

    let sel_5 = document.getElementById('sp_5');

    sel_5.addEventListener('mouseenter', function () {
        // console.log("마우스 올라감")
        sel_5.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D%20(5).png?raw=true");
    })

    sel_5.addEventListener('mouseleave', function () {
        sel_5.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(5).png?raw=true");
        // console.log("마우스 벗어남")
    })


    let sel_6 = document.getElementById('sp_6');

    sel_6.addEventListener('mouseenter', function () {
        // console.log("마우스 올라감")
        sel_6.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D%20(6).png?raw=true");
    })

    sel_6.addEventListener('mouseleave', function () {
        sel_6.setAttribute("src", "https://github.com/Jominsang1/FrontLine_Project/blob/main/%EC%88%99%EC%86%8C%EB%A9%94%EC%9D%B8/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%A7%80%EC%97%AD%EC%84%A0%ED%83%9D_%EC%9B%90%EB%B3%B8%20(6).png?raw=true");
        // console.log("마우스 벗어남")
    })


    sel.addEventListener('click', function () {
        location.href = "ch_main.jsp"
    })
    sel_2.addEventListener('click', function () {
        location.href = "./asan_main.html"
    })
    sel_3.addEventListener('click', function () {
        location.href = "./cheonAn_main.html"
    })
    sel_4.addEventListener('click', function () {
        location.href = "./cheonAn_main.html"
    })
    sel_5.addEventListener('click', function () {
        location.href = "./cheonAn_main.html"
    })
    sel_6.addEventListener('click', function () {
        location.href = "./cheonAn_main.html"
    })



}

