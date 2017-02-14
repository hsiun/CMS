package com.gaospot.cms.web;

import static
	org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static
	org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static
	org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.gaospot.cms.web.HomeController;


public class HomeControllerTest {
	
	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		//使用HomeController实例来构建MockMvc
		MockMvc mockMvc = MockMvcBuilders
				.standaloneSetup(controller).build();
		//通过MockMvc来发起get请求，并期待返回home视图
		mockMvc.perform(get("/cms"))
			.andExpect(view().name("home"));
		
		
	}

}
