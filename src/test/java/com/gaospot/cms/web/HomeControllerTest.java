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
		//ʹ��HomeControllerʵ��������MockMvc
		MockMvc mockMvc = MockMvcBuilders
				.standaloneSetup(controller).build();
		//ͨ��MockMvc������get���󣬲��ڴ�����home��ͼ
		mockMvc.perform(get("/cms"))
			.andExpect(view().name("home"));
		
		
	}

}
