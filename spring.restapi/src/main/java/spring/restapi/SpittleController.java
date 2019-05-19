package spring.restapi;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import spring.exception.SpittleNotFoundException;
import spring.model.Spittle;

@RestController
public class SpittleController {

	@RequestMapping("/spittle/{id}")
	@JsonIgnoreProperties("latitude")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

	public ResponseEntity<Spittle> gEntity(@PathVariable("id") int id){
		
		if(id==0) {
		//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new SpittleNotFoundException("没有该对象", 0);
		}else {
			
			Spittle spittle=new Spittle();
			spittle.setMessage("from server");
			spittle.setLongitude(123.1);
			spittle.setLatitude(12.5);
			spittle.setTime( LocalDate.of(1994, 9, 13));
		 ResponseEntity<Spittle> body=new ResponseEntity<Spittle>(spittle,HttpStatus.OK);
             return body;   
		}
	}
	@RequestMapping(value="/spittle/post/{id}",method=RequestMethod.POST)
	public Spittle postSpittle(@RequestBody Spittle spittle) {
		return spittle;
	}
	@RequestMapping(value="/spittle/location/{id}",method=RequestMethod.POST)
	public ResponseEntity<Spittle> locationSpittle(@RequestBody Spittle spittle) {
		 HttpHeaders headers=new HttpHeaders();
		 headers.setLocation(URI.create("http://localhost:8080/spittls/3"));
	 ResponseEntity<Spittle> entity=new ResponseEntity<Spittle>(spittle,headers,HttpStatus.OK);
	
	 return entity;
	}
	@ExceptionHandler(SpittleNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleException(SpittleNotFoundException e){
		Map map=new HashMap<>();
		map.put("message", e.getMessage());
		map.put("id",  Long.valueOf(e.getId()).toString());
		HttpHeaders headers=new HttpHeaders();
		/*URI uri=URI.create("http://localhost:8080/abc");*/
		UriComponentsBuilder ucb=UriComponentsBuilder.newInstance();
	URI uri=	ucb.port(8080).path("/spittles").path("0").build().toUri();
		headers.setLocation(uri);
		return new ResponseEntity<>(map,headers,HttpStatus.NOT_FOUND);
	}
	
}
