package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

	
	@RequestMapping("/login")
	public String login() {
		
		return "/login";
	}
}
