package com.spring.frontline.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.frontline.dto.BoardDTO;
import com.spring.frontline.dto.UserDTO;
import com.spring.frontline.service.MainService;

@Controller
public class MainController {
	
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
		
		model.addAttribute("msg", "회원가입 되었습니다.");
		model.addAttribute("url", "/frontline");
		
		return "alert";
	}
	
	@RequestMapping("/getUser")
	public String getUser(HttpServletRequest request, Model model, UserDTO userDTO) {
		HttpSession session = request.getSession();
		
		if(userDTO.getUserSeq() == -1) {
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
	public String doLogin(HttpServletRequest request, Model model, @RequestParam("userId") String userId, @RequestParam("userPw") String userPw) {
		HttpSession session = request.getSession();
		
		Map<String, String> map= new HashMap<String, String>();
		
		map.put("id", userId);
		map.put("pw", userPw);
		
		UserDTO dto = mainService.doLogin(map);
		
		session.setAttribute("userDTO", dto);
		
		model.addAttribute("msg", dto.getUserName()+"�떂 �솚�쁺�빀�땲�떎.");
		model.addAttribute("url", "/frontline");
		
		return "alert";
	}
	
	@RequestMapping("/doLogout")
	public String doLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("userDTO");
		
		model.addAttribute("msg", "로그아웃 하였습니다.");
		model.addAttribute("url", "/frontline");
		
		return "alert";
	}
	
	@RequestMapping("/updateAdminUser")
	public String updateAdminUser(HttpServletRequest request) {
		HttpSession session = request.getSession();

		
		System.out.println("213"+request.getParameter("userName"));
		
		UserDTO updateUserDTO = (UserDTO)session.getAttribute("updateUserDTO");
		
		Enumeration params = request.getParameterNames();
		
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    
		    if(name.equals("userName")) {
		    	updateUserDTO.setUserName(request.getParameter(name));
		    } else if(name.equals("userPw")) {
		    	updateUserDTO.setUserPw(request.getParameter(name));
		    } else if(name.equals("userEmail")) {
		    	updateUserDTO.setUserEmail(request.getParameter(name));
		    } else if(name.equals("userPhone")) {
		    	updateUserDTO.setUserPhone(request.getParameter(name));
		    } else if(name.equals("userId")) {
		    	updateUserDTO.setUserId(request.getParameter(name));
		    } else if(name.equals("gradeSeq")) {
		    	updateUserDTO.setGradeSeq(Integer.parseInt(request.getParameter(name)));
		    } else if(name.equals("genderSeq")) {
		    	updateUserDTO.setGenderSeq(Integer.parseInt(request.getParameter(name)));
		    } else if(name.equals("userbirth")) {
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
		UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
		
		Enumeration params = request.getParameterNames();
		
		// �뙆�씪誘명꽣 �꽕�엫�쓣 媛��졇���꽌 �씪移섑븯硫� 媛곴컖 �룞�옉
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    
		    if(name.equals("userName")) {
		    	userDTO.setUserName(request.getParameter(name));
		    } else if(name.equals("userPw")) {
		    	userDTO.setUserPw(request.getParameter(name));
		    } else if(name.equals("userEmail")) {
		    	userDTO.setUserEmail(request.getParameter(name));
		    } else if(name.equals("userPhone")) {
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
		
		while (params.hasMoreElements()){
			int target = Integer.parseInt((String)params.nextElement());
		    
			list.add(target);
		}
		
		mainService.deleteUser(list);
		
		return "redirect:/getUser";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/goReservation")
	public String goReservation() {
		return "reservation";
	}
	
//	goAdmin_room_management 에서 신규등록하면 goAdmin_room_new으로
//	이동하고 goAdmin_room_new 에서 서브밋하면 goAdmin_room_management 이 주소로 이동
	
//	@RequestMapping("/goAdmin_room_management")
//	public String goAdmin_room_management(Model model, BoardDTO boardDTO){
//
//		List<BoardDTO> list = mainService.list(); 
//		model.addAttribute("list", list);
//		System.out.println("BoardDTO : " + boardDTO);
//		return "room/admin_room_management";
//	}
	
	@RequestMapping("/goAdmin_room_new")
	public String goAdmin_room_new() throws Exception{
		return "room/admin_room_new";
	}
		
	@RequestMapping(value="/insertAdmin_room", method=RequestMethod.POST)
	public String insertAdmin_room(
			@RequestParam("regionSeq") int regionSeq,
			@ModelAttribute  BoardDTO boardDTO
			) throws Exception{
		mainService.insertBoard(boardDTO);
		
		return "redirect:/goAdmin_room_management";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody // 리턴값을 그대로 돌려주는 역할 / jsp로 안보냄
	public int deleteAdmin_room(HttpServletRequest request) {
		// 스트링을 받을 순 있지만 리턴할때는 인트로 그걸 세서 보내야됨
		String[] delete = request.getParameterValues("valueArr"); // 체크된 값들을 넣음
		int size = delete.length;
		int delreturn = 0;
		
		for(int i =0; i<size; i++) {
			delreturn += mainService.deleteBoard(delete[i]);

		}		
//			System.out.println("delreturn : " + delreturn);	
		return delreturn;
	}
	
	@RequestMapping("/updatePage")
	public String updateAdmin_page(BoardDTO boardDTO, Model model) {
		
		BoardDTO updatePage = mainService.updatePage(boardDTO);
		System.out.println("updatePage : " + updatePage);
		
		model.addAttribute("updatePage", updatePage);
		
		return "room/admin_room_update";
	}
		
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateAdmin_room(BoardDTO boardDTO) {
		
		System.out.println("updateAdmin_room : " + boardDTO);
		mainService.updateBoard(boardDTO);
		
		// 등록한 날짜/시간데이터를 받을 수 있는게 없어서
		// 업데이트 할때라 지워줬음
		
		return "redirect:/goAdmin_room_management";
	}
	
	// dto 다시 불러와서 다시
	
	
	
	
	@RequestMapping("/goAdmin_room_management")
	public String pagingAdmin_room(HttpServletRequest request, Model model, BoardDTO boardDTO) {
		
//		List<BoardDTO> list = mainService.list(); 
//		model.addAttribute("just", list);
		System.out.println("BoardDTO boardDTO 입니다 : " + boardDTO);
		int pageNum = 1;
		int countPerPage = 10;
		
		String tmp_pageNum = request.getParameter("pageNum");
		if(tmp_pageNum != null) {
			try {
				pageNum = Integer.parseInt(tmp_pageNum);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		String tmp_countPerPage = request.getParameter("countPerPage");
		
		if(tmp_countPerPage != null) {
			try {
				countPerPage = Integer.parseInt(tmp_countPerPage);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
				
		Map map = mainService.pageBoard(pageNum, countPerPage);
		map.put("pageNum", pageNum);
		map.put("countPerPage", countPerPage);
		
		model.addAttribute("data", map);
		
//		return map;
		return "room/admin_room_management";
	}
	
	@RequestMapping("/go_room_page")
	public String go_room_page(BoardDTO boardDTO) {
		
		
		return "room/room_page";
	}
	
	@RequestMapping("/boardPick")
	public String boardPick( BoardDTO boardDTO, Model model) {
		System.out.println("/boardPick 실행");
		System.out.println("boardPick() --> dto 실행 : " + boardDTO);
		
		List boardPick = null;
		
		if(boardDTO.getBoardSearch() != null && boardDTO.getTypeSeq() == 3) {
			if(boardDTO.getBoardPick() == 0) {
				boardPick = mainService.boardPick1(boardDTO);
				System.out.println("검색셀렉트 출력 : " + boardPick);
			}else if(boardDTO.getBoardPick() == 1) {
				boardPick = mainService.boardPick2(boardDTO);
				System.out.println("검색셀렉트 출력 : " + boardPick);
			}else {
//				boardPick = mainService.travelList();
				System.out.println("전체실행");
				return "redirect:/goAdmin_room_management";
			}
		}
		
		
		Map map = new HashMap();
		map.put("list", boardPick);
		
		model.addAttribute("data", map);
		return "room/admin_room_management";
	
	}

		
		
		
	// 페이징 / 검색 / 정렬(날짜순,이름순등등..)
	// 회원가입 / 로그인	
	
}
	
	
