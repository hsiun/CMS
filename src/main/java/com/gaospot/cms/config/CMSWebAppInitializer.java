package com.gaospot.cms.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * CMS Web应用配置文件
 * @author Gao
 *
 */
public class CMSWebAppInitializer extends 
		AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class};
	}


	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class};
	}


	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
