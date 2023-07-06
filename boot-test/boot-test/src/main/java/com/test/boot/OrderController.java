package com.test.boot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class OrderController {

	@PostMapping("/orderProduct.do")
	public String buyItems(Model model, String name, int blackPen, int redPen, int bluePen, int white) {

		int total = (blackPen * 500) + (redPen * 700) + (bluePen * 700) + (white * 1000);

		System.out.println(total);
		if (total > 0) {

			model.addAttribute("name", name);
			model.addAttribute("blackPen", blackPen);
			model.addAttribute("redPen", redPen);
			model.addAttribute("bluePen", bluePen);
			model.addAttribute("white", white);
			model.addAttribute("total", total);
			
			return "resultPage";
		} else {

			return "redirect:error.do";
		}

	}

	@RequestMapping("/error.do")
	public String error() {
		return "errorPage";
	}

}
