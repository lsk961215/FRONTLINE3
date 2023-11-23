package com.spring.frontline.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String goJoin_2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("joinMap");
		
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
	
	@RequestMapping("/goFindId")
	public String goFindId() {
		return "find_id";
	}
	
	@RequestMapping("/goFindPw")
	public String goFindPw() {
		return "find_pw";
	}
	
	@RequestMapping("/goAdminUser")
	public String goAdminUser() {
		return "redirect:/getUser";
	}
	
	@RequestMapping("/doJoin")
	public String doJoin(HttpServletRequest request, Model model, @ModelAttribute UserDTO userDTO) {
		HttpSession session = request.getSession();
		
		Map map = (HashMap)session.getAttribute("joinMap");
		
		boolean id = (Boolean)map.get("checkId");
		boolean email = (Boolean)map.get("checkEmail");
		boolean phone = (Boolean)map.get("checkPhone");
		
		System.out.println("id : " + id);
		System.out.println("email : " + email);
		System.out.println("phone : " + phone);
		
		if(id == true && email == true && phone == true) {
			mainService.insertUser(userDTO);
			model.addAttribute("msg", "회원가입 되었습니다.");
			model.addAttribute("url", "/frontline");
			
			return "alert";
		} else {
			model.addAttribute("msg", "입력된 값이 회원가입 형식에 맞지 않습니다.");
			model.addAttribute("url", "/goJoin_2");
			
			return "alert";
		}
	}
	
	@RequestMapping("/getUser")
	public String getUser(HttpServletRequest request, Model model, UserDTO userDTO) {
		HttpSession session = request.getSession();
		
		//userSeq 필드값이 -1이면 리스트페이지에서 접속한 것으로 판단해서 전체목록, 아니면 유저정보 수정으로 판단해서 유저 한명의 정보만
		if(userDTO.getUserSeq() == -1) {
			
			int pageNum = 1;
			int countPerPage = 5;
			
			String tmp_pageNum = request.getParameter("pageNum");
			
			if(tmp_pageNum != null) {
				try { 
					pageNum = Integer.parseInt(tmp_pageNum);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			// select 5개씩 10개씩 보기 세션에 올려둔 값 판단 (setPerPage)
			String tmp_countPerPage = (String)session.getAttribute("countPerPage");
			
			if(tmp_countPerPage != null) {
				try { 
					countPerPage = Integer.parseInt(tmp_countPerPage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			Map map = mainService.getUserPage(pageNum, countPerPage);
			
			model.addAttribute("map", map);
			
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
		
		try {
			UserDTO dto = mainService.doLogin(map);
			
			session.setAttribute("userDTO", dto);
			
			model.addAttribute("msg", dto.getUserName()+"님 환영합니다.");
			model.addAttribute("url", "/frontline");
			
			return "alert";
		} catch (NullPointerException e) {
			model.addAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			model.addAttribute("url", "goLogin");
			
			return "alert";
		}
		
	}
	
	@RequestMapping("/doLogout")
	public String doLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		model.addAttribute("msg", "로그아웃 하였습니다.");
		model.addAttribute("url", "/frontline");
		
		return "alert";
	}
	
	@RequestMapping("/updateAdminUser")
	public String updateAdminUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
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
	public String updateUser(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		UserDTO updateDTO = (UserDTO)session.getAttribute("userDTO");
		
		Enumeration params = request.getParameterNames();
		
		// 파라미터의 키값을 모두 가져와서 각 필드값의 이름과 비교 후 해당하는 그 필드만 수정
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    
		    if(name.equals("userName")) {
		    	updateDTO.setUserName(request.getParameter(name));
		    } else if(name.equals("userPw")) {
		    	updateDTO.setUserPw(request.getParameter(name));
		    } else if(name.equals("userEmail")) {
		    	updateDTO.setUserEmail(request.getParameter(name));
		    } else if(name.equals("userPhone")) {
		    	updateDTO.setUserPhone(request.getParameter(name));
		    }
		}
		
		try {
			mainService.updateUser(updateDTO);
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("msg", "다른 회원이 이미 사용중입니다.");
			model.addAttribute("url", "goInfo");
			
			return "alert";
		} finally {
			Map map = new HashMap();
			
			map.put("id", updateDTO.getUserId());
			map.put("pw", updateDTO.getUserPw());
			
			UserDTO dto = mainService.doLogin(map);
			
			session.setAttribute("userDTO", dto);
		}
		
		return "redirect:/goInfo";
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
	
	@RequestMapping("/makeDummy")
	@ResponseBody
	public String makeDummy() {
		mainService.insertDummy(50);
		return "완료";
	}
	
	@RequestMapping("/setPerPage")
	public String setPerPage(HttpServletRequest request, String countPerPage) {
		HttpSession session = request.getSession();
		
		session.setAttribute("countPerPage", countPerPage);
		
		return "redirect:/getUser";
	}
	
	@RequestMapping("/findId")
	public String findId(HttpServletRequest request, Model model , UserDTO userDTO) {
		
		System.out.println(userDTO);
		
		UserDTO findUserDTO = mainService.findId(userDTO);
		
		System.out.println(findUserDTO);
		
		model.addAttribute("findUserDTO", findUserDTO);
		
		return "find_id_result";
	}
	
	@RequestMapping("/findPw")
	public String findPw(HttpServletRequest request, Model model , UserDTO userDTO) {
		
		System.out.println("findPw : "+userDTO);
		UserDTO findUserDTO = mainService.findPw(userDTO);
		
		System.out.println(findUserDTO);
		
		
		if(userDTO.getUserBirth().equals(findUserDTO.getUserBirth())) {
			model.addAttribute("findUserDTO", findUserDTO);
			
			return "find_pw_result";
		} else {
			model.addAttribute("msg", "정보가 일치하지 않습니다.");
			model.addAttribute("url", "goFindPw");
			
			return "alert";
		}
	}
	
	
	@RequestMapping("/checkJoin")
	public String checkJoin(HttpServletRequest request, Model model, UserDTO joinDTO) {
		
		HttpSession session = request.getSession();
		
		String target = request.getParameter("checkTarget");
		
		System.out.println(target);
		
		Map map = (HashMap)session.getAttribute("joinMap");
		
		if(map == null) {
			map = new HashMap();
		}
		
		map.put("target", target);
		map.put("joinDTO", joinDTO);
		
		if("checkId".equals(map.get("target"))) {
			System.out.println("controller id 실행");
			boolean checkId = mainService.checkJoin(map);
			map.put("checkId", checkId);
		} else if("checkEmail".equals(map.get("target"))) {
			System.out.println("controller email 실행");
			boolean checkEmail = mainService.checkJoin(map);
			map.put("checkEmail", checkEmail);
		} else {
			System.out.println("controller phone 실행");
			boolean checkPhone = mainService.checkJoin(map);
			map.put("checkPhone", checkPhone);
		}
		
		session.setAttribute("joinMap", map);
		
		return "join_2";
	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(HttpServletRequest request, Model model, @RequestParam("regionSeq") String regionSeq) {
		
		Map resultMap = mainService.getBoardList(regionSeq);
		
		List regionNames = mainService.getRegionNames();
		
		int selectRegionSeq = Integer.parseInt(regionSeq);
		
		String regionName = (String) regionNames.get(Integer.parseInt(regionSeq));
		
		// 맵안에 "typeSeq"+i 형식으로 집어넣음
		model.addAttribute("boardListMap", resultMap);
		model.addAttribute("regionSeq", regionSeq);
		model.addAttribute("regionName", regionName);
		
		return "local_main";
	}
	
	@RequestMapping("/localMore")
	public String localMore(HttpServletRequest request, Model model, BoardDTO boardDTO) {
		
		HttpSession session = request.getSession();
		
		int regionSeq = boardDTO.getRegionSeq();
		int typeSeq = boardDTO.getTypeSeq();
		
		int pageNum = 1;
		int countPerPage = 20;
		
		String tmp_pageNum = request.getParameter("pageNum");
		
		if(tmp_pageNum != null) {
			try { 
				pageNum = Integer.parseInt(tmp_pageNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		Map selectMap = new HashMap();
		
		selectMap.put("pageNum", pageNum);
		selectMap.put("countPerPage", countPerPage);
		selectMap.put("regionSeq", regionSeq);
		selectMap.put("typeSeq", typeSeq);
		
		Map map = mainService.getBoardPage(selectMap);
		
		model.addAttribute("map", map);
		model.addAttribute("regionSeq", regionSeq);
		model.addAttribute("typeSeq", typeSeq);
		
		return "local_more";
	}
	
	@RequestMapping("/getBoardDetail")
	public String getBoardDetail(HttpServletRequest request, Model model, BoardDTO boardDTO) {
		
		BoardDTO dto = mainService.getBoard(boardDTO);
		
		model.addAttribute("boardDTO", dto);
		return "local_detail";
	}
}
