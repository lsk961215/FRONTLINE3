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
		
		model.addAttribute("msg", "�쉶�썝媛��엯 �릺�뿀�뒿�땲�떎.");
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
		
		model.addAttribute("msg", dto.getUserName()+"占쎈뻷 占쎌넎占쎌겫占쎈�占쎈빍占쎈뼄.");
		model.addAttribute("url", "/frontline");
		
		return "alert";
	}
	
	@RequestMapping("/doLogout")
	public String doLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("userDTO");
		
		model.addAttribute("msg", "濡쒓렇�븘�썐 �븯���뒿�땲�떎.");
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
		
		// 占쎈솁占쎌뵬沃섎챸苑� 占쎄퐬占쎌뿫占쎌뱽 揶쏉옙占쎌죬占쏙옙占쎄퐣 占쎌뵬燁살꼹釉�筌롳옙 揶쏄낫而� 占쎈짗占쎌삂
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
	
//최현아
	@RequestMapping("/admin_travel_mgm")
	public String admin_travel_mgm() {
		return "travel/admin_travel_management";
	}
	@RequestMapping("/admin_travel_new")
	public String admin_travel_new() {
		return "travel/admin_travel_new";
	}
	
	@RequestMapping("/travelList")
	public String travelList(Model model) {
		List travelList = mainService.travelList();
		model.addAttribute("travelList", travelList);
		
		return "/travel/admin_travel_management";
	}
	
	@RequestMapping(value="/travelNew", method=RequestMethod.POST)
	public String travelNew(Model model ,@ModelAttribute BoardDTO dto) {
		System.out.println("dto.boardTitle : " + dto.getBoardTitle());
		dto.setUserSeq(24);
		dto.setTypeSeq(0);
		mainService.travelNew(dto);
		
		
		
		
		List travelList = mainService.travelList();
		
		model.addAttribute("travelList", travelList);
		
		
		
		return "/travel/admin_travel_management";
	}
	
}
