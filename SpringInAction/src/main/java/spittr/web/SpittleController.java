package spittr.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpittleRepository;
import spittr.model.Spittle;

@Controller

public class SpittleController {
	private SpittleRepository spittleRepository;
                              @Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		super();
		this.spittleRepository = spittleRepository;
	}
	@RequestMapping(value="/spittles",method=RequestMethod.GET)
	public String spittles(Model model) {
		//model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE,20));
		return "spittles";
	}
	 @RequestMapping("/spittle/{id}")
	public String spittle(@PathVariable(value="id")int id,Model model) {
		 Spittle spittle=new Spittle();
		 spittle.setId((long) id);
		 
		 model.addAttribute(spittle);
		 return "spittle";
		
	 }
	 
	
}
