package boot.contact.web;

import java.util.ArrayList;
import java.util.List;

import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import boot.contact.dao.ContactRepository;
import boot.contact.model.Contact;

@Controller
@RequestMapping("/")
public class ContactController {

	@Autowired
	ContactRepository repository;
	@RequestMapping(method=RequestMethod.GET)
	public String home (Model model) {
	
		
		Contact contact=new Contact();
		contact.setFirstName("first");
		contact.setLastName("lastname");
		contact.setEmailAddress("1289@qq.com");
		repository.save(contact);
		model.addAttribute("contacts",repository.getAll());
		return "home";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String save(Contact contact) {
		
		repository.save(contact);
		return "redirect:/";
	}
}
