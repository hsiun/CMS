package com.gaospot.cms.db.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gaospot.cms.db.NewsRepository;
import com.gaospot.cms.domain.News;


@Repository
@Transactional
public class HibernateNewsRepository implements NewsRepository {
	
	private SessionFactory sessionFactory;
	
	@Inject
	public HibernateNewsRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//从sessionFactory中获取当前session
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public long count() {
		return findAll().size();
	}

	public News save(News news) {
		Serializable id = currentSession().save(news);
		return new News((Long) id,
				news.getUser(),
				news.getTitle(),
				news.getContent());
	}

	public News findOne(long id) {
		return (News) currentSession().get(News.class, id);
	}

	public List<News> findAll() {
		
		return (List<News>)currentSession()
				.createCriteria(News.class)
				.list();
	}

}
