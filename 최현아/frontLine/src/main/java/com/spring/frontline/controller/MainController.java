package com.spring.frontline.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSender mailSender;
	
	// 메인페이지
	@RequestMapping("/")
	public String goMain(Model model) {
		List popup = mainService.popup1();
		System.out.println(popup);
		model.addAttribute("popup", popup);
		
		return "main";
	}
	// 회원가입 이용약관동의 페이지
	@RequestMapping("/goJoin_1")
	public String goJoin_1() {
		return "join_1";
	}
	//회원가입 input페이지
	@RequestMapping("/goJoin_2")
	public String goJoin_2() {
		return "join_2";
	}
	// 로그인페이지
	@RequestMapping("/goLogin")
	public String goLogin() {
		return "login";
	}
	// 내정보페이지
	@RequestMapping("/goInfo")
	public String goInfo() {
		return "info";
	}
	// 관리자 페이지
	@RequestMapping("/goAdmin")
	public String goAdmin() {
		return "admin";
	}
	// 관리자-회원페이지-회원관리 페이지
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
	
	// 관리자-회원페이지-회원관리 페이지
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
	
	// 내정보 페이지
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
///////// 관리자 여행지 //////////
	
	// 관리자-여행지관리 페이지, 그냥 접속용 
	@RequestMapping("/admin_travel_mgm")
	public String admin_travel_mgm() {
		return "travel/admin_travel_management";
	}
	// 관리자-여행지등록 페이지
	@RequestMapping("/admin_travel_new")
	public String admin_travel_new() {
		return "travel/admin_travel_new";
	}
	
	// 관리자-여행지관리 페이지(목록)
	@RequestMapping("/travelList")
	public String travelList(Model model) {
		System.out.println("/travelList");
		List travelList = mainService.travelList();
		model.addAttribute("travelList", travelList);
		
		return "/travel/admin_travel_management";
	}
	
	// 관리자-여행지등록 페이지(제출 후)
	@RequestMapping(value="/travelNew", method=RequestMethod.POST)
	public String travelNew(Model model ,@ModelAttribute BoardDTO dto) {
		System.out.println("dto : " + dto);
//		dto.setUserSeq(24);
		dto.setTypeSeq(0);
	
		mainService.travelNew(dto);
		
		List travelList = mainService.travelList();
		
		model.addAttribute("travelList", travelList);
		
		return "/travel/admin_travel_management";
	}
	// 관리자-여행지관리 페이지(삭제)
	@RequestMapping("/travelDelete")
	public String travelDelete(HttpServletRequest request, Model model) {
		String[] boardDelete = request.getParameterValues("boardDelete");
		for(int i=0; i<boardDelete.length; i++) {
			System.out.println("boardDelete[" + i + "] : " + boardDelete[i]);
		}
		mainService.travelDelete(boardDelete);
		List travelList = mainService.travelList();
		model.addAttribute("travelList", travelList);
		return "/travel/admin_travel_management";
	}
	// 관리자-여행지관리 페이지(수정전 리스트조회)
	@RequestMapping("/travelUpdate")
	public String travelUpdate(BoardDTO dto, Model model) {
		System.out.println("/travelUpdate");
		
		BoardDTO beforeUpdate = mainService.travelUpdate(dto);
		model.addAttribute("beforeUpdate", beforeUpdate);
		return "/travel/admin_travel_update";
	}
	// 관리자-여행지관리 페이지(수정)
	@RequestMapping("/travelBoardUpdate")
	public String travelBoardUpdate(BoardDTO dto, Model model) {
		System.out.println("/travelBoardUpdate");
		System.out.println("dto : " + dto);
		mainService.setBoard(dto);
		
		BoardDTO beforeUpdate = mainService.travelUpdate(dto);
		model.addAttribute("beforeUpdate", beforeUpdate);
		
		return "/travel/admin_travel_update";
	}
	// 관리자-여행지관리 페이지(검색)
	@RequestMapping("/boardPick")
	public String boardPick(BoardDTO dto, Model model) {
		System.out.println("/boardPick 실행");
		System.out.println("boardPick() --> dto 실행 : " + dto);
		List boardPick = null;
		if(dto.getBoardSearch() != null && dto.getTypeSeq() == 0) {
			if(dto.getBoardPick() == 0) {
				boardPick = mainService.boardPick1(dto);
				System.out.println("검색셀렉트 출력 : " + boardPick);
			}else if(dto.getBoardPick() == 1) {
				boardPick = mainService.boardPick2(dto);
				System.out.println("검색셀렉트 출력 : " + boardPick);
			}else if(dto.getBoardPick() == 2) {
				boardPick = mainService.boardPick3(dto);
				System.out.println("검색셀렉트 출력 : " + boardPick);
			}else if(dto.getBoardPick() == 3) {
				boardPick = mainService.boardPick4(dto);
				System.out.println("검색셀렉트 출력 : " + boardPick);
			}else {
				boardPick = mainService.travelList();
			}
		}
		
		model.addAttribute("travelList", boardPick);
		
		return "/travel/admin_travel_management";
	
	}
	
	// 페이징 재료(게시물 인서트)
	@RequestMapping("/makeDummy")
	@ResponseBody
	public String makeDummy() {
		mainService.insertDummy(20);
		
		return "완료";
	}
	
//////// 여행지 상세 페이지 /////////
	
	
	@RequestMapping("/chMain")
	public String chMain() {
		return "/detail/ch_main";
	}
	@RequestMapping("/chMain2")
	public String chMain2() {
		return "/detail/ch_main_2";
	}
	@RequestMapping("/travelPage")
	public String travelPage() {
		return "/detail/travel_page";
	}
/////// 관리자 팝업 페이지 ///////
	
	// 관리자 - 팝업관리 페이지(목록)
	@RequestMapping("/adminPopup")
	public String adminPopup(Model model) {
		List popup = mainService.popup1();
		System.out.println(popup);
		model.addAttribute("popup", popup);
		return "/popup/admin_popup";
	}
	@RequestMapping("for_check")
	public String for_check() {
		return "/popup/admin_popup_update";
	}
	
	// 관리자 - 팝업관리 페이지(수정전 리스트조회)
	@RequestMapping("/popupReadyUpdate")
	public String popupReadyUpdate(@RequestParam Map map, Model model) {
		System.out.println("/popupReadyUpdate Controller 실행");
		System.out.println("map : " + map);
		Map popupUpdateList = mainService.popupReadyUpdate(map);
		model.addAttribute("updateList", popupUpdateList);
		return "/popup/admin_popup_update";
	}
	// 관리자 - 팝업관리 페이지(수정)
	@RequestMapping("/popupUpdate")
	public String popupUpdate(@RequestParam Map map, Model model) {
		System.out.println("popupUpdate(map) Controller 실행 : " + map);
		
		mainService.popupUpdate(map);
		
		return "redirect:/adminPopup";
	}
	
/////// 비밀번호 찾기 페이지 ///////
	@RequestMapping("/findPw")
	public String findPw() {
		return "/find/find_password";
	}
	@RequestMapping("/relayNum")
	public String relayNum(@RequestParam int num, Model model) {
		System.out.println("num");
		model.addAttribute(num);
		return "/find/find_password_way";
	}
	
	// 1차 검증 - 아이디
	@RequestMapping("/sameId")
	public String sameId(UserDTO dto, Model model) {
		System.out.println("/sameId 실행 -> dto.getUserId()값 : " + dto.getUserId());
		UserDTO findId = mainService.sameId(dto);
		System.out.println("=====findId.getUserName()의 값====== : " + findId.getUserId());
		System.out.println("controller -> sql에서 받아온 값 : " + findId);
		
		model.addAttribute("idDto", findId);
		
		return "/find/find_password_way";
	}
	
	// 인증번호 받기
	@RequestMapping("/getNumber")
	public String getNumber(UserDTO dto, Model model, @RequestParam String receivedEmail, HttpServletRequest request) {
		System.out.println("/getNumber dto 출력 : " + dto);
		System.out.println("/getNumber dto.getUserEmail() : " + dto.getUserEmail());
		System.out.println("receivedEmail :" + receivedEmail);
		String userEmail = dto.getUserEmail();

		
		Random r = new Random();
		int num = r.nextInt(999999);
	
		if(dto.getUserEmail().equals(receivedEmail)) {
			System.out.println("num : " + num);
			
			StringBuilder sb = new StringBuilder();
			String setFrom = "chahh3994@naver.com"; // 수신자
			String toMail = dto.getUserEmail();	// 발신자
			String title = "[놀아유] 비밀번호 변경 인증 이메일입니다.";
			sb.append(String.format("안녕하세요 %s님\n", dto.getUserName()));
			sb.append(String.format("놀아유 비밀번호 찾기(변경) 인증번호는 %d입니다.", num));
			
			String content = sb.toString();
			System.out.println("content : " + content);
			
			try {
				MimeMessage msg = mailSender.createMimeMessage();
				MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "utf-8");
				msgHelper.setFrom(setFrom);
				msgHelper.setTo(toMail);
				msgHelper.setSubject(title);
				msgHelper.setText(content);
				
				// 메일 전송
				mailSender.send(msg);
				System.out.println("메일전송준비");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("에러발생");
//				System.out.println(e.getMessage());
			}
			// 메일 보낸 경우
			model.addAttribute("msg1","인증번호가 발송되었습니다.");
			model.addAttribute("url1", "/frontline/pwWay");
			model.addAttribute("comparison", "1");
			model.addAttribute("num", num);
			HttpSession session = request.getSession();
			session.setAttribute("confirmedNum", num);
			return "alert";
		}
		model.addAttribute("msg2","회원정보 이메일과 불일치합니다.");
		model.addAttribute("url2","/frontline/pwWay");
		model.addAttribute("comparison2","2");
		return "alert";
	}
	
	// 받은 인증번호 체크 (일치/불일치)
	@RequestMapping("/checkNumber")
	public String checkNumber(@RequestParam int putKey,HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		int confirmedNum = (Integer) session.getAttribute("confirmedNum");
		System.out.println("confirmedNum : " + confirmedNum);
		System.out.println("putKey : " + putKey);
		
		if(confirmedNum == putKey) {
			model.addAttribute("msg3","확인되었습니다.");
			model.addAttribute("url3", "/frontline/setNewPw");
			model.addAttribute("comparison3", "3");
//			model.addAttribute("finalCheck", "7");
			return "alert";
		}
		model.addAttribute("msg4","인증번호가 틀렸습니다.");
		model.addAttribute("url4", "/frontline/pwWay");
		model.addAttribute("comparison4", "4");
		
		return "alert";
	}
	
	@RequestMapping("/pwWay")
	public String pwWay() {
		return "/find/find_password_way";
	}
	@RequestMapping("/setNewPw")
	public String setNewPw() {
		return "/find/set_new_password";
	}
	
//	@RequestMapping("/BoardList")
//	public String getBoardList() {
//		return "/detail/ch_main";
//	}
//	@RequestMapping("/popup1")
//	public String popup1(Model model) {
//		
//		model.addAttribute(popup);
//		${List[0].}
//		return "main";
//	}
//	@RequestMapping("/popup2")
//	public String popup2() {
//		return "main";
//	}
//	
	
}
