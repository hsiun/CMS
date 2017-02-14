package com.gaospot.cms.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Publish {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	@JoinColumn(name="News")
	private News news;
	
	@Column(name="url")
	private String url;
	
	@Column(name="publishTime")
	private Date publishTime;
	
	public Publish(long id, News news, String url, Date publishTime) {
		super();
		this.id = id;
		this.news = news;
		this.url = url;
		this.publishTime = publishTime;
	}
	
	public long getId() {
		return id;
	}
	public News getNews() {
		return news;
	}
	public String getUrl() {
		return url;
	}
	public Date getPublishTime() {
		return publishTime;
	}

}
