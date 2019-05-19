package spittr.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

import spittr.data.SpitterRepository;
import spittr.error.SpitterHasExisted;
import spittr.error.SpittleNotFoundException;
import spittr.model.Spitter;

@Controller
@RequestMapping("/spitter")
@Transactional
public class SpitterController {


	@Autowired()
	@Qualifier("jpaSpitterRepository")
 private  SpitterRepository spitterRepository;
	
	public SpitterController() {
		super();
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegisterationForm(Model model) {
		model.addAttribute("spitter", new Spitter());
		return "registerForm";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegisteration(@RequestPart("profilePicture")MultipartFile profilePicture,@Valid Spitter spitter,Errors errors,
			HttpServletRequest request,
			RedirectAttributes model) {
		if(errors.hasErrors()) {
			//sippers.add(spitter);
			return "registerForm";
		}
	String path=	request.getSession().getServletContext().getRealPath("/");
	String path2=request.getServletContext().getRealPath("/");
	String path3=request.getRealPath("/");
		try {
			profilePicture.transferTo(new File("/"+profilePicture.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(spitterRepository.findAll().stream().anyMatch(e->e.getUsername().equals(spitter.getUsername()))) {
			throw new SpitterHasExisted();
		}
		
		
		//使用url模板的方式向重定向url中传递数据，数据引用model中的值
//		model.addAttribute("username", spitter.getUsername());
//		model.addAttribute("password",spitter.getPassword());
		
		//return "redirect:/spitter/{username}";
		
		model.addAttribute("username", spitter.getUsername());
		model.addFlashAttribute("spitter",spitter);
		return "redirect:/spitter/{username}";
		//使用flash属性传递值
	}
	@RequestMapping(value="/{id}")
	//获取从flash属性中获取的值
	@PreAuthorize("#id<100")
	public String getUser(@PathVariable long id,Model model) {
	 
//List<Spitter> spitters=spitterRepository.findAll();
		model.addAttribute("spitter",spitterRepository.findOne(id) );
	
		return "spitter";
		
	}
	
	@ExceptionHandler(SpitterHasExisted.class)
	public String handleDuplicateSpitter() {
		
		return "error/duplicate";
	}
	
}
