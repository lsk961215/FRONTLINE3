package com.spring.frontline.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.UserDTO;
import com.spring.frontline.service.MainService;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	MainService mainService;

	@RequestMapping("/")
	public String goMain() {
		return "main";
	}

	@RequestMapping("/goJoin_1")
	public String goJoin_1() {
		return "join_1";
	}

	@RequestMapping("/goJoin_2")
	public String goJoin_2() {
		return "join_2";
	}

	@RequestMapping("/goLogin")
	public String goLogin() {
		return "login";
	}

	@RequestMapping("/goInfo")
	public String goInfo() {
		return "info";
	}

	@RequestMapping("/goAdmin")
	public String goAdmin() {
		return "admin";
	}

	@RequestMapping("/goAdminUser")
	public String goAdminUser() {
		return "redirect:/getUser";
	}


	@RequestMapping("/doJoin")
	public String doJoin(HttpServletRequest request, Model model, @ModelAttribute UserDTO userDTO) {
		mainService.insertUser(userDTO);

		model.addAttribute("msg", "�쉶�썝媛��엯 �릺�뿀�뒿�땲�떎.");
		model.addAttribute("url", "/frontLine");

		return "alert";
	}

	@RequestMapping("/getUser")
	public String getUser(HttpServletRequest request, Model model, UserDTO userDTO) {
		HttpSession session = request.getSession();

		if (userDTO.getUserSeq() == -1) {
			List list = mainService.getUserList();

			model.addAttribute("userList", list);

			return "admin_user";
		} else {
			userDTO = mainService.getUser(userDTO);

			session.setAttribute("updateUserDTO", userDTO);

			return "admin_updateUser";
		}

	}

	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request, Model model, @RequestParam("userId") String userId,
			@RequestParam("userPw") String userPw) {
		HttpSession session = request.getSession();

		Map<String, String> map = new HashMap<String, String>();

		map.put("id", userId);
		map.put("pw", userPw);

		UserDTO dto = mainService.doLogin(map);

		session.setAttribute("userDTO", dto);

		model.addAttribute("msg", dto.getUserName() + "님 반갑습니다.");
		model.addAttribute("url", "/frontLine");

		return "alert";
	}

	@RequestMapping("/doLogout")
	public String doLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();

		session.removeAttribute("userDTO");

		model.addAttribute("msg", "로그아웃되었습니다.");
		model.addAttribute("url", "/frontline");

		return "alert";
	}

	@RequestMapping("/updateAdminUser")
	public String updateAdminUser(HttpServletRequest request) {
		HttpSession session = request.getSession();

		System.out.println("213" + request.getParameter("userName"));

		UserDTO updateUserDTO = (UserDTO) session.getAttribute("updateUserDTO");

		Enumeration params = request.getParameterNames();

		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();

			if (name.equals("userName")) {
				updateUserDTO.setUserName(request.getParameter(name));
			} else if (name.equals("userPw")) {
				updateUserDTO.setUserPw(request.getParameter(name));
			} else if (name.equals("userEmail")) {
				updateUserDTO.setUserEmail(request.getParameter(name));
			} else if (name.equals("userPhone")) {
				updateUserDTO.setUserPhone(request.getParameter(name));
			} else if (name.equals("userId")) {
				updateUserDTO.setUserId(request.getParameter(name));
			} else if (name.equals("gradeSeq")) {
				updateUserDTO.setGradeSeq(Integer.parseInt(request.getParameter(name)));
			} else if (name.equals("genderSeq")) {
				updateUserDTO.setGenderSeq(Integer.parseInt(request.getParameter(name)));
			} else if (name.equals("userbirth")) {
				updateUserDTO.setUserBirth(request.getParameter(name));
			}
		}

		System.out.println(updateUserDTO);

		mainService.updateUser(updateUserDTO);

		return "redirect:/goAdminUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");

		Enumeration params = request.getParameterNames();

		// �뙆�씪誘명꽣 �꽕�엫�쓣 媛��졇���꽌 �씪移섑븯硫� 媛곴컖 �룞�옉
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();

			if (name.equals("userName")) {
				userDTO.setUserName(request.getParameter(name));
			} else if (name.equals("userPw")) {
				userDTO.setUserPw(request.getParameter(name));
			} else if (name.equals("userEmail")) {
				userDTO.setUserEmail(request.getParameter(name));
			} else if (name.equals("userPhone")) {
				userDTO.setUserPhone(request.getParameter(name));
			}
		}

		mainService.updateUser(userDTO);

		return "info";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request, Model model) {

		Enumeration params = request.getParameterNames();

		List list = new ArrayList();

		while (params.hasMoreElements()) {
			int target = Integer.parseInt((String) params.nextElement());

			list.add(target);
		}

		mainService.deleteUser(list);

		return "redirect:/getUser";
	}

//	놀거리 등록페이지 이동
	@RequestMapping("/goAdminPlayNew")
	public String goPlayNew() {
		return "play_views/admin_play_new";
	}
	// 놀거리 등록
	@RequestMapping(value = "/playNew")
	public String insertPlay(@ModelAttribute BoardDTO boardDTO) {

		mainService.insertPlay(boardDTO);

		
		return "redirect:/playView";
	}

	
	//놀거리 선택
	@RequestMapping("/playCorrection")
	public String palyCorrection(Model model, @ModelAttribute BoardDTO boardDTO) {
		System.out.println("seq:" +boardDTO.getBoardSeq());
		
		BoardDTO board = mainService.getPlaycorr(boardDTO);
				
				model.addAttribute("play", board);
		
		return "play_views/admin_play_detail";
	}
	//놀거리 수정
	@RequestMapping(value = "/playUpdate", method = RequestMethod.POST)
	public String playUpdate(@ModelAttribute BoardDTO boardDTO, Model model) {

		mainService.updatePlay(boardDTO);
		
		model.addAttribute("boardSeq",boardDTO.getBoardSeq());
		
		
		return "redirect:/playView";
	}
	//놀거리 삭제
	@RequestMapping("/playDelete")
	public String deletePlay(@ModelAttribute BoardDTO boardDTO) {
		
		int delete = mainService.deletePlay(boardDTO);
				
		System.out.println("딜리트진행" + delete + "개 삭제");
				
		
		return "redirect:/playView";
	}
	
	//놀거리 목록 및 페이징
	@RequestMapping("/playView")
	public String playPaging(Model model, HttpServletRequest request) {
		

		//안넘어왔을때 0을 사용할수없으니깐 초기값 지정
		int pageNum = 1; //현재 페이지
		int countPerPage = 10; // 한페이지에 몇개 보여줄지
		
		String tmp_pageNum = request.getParameter("pageNum");
		//키값이 들어오지않았다면
		if(tmp_pageNum != null) {
			try {
				pageNum = Integer.parseInt(tmp_pageNum);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		String tmp_countPerPage = request.getParameter("countPerPage");
		//키값이 들어오지않았다면
		if(tmp_countPerPage != null) {
			try {
				countPerPage = Integer.parseInt(tmp_countPerPage);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//db에서 emp2 목록 전체 조회
//		List list = empService.getEmp2Page(pageNum,countPerPage);
		Map map = mainService.getPage(pageNum,countPerPage);
		
		map.put("pageNum", pageNum);
		map.put("countPerPage", countPerPage);
		
		logger.info("pageNum" + pageNum);
		logger.error("countPerPage" + countPerPage);
		
		//model에 담아서
		model.addAttribute("data", map);
		//jsp로 이동(forward)
		return "play_views/admin_play_management";
		
	}
	
	//놀거리 상세페이지
	@RequestMapping("/playPage")
	public String playPage (Model model, @ModelAttribute BoardDTO boardDTO) {
		
		BoardDTO board = mainService.getPlaycorr(boardDTO);
		
		model.addAttribute("play", board);
		
		return "play_views/play_page";
	}
	
	// 놀거리 더보기 목록 및 페이징
	@RequestMapping("/playMoreView")
	public String playMoreView( Model model, HttpServletRequest request) {
		
			
				int regiSeq = Integer.parseInt(request.getParameter("regionSeq"));
		//안넘어왔을때 0을 사용할수없으니깐 초기값 지정
				int pageNum = 1; //현재 페이지
				int countPerPage = 10; // 한페이지에 몇개 보여줄지
				
				String tmp_pageNum = request.getParameter("pageNum");
				//키값이 들어오지않았다면
				if(tmp_pageNum != null) {
					try {
						pageNum = Integer.parseInt(tmp_pageNum);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				String tmp_countPerPage = request.getParameter("countPerPage");
				//키값이 들어오지않았다면
				if(tmp_countPerPage != null) {
					try {
						countPerPage = Integer.parseInt(tmp_countPerPage);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				//db에서 play 목록 region에 맞춰 조회
//				List list = empService.getEmp2Page(pageNum,countPerPage);
				Map map = mainService.getMorePage(regiSeq, pageNum,countPerPage);
				
				map.put("pageNum", pageNum);
				map.put("countPerPage", countPerPage);
				
				logger.info("pageNum" + pageNum);
				logger.error("countPerPage" + countPerPage);
				
				//model에 담아서
				model.addAttribute("data", map);
				//jsp로 이동(forward)
		
		return "play_views/play_more";
	}
	
	// 지역 메인
//	@RequestMapping("/Boardlist")
}
