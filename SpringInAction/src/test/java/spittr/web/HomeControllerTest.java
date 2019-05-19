package spittr.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.xml.WhenTag;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilderSupport;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spittr.data.SpittleRepository;
import spittr.model.Spittle;
class HomeControllerTest {

	@Test
	void testHomePage() throws Exception {
		HomeController homeController=new HomeController();
		MockMvc mockMvc=
			MockMvcBuilders.standaloneSetup(homeController).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	
	}
	@Test
 public void shouldShowRecentSpittles(){
		List<Spittle> expectedSpittles=createSpittleList(20);
		SpittleRepository mockRepository;
				

	}
	
	private List<Spittle> createSpittleList(int count){
		List<Spittle> spittles=new ArrayList<>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle());
		}
		return spittles;
	}

}
