package com.demo.config;

import org.springframework.web.servlet.support.*;
//app started here
public class WebAppConfigIntializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// root config class
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//	the configuration classes for the dispatcher servlet application context or
		//	 * {@code null} if all configuration is specified through root config classes.
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		//dispatcher servlet mapped to /
		return new String[] {"/"};
	}
}
