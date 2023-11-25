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
import com.spring.frontline.dto.CommentDTO;
import com.spring.frontline.dto.SearchDTO;
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
	
	@RequestMapping("/goAdminComment")
	public String goAdminComment() {
		return "redirect:/getComment";
	}
	
	@RequestMapping("/goAdminBoard")
	public String goAdminBoard() {
		return "admin_addBoard";
	}
	
	@RequestMapping("/goAdminBoardList")
	public String goAdminBoardList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("searchColumn");
		session.removeAttribute("searchText");
		return "redirect:/getAdminBoard";
	}
	
	@RequestMapping("/goAdminBoardList2")
	public String goAdminBoardList2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return "redirect:/getAdminBoard";
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
			model.addAttribute("pageNum", pageNum);
			
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
	
	
	// 관리자 페이지에서 개인정보 수정
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
		    } else if(name.equals("userBirth")) {
		    	updateUserDTO.setUserBirth(request.getParameter(name));
		    }
		}

		System.out.println(updateUserDTO);
		
		mainService.updateUser(updateUserDTO);
		
		return "redirect:/goAdminUser";
	}
	
	// 내 정보 에서 개인정보수정
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
	
	// 관리자 페이지 유저목록 페이지당 개수
	@RequestMapping("/userSetPerPage")
	public String setPerPage(HttpServletRequest request, String countPerPage) {
		HttpSession session = request.getSession();
		
		session.setAttribute("countPerPage", countPerPage);
		
		return "redirect:/getUser";
	}
	
	@RequestMapping("/commentSetPerPage")
	public String commentSetPerPage(HttpServletRequest request, String countPerPage) {
		HttpSession session = request.getSession();
		
		session.setAttribute("countPerPage", countPerPage);
		
		return "redirect:/getComment";
	}
	
	@RequestMapping("/setBoardPerPage")
	public String setBoardPerPage(HttpServletRequest request, String countPerPage) {
		HttpSession session = request.getSession();
		
		session.setAttribute("countPerPage", countPerPage);
		
		return "redirect:/goAdminBoardList2";
	}
	
	@RequestMapping("/setBaordType")
	public String setBaordType(HttpServletRequest request, String typeSeq) {
		HttpSession session = request.getSession();
		
		session.setAttribute("typeSeq", typeSeq);
		
		session.removeAttribute("searchColumn");
		session.removeAttribute("searchText");
		return "redirect:/goAdminBoardList";
	}
	
	@RequestMapping("/setBoardRegion")
	public String setBoardRegion(HttpServletRequest request, String regionSeq) {
		HttpSession session = request.getSession();
		
		session.setAttribute("regionSeq", regionSeq);
		session.removeAttribute("searchColumn");
		session.removeAttribute("searchText");
		
		return "redirect:/goAdminBoardList";
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
	
	// 지역페이지 메인 리스트
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
	
	// 지역페이지 더보기 리스트
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
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("regionSeq", regionSeq);
		model.addAttribute("typeSeq", typeSeq);
		
		return "local_more";
	}
	
	// 지역 상세페이지
	@RequestMapping("/getBoardDetail")
	public String getBoardDetail(HttpServletRequest request, Model model, BoardDTO boardDTO) {
		
		BoardDTO dto = mainService.getBoard(boardDTO);
		List list = new ArrayList();
		
		try {
			list = mainService.getCommentList(boardDTO);
		} catch (IndexOutOfBoundsException e) {
			model.addAttribute("boardDTO", dto);
			return "local_detail";
		}
		
		model.addAttribute("boardDTO", dto);
		model.addAttribute("commentList", list);
		
		return "local_detail";
	}
	
	@RequestMapping("/addComment")
	public String addComment(HttpServletRequest request, Model model, CommentDTO commentDTO) {
		
		try {
			mainService.addComment(commentDTO);
			model.addAttribute("boardSeq", commentDTO.getBoardSeq());
			
			return "redirect:/getBoardDetail#commentSection";
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("msg", "댓글을 달려면 로그인이 필요합니다.");
			model.addAttribute("url", "getBoardDetail?boardSeq="+commentDTO.getBoardSeq());
			
			return "alert";
		}
		
	}
	
	@RequestMapping("/getComment")
	public String getComment(HttpServletRequest request, Model model, CommentDTO commentDTO) {
		HttpSession session = request.getSession();
		
		// commentSeq 필드값이 -1이면 리스트페이지에서 접속한 것으로 판단해서 전체목록, 아니면 유저정보 수정으로 판단해서 유저 한명의 정보만
		if(commentDTO.getCommentSeq() == -1) {
			
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
			
			Map map = mainService.getCommentPage(pageNum, countPerPage);
			
			model.addAttribute("map", map);
			model.addAttribute("pageNum", pageNum);
			
			
			return "admin_comment";
			
		} 
		else {
			commentDTO = mainService.getComment(commentDTO);
			
			session.setAttribute("updateCommentDTO", commentDTO);
			
			return "admin_updateComment";
		}
		
	}
	
	@RequestMapping("/updateAdminComment")
	public String updateAdminComment(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		CommentDTO updateCommentDTO = (CommentDTO)session.getAttribute("updateCommentDTO");
		
		updateCommentDTO.setCommentText(request.getParameter("commentText"));
		
		mainService.updateComment(updateCommentDTO);
		
		return "redirect:/goAdminComment";
	}
	
	@RequestMapping("/deleteComment")
	public String deleteComment(HttpServletRequest request, Model model) {
		
		Enumeration params = request.getParameterNames();
		
		List list = new ArrayList();
		
		while (params.hasMoreElements()){
			int target = Integer.parseInt((String)params.nextElement());
		    
			list.add(target);
		}
		
		mainService.deleteComment(list);
		
		return "redirect:/getUser";
	}
	
	// 게시물 등록
	@RequestMapping("/addBoard")
		public String addBoard(HttpServletRequest request, Model model, BoardDTO boardDTO) {
		
		System.out.println("addBoard Hi");
		mainService.insertBoard(boardDTO);
		
		return "goAdminBoard";
	}
	
	
	// 관리자 페이지 게시물 리스트출력
	@RequestMapping("/getAdminBoard")
	public String getAdminBoard(HttpServletRequest request, Model model, BoardDTO boardDTO) {
		HttpSession session = request.getSession();
		
		// commentSeq 필드값이 -1이면 리스트페이지에서 접속한 것으로 판단해서 전체목록, 아니면 유저정보 수정으로 판단해서 유저 한명의 정보만
		if(boardDTO.getBoardSeq() == -1) {
			
			int pageNum = 1;
			int countPerPage = 5;
			int typeSeq = 0;
			int regionSeq = 0;
			
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

			// select type값 판단한 후 맵에 담아줌
			String tmp_typeSeq = (String)session.getAttribute("typeSeq");
			
			if(tmp_typeSeq != null) {
				try { 
					typeSeq = Integer.parseInt(tmp_typeSeq);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			// select region값 판단한 후 맵에 담아줌
			String tmp_regionSeq = (String)session.getAttribute("regionSeq");
			
			if(tmp_regionSeq != null) {
				try { 
					regionSeq = Integer.parseInt(tmp_regionSeq);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			Map selectMap = new HashMap();
			
			String searchText = "";
			String tmp_searchText = request.getParameter("searchText");
			
			if(tmp_searchText != null) {
				try { 
					searchText = tmp_searchText;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
			
			// dto가 자동으로 불러오는게 input의 빈값도 불러와서 오류가 나는듯?
			if(!("".equals(searchText))) {
				
				selectMap.put("searchColumn", request.getParameter("searchColumn"));
				selectMap.put("searchText", searchText);
				
				session.setAttribute("searchColumn", request.getParameter("searchColumn"));
				session.setAttribute("searchText", searchText);
			} else {
				selectMap.put("searchColumn", session.getAttribute("searchColumn"));
				selectMap.put("searchText", session.getAttribute("searchText"));
			}
			
			
			System.out.println("request" + searchText);
			System.out.println("session" + session.getAttribute("searchText"));
			
			selectMap.put("pageNum", pageNum);
			selectMap.put("countPerPage", countPerPage);
			selectMap.put("typeSeq", typeSeq);
			selectMap.put("regionSeq", regionSeq);
			
			Map map = mainService.getAdminBoardPage(selectMap);
			
			model.addAttribute("map", map);
			model.addAttribute("pageNum", pageNum);
			
			
			return "admin_board";
			
		} 
		else {
			boardDTO = mainService.getAdminBoard(boardDTO);
			
			session.setAttribute("updateBoardDTO", boardDTO);
			
			return "admin_updateBoard";
		}
		
	}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(HttpServletRequest request, Model model) {
		
		Enumeration params = request.getParameterNames();
		
		List list = new ArrayList();
		
		while (params.hasMoreElements()){
			int target = Integer.parseInt((String)params.nextElement());
		    
			list.add(target);
		}
		
		mainService.deleteBoard(list);
		
		return "redirect:/getAdminBoard";
	}
	
	@RequestMapping("/updateAdminBoard")
	public String updateAdminBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		BoardDTO updateBoardDTO = (BoardDTO)session.getAttribute("updateBoardDTO");
		
		Enumeration params = request.getParameterNames();
		
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    
		    if(name.equals("regionSeq")) {
		    	updateBoardDTO.setRegionSeq(Integer.parseInt(request.getParameter("regionSeq")));
		    } else if(name.equals("typeSeq")) {
		    	updateBoardDTO.setTypeSeq(Integer.parseInt(request.getParameter("typeSeq")));
		    } else if(name.equals("boardTitle")) {
		    	updateBoardDTO.setBoardTitle(request.getParameter("boardTitle"));
		    } else if(name.equals("boardAddress")) {
		    	updateBoardDTO.setBoardAddress(request.getParameter("boardAddress"));
		    } else if(name.equals("boardOpen")) {
		    	updateBoardDTO.setBoardOpen(request.getParameter("boardOpen"));
		    } else if(name.equals("boardDetail")) {
		    	updateBoardDTO.setBoardDetail(request.getParameter("boardDetail"));
		    } else if(name.equals("boardBreak")) {
		    	updateBoardDTO.setBoardBreak(request.getParameter("boardBreak"));
		    } else if(name.equals("boardImage")) {
		    	updateBoardDTO.setBoardImage(request.getParameter("boardImage"));
		    }
		}
		mainService.updateBoard(updateBoardDTO);
		
		return "redirect:/goAdminBoardList";
	}
}
