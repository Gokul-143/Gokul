package com.dispatcher;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.configuration.emp_config;

public class emp_dispatcher extends AbstractAnnotationConfigDispatcherServletInitializer 
	{
		

		@Override
		protected Class<?>[] getRootConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[0];
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[] { emp_config .class };
		}

		@Override
		protected String[] getServletMappings() {
			// TODO Auto-generated method stub
			return new String[] { "/" };
		}

	

	
}
