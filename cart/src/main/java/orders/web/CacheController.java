package orders.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import orders.db.CacheTest;

@Controller
@RequestMapping("/cache")
public class CacheController {
 
	@Autowired
	CacheTest test;
	@RequestMapping("/{id}")
	@ResponseBody
	
	 public String getById(@PathVariable long id) {
		 
		 return  test.getId( new Long(id).toString()) ;
	 }
}
