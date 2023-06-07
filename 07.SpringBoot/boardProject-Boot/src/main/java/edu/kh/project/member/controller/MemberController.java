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

}










