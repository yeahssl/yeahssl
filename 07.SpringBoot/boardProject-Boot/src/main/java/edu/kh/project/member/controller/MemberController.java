package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/member")
@Controller
@SessionAttributes({"loginMember"})
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@PostMapping("/login")
	   public String login(Member inputMember, Model model
	         , @RequestHeader(value="referer") String referer
	         , @RequestParam(value="saveId", required=false) String saveId
	         , HttpServletResponse resp
	         , RedirectAttributes ra
	         ) {
	      
	      Member loginMember = service.login(inputMember);
	      
	      String path = "redirect:"; 
	      
	      if(loginMember != null) { 
	         path += "/"; 
	         
	         model.addAttribute("loginMember", loginMember);
	         
	         Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
	         
	         if(saveId != null) { 
	            cookie.setMaxAge(60 * 60 * 24 * 30); 
	            
	         }else { 
	            cookie.setMaxAge(0);
	         }
	         
	         cookie.setPath("/"); 
	         
	         resp.addCookie(cookie);
	         
	         
	      } else { 
	         path += referer; 
	         
	         ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
	         
	      }
	      
	      return path;
	   }
	
	   // 로그아웃
	   @GetMapping("/logout")
	   public String logout(SessionStatus status, HttpSession session) {
	      status.setComplete(); 
	      return "redirect:/";
	   }
	   
	   
	   // 회원 가입 페이지 이동
	   @GetMapping("/signUp")
	   public String signUp() {
	      // /WEB-INF/views/member/signUp.jsp  forward(요청 위임)
	      // -> ViewResovler가 prefix, suffix를 리턴 값 앞,뒤에 붙임
	      return "member/signUp";
	   }
	   
	   // 회원 가입 진행
	   @PostMapping("/signUp")
	   public String signUp(Member inputMember
	            , String[] memberAddress
	            , RedirectAttributes ra) {
	      
	      
	      // 만약 주소를 입력하지 않은 경우(,,) null로 변경
	      if(inputMember.getMemberAddress().equals(",,")) {
	         inputMember.setMemberAddress(null);
	      
	      }else {
	         //String.join("구분자", String[])
	         // 배열의 요소를 하나의 문자열로 변경
	         // 단, 요소 사이에 "구분자" 추가
	         String addr = String.join("^^^", memberAddress);
	         inputMember.setMemberAddress(addr);
	      }
	      
	      
	      // 회원 가입 서비스 호출
	      // (DB에 DML 수행 시 성공 행의 개수(int형) 반환)
	      int result = service.signUp(inputMember);
	      
	      // 가입 성공 여부에 따라 주소 결정
	      String path = "redirect:";
	      String message = null;
	      
	      if(result > 0) { // 가입 성공
	         path += "/"; // 메인 페이지
	         
	         message = inputMember.getMemberNickname() + "님의 가입을 환영합니다.";
	         
	      } else { // 가입 실패
	         // 회원 가입 페이지
	    	  
	         path += "signUp";  // 상대 경로
	         
	         message = "회원 가입 실패!";
	      }
	      
	      // 리다이렉트 시 session에 잠깐 올라갔다 내려오도록 세팅
	      ra.addFlashAttribute("message", message);
	      
	      return path;
	   }

}










