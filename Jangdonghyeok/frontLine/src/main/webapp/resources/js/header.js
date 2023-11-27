window.addEventListener("load", function(){
    header_image()
    header_menu()
    header_pop()
    header_search()
})

function header_image(){
    // 순서대로 천안부터 금산까지 이미지 불러오기
    let xhr = new XMLHttpRequest();
    let url = "./resources/data/ch_data.html"
    xhr.open("GET", url);
    xhr.send();
        
    xhr.onload = function () {
        let str = xhr.responseText
        let parser = new DOMParser()
        let data = parser.parseFromString(str, "text/html")

        let ch = data.querySelectorAll(".ch_travel img")[11]

        document.querySelector(".header_ch").prepend(ch)
    }

    let xhr2 = new XMLHttpRequest();
    let url2 = "./resources/data/Asan_data.html"
    xhr2.open("GET", url2);
    xhr2.send();
    xhr2.onload = function () {
        let str = xhr2.responseText
        let parser = new DOMParser()
        let data = parser.parseFromString(str, "text/html")
        let as = data.querySelectorAll(".asan_travel img")[5]

        document.querySelector(".header_as").prepend(as)
    }

    //태서당 부터 파일 없어져서 그냥 떼움
    let xhr3 = new XMLHttpRequest();
    let url3 = "./resources/data/Asan_data.html"
    xhr3.open("GET", url3);
    xhr3.send();
    xhr3.onload = function () {
        let str = xhr3.responseText
        let parser = new DOMParser()
        let data = parser.parseFromString(str, "text/html")

        let tsd = data.querySelectorAll(".asan_travel img")[2]

        document.querySelector(".header_tsd").prepend(tsd)
    }

    let xhr4 = new XMLHttpRequest();
    let url4 = "./resources/data/Asan_data.html"
    xhr4.open("GET", url4);
    xhr4.send();
    xhr4.onload = function () {
        let str = xhr4.responseText
        let parser = new DOMParser()
        let data = parser.parseFromString(str, "text/html")
        let yhc = data.querySelectorAll(".asan_travel img")[3]

        document.querySelector(".header_yhc").prepend(yhc)
    }

    let xhr5 = new XMLHttpRequest();
    let url5 = "./resources/data/Asan_data.html"
    xhr5.open("GET", url5);
    xhr5.send();
    xhr5.onload = function () {
        let str = xhr5.responseText
        let parser = new DOMParser()
        let data = parser.parseFromString(str, "text/html")

        let bbs = data.querySelectorAll(".asan_travel img")[4]

        document.querySelector(".header_bbs").prepend(bbs)
    }

    let xhr6 = new XMLHttpRequest();
    let url6 = "./resources/data/ch_data.html"
    xhr6.open("GET", url6);
    xhr6.send();
    xhr6.onload = function () {
        let str = xhr6.responseText
        let parser = new DOMParser()
        let data = parser.parseFromString(str, "text/html")

        let gss = data.querySelectorAll("img")[5]

        document.querySelector(".header_gss").prepend(gss)
    }
}

function header_menu(){
    // 카운트값 이용해서 마우스 위치 파악해서 메뉴팝업 메뉴에 마우스가 올라가면 1 아니면 0
    let pop_count = 0;
    let count = 0;
    let menu_img = document.querySelector("header .header_img")
    let menu_list = document.querySelector("header .menu")
    let display = document.querySelector("body")
	
	//카운트값으로 구분해서 block || none
    menu_img.addEventListener("click", function(){
        if(count == 0){
            menu_list.style.display = "block"
            count = 1;
        } else {
            menu_list.style.display = "none"
            count = 0;
        }
    })

    menu_img.addEventListener("mouseover", function(){
        pop_count = 1;
    })

    menu_img.addEventListener("mouseout", function(){
        pop_count = 0;
    })

    menu_list.addEventListener("mouseover", function(){
        pop_count = 1;
    })

    menu_list.addEventListener("mouseout", function(){
        pop_count = 0;
    })

    display.addEventListener("click", function(){
        if(pop_count == 0){
            menu_list.style.display = "none"
            count = 0;
        }
    })
}

// 리스트에서 밸류값과 일치하는 리스트만 보여주고 나머지는 지워준다
function header_search(){
    let input = document.querySelector("header .input")

    input.addEventListener("keyup", function(){
        // console.log(document.querySelector(".ch").textContent)
        // console.log(input.value)
        let count = 0;
        let list = document.querySelectorAll("header .input_list li")

        // console.log("result", String(list[0].textContent).search(input.value))
        // 일치 != -1 / 불일치 = -1

		// 일치하는 리스트가 있는지 모든 리스트를 확인 후 일치하면 카운트를 센다
        for(let i = 0; i<list.length; i++){
            if(String(list[i].textContent).search(input.value) == -1){
                count += 1;
            }
        }
		
		// 모두 불일치 할시~ 모든 리스트를 flex
        if(count == list.length){
            for(let i = 0; i<list.length; i++){
                list[i].style.display = "flex"
                // console.log("reset")
            }
        }  else { // 그 외에 일치하는 리스트를 따로 판단후 flex || none
            for(let i = 0; i<list.length; i++){
                if(String(list[i].textContent).search(input.value) == -1){
                    list[i].style.display = "none"
                } else {
                    list[i].style.display = "flex"
                }
            }
        }
    })
}

function header_pop(){
    // 인풋창 안에 있을때만 카운트를 1로 설정
    let pop_count = 0;
    let target = document.querySelector("header .input_wrap")
    let display = document.querySelector("body")
    let input = document.querySelector("header .input")

    target.addEventListener("mouseover", function(){
        pop_count = 1;
    })
    target.addEventListener("mouseout", function(){
        pop_count = 0;
    })
	
	//화면 전체에 클릭 이벤트를 걸고 카운트로 할 동작을 판단한다
    display.addEventListener("click", function(){
        if(pop_count == 0){
            let input = document.querySelector("header .input")
            input.style.borderBottomRightRadius = "30px"
            input.style.borderBottomLeftRadius = "30px"
            document.querySelector("header .input_list").style.display = "none"
        }
    })

    input.addEventListener("click", function(){
        if(pop_count == 1){
            input.style.borderBottomRightRadius = "0"
            input.style.borderBottomLeftRadius = "0"
            document.querySelector("header .input_list").style.display = "block"
        }
    })
}