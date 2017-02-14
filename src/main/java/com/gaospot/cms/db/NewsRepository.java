package com.gaospot.cms.db;

import java.util.List;

import com.gaospot.cms.domain.News;

public interface NewsRepository {
	
	long count();
	
	News save(News news);
	
	News findOne(long id);
	
	List<News> findAll();
}
