package spring.restapi;

import java.net.URI;
import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import spring.model.Spittle;

@RestController
public class SpittleRestClient {
	RestTemplate template=new RestTemplate();
	@RequestMapping("/client/spittle")
	public  Spittle getSpittle() {
		
	Spittle spittle=	template.getForObject("http://localhost:8080/spittle/2", Spittle.class);
	return spittle;
	}
	@RequestMapping("/client/spittlePost")
	public Spittle putSpittle() {
		Spittle spittle=new Spittle();
		spittle.setId(123l);
		spittle.setLongitude(123.1);
		spittle.setMessage("put from server");
		spittle.setTime(LocalDate.of(1994, 9, 13));

	Spittle spittle2=	template.postForObject("http://localhost:8080/spittle/post/{id}",spittle,Spittle.class,3);
ResponseEntity<Spittle> responseEntity=	template.postForEntity("http://localhost:8080/spittle/post/{id}",spittle,Spittle.class,3);
	return  responseEntity.getBody() ;
	}
	@RequestMapping("/client/spittleLocation")
	public URI locationSpittle() {
		Spittle spittle=new Spittle();
		spittle.setId(123l);
		spittle.setLongitude(123.1);
		spittle.setMessage("put from server");
		spittle.setTime(LocalDate.of(1994, 9, 13));

 return	template.postForLocation("http://localhost:8080/spittle/location/{id}",spittle,Spittle.class,3);

	}

}
