package com.gaospot.cms.db.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gaospot.cms.db.UserRepository;
import com.gaospot.cms.domain.Users;


@Repository
@Transactional
public class HibernateUserRepository implements UserRepository{
	
	private SessionFactory sessionFactory;

	@Inject
	public HibernateUserRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		 
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public long count() {
		return findAll().size();
	}

	//保存用户
	public Users save(Users users) {
		Serializable id = currentSession().save(users);
		return new Users((Long) id,
				users.getUsername(),
				users.getPassword(),
				users.getPhone(),
				users.getEmail());
	}

	public Users findOne(long id) {
		return (Users)currentSession().get(Users.class,id);
	}

	//通过用户名查询
	public Users findByUsername(String username) {
		return (Users)currentSession()
				.createCriteria(Users.class)
				.add(Restrictions.eq("username", username))
				.list().get(0);
	}

	public List<Users> findAll() {
		return (List<Users>) currentSession()
				.createCriteria(Users.class).list(); 
	}

}
