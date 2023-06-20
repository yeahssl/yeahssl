package com.kh.test.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/index")
	public String selectUserid(String userId, Model model) {
		
		List<User> userList = service.selectUserid(user);
		
		int result = 0;
		String path = "redirect:/";
		
		if(result > 0) { //성공
			
			model.addAttribute("userList", userList);
			
			path += "/searchSuccess";
			
		}else { //실패
			
			ra.addFlashAttribute("message", "아이디를 확인해 주세요");
			path += "/searchFail";
			
		}
		
		return path; 
		
	}
	
}