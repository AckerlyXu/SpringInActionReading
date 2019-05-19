package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.error.SpitterHasExisted;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET)
public String home() {
	
	return "home";
}
	@RequestMapping(method=RequestMethod.GET,value="exception")
	public String exception() {
	throw new SpitterHasExisted();
	}
}
