package com.gaospot.cms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="News")
public class News {
	private News(){};
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="Users")
	private Users users;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	public News(long id, Users users, String title, String content) {
		this.id = id;
		this.users = users;
		this.title = title;
		this.content = content;
	}
	
	public News(Users users, String title, String content) {
		this.users = users;
		this.title = title;
		this.content = content;
	}
	
	public long getId() {
		return id;
	}


	public Users getUser() {
		return users;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

}
