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
		model.addAttribute("url", "/frontLine");
		
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
	
	//맛집 등록 접속
	@RequestMapping("/addEat")
	public String addEat() {
		return "admin_eat_new";
	}
	
//	@RequestMapping("/eatResultGo")
//	public String eatResultGo(Model model, HttpServletRequest request) {
//		int pageNum = 1;
//		int countPerPage = 10;
//		
//		String info_pageNum = request.getParameter("info_pageNum");
//		if(info_pageNum != null) {
//			try {
//				
//				pageNum = Integer.parseInt(info_pageNum);
//			
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		String info_countPerPage = request.getParameter("info_countPerPage");
//		if(info_countPerPage != null) {
//			try { 
//
//				countPerPage = Integer.parseInt(info_countPerPage);
//			
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		//db에서 
//		//목록을 가지고 오고 
//		//어디엔가 담아서 
//		//jsp로 보낸다
//		//jsp에서 꺼내서 표시한다
//		//List list = mainService.getBoardInfoList();
//		List list = mainService.getBoardInfoList(pageNum, countPerPage);
//		//이건 모든걸 가져오는거라 안씀
//		model.addAttribute("list", list);
//		return "admin_eat_management";
//	}
	
	//맛집 리스트
	@RequestMapping("/eatResultGo")
	public String eatResultGo(Model model) {
		//db에서 
		//목록을 가지고 오고 
		//어디엔가 담아서 
		//jsp로 보낸다
		//jsp에서 꺼내서 표시한다
		//List list = mainService.getBoardInfoList();
		List list = mainService.getBoardInfoList();
		//이건 모든걸 가져오는거라 안씀
		model.addAttribute("list", list);
		return "admin_eat_management";
	}
	
	//insert 맛집 등록
	@RequestMapping(value= "/eatResult", method=RequestMethod.POST)
	public String eatResult(
			@RequestParam ("regionSeq") int regionSeq,
			@ModelAttribute BoardDTO dto
			) {	
				mainService.insertBoardDTO(dto);
				// 결과를 jsp로 보낸다
				////등록에서 입력한 값을 목록으로 보냄
				return "forward:/eatResultGo";
	}
	
	//select 맛집 상세페이지
	@RequestMapping(value="/adminEatDetail")
	public String admin_eat_detail(@ModelAttribute BoardDTO dto,
			Model model) {
		//System.out.println(dto.getBoardSeq());
		BoardDTO data = mainService.detailBoardDTO(dto);
		model.addAttribute("dto", data);
		return "admin_eat_update";
	}
	
	//update 맛집 상세 페이지 수정
	@RequestMapping(value="/adminEatUpdate" , method=RequestMethod.POST)
	public String admin_eat_update(@ModelAttribute BoardDTO dto
			) {
		//System.out.println("dto" + dto. toString());
		mainService.updateBoardDTO(dto);
		return "forward:/adminEatDetail";
	}
	
	
	//delete 맛집 삭제
	@RequestMapping(value="/adminEatDelete")
	public String admin_eat_delete(
			//@RequestParam ("ck") int[] ck
			HttpServletRequest request
			) {
//		for(int i = 0; i<ck.length; i++) {
//			System.out.println(ck[i]);
//		}
		String[] ck = request.getParameterValues("ck");
//		for(int i = 0; i<ck.length; i++) {
//			System.out.println(ck[i]);		
//		}
		
		List list = new ArrayList();
		
		for(int i = 0; i<ck.length; i++) {
			list.add(ck[i]);
		}
		
		mainService.deleteBoardDTO(list);
		return "forward:/eatResultGo";
	}
	
	//아이디 찾기 페이지 접속
	@RequestMapping("/goFindId")
	public String goFindId() {
		return "find_id";
	}
	
	//아이디 조회
	@RequestMapping("/FindId")
	public String select_id(@ModelAttribute UserDTO dto, Model model) {
		//dto 받아서 아이디 결과 페이지에 반환
		//jsp에서 출력
		//System.out.println(dto.toString());
		UserDTO data = mainService.findUser(dto);
		model.addAttribute("dto", data);
		
		return "find_id_2";
	}
	
	
}
