package com.gaospot.cms.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gaospot.cms.db.NewsRepository;
import com.gaospot.cms.db.UserRepository;
import com.gaospot.cms.domain.News;
import com.gaospot.cms.domain.Users;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	private NewsRepository newsRepository;
	private UserRepository userRepository;
	
	//信息的控制器
	@Autowired
	public NewsController(NewsRepository newsRepository,
			UserRepository userRepository) {
		this.newsRepository = newsRepository;
		this.userRepository = userRepository;
	}
	
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String listNews(Model model) {
		model.addAttribute("news", newsRepository.findAll());
		return "contents";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addNews() {
		return "addnewsForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddNews(
			@Valid AddForm newsForm,
			Errors error) {
	    if (error.hasErrors()) {
	        return "addnewsForm";
	     }
	    Users user1 = new Users("aa", "123", "123", "aa@123.com");
	    Users user = userRepository.save(user1);
	    News news = new News(user, 
	    		newsForm.getTitle(), 
	    		newsForm.getContent()
	    		);
	    newsRepository.save(news);
	    
		return "redirect:/news/all";
	}

}
