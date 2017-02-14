package com.gaospot.cms.web;

import javax.validation.constraints.NotNull;

import com.gaospot.cms.domain.News;
import com.gaospot.cms.domain.Users;

public class AddForm {
	
	@NotNull
	private String title;
	@NotNull
	private String content;
	
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public News toNews(Users user) {
		return new News(user, title, content);
	}

}
