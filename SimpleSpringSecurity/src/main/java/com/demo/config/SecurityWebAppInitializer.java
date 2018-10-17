package com.demo.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//configure(WebSecurity web) configures filters for us.
	//to register filters: need class that extends AbstractSecurityWebApplicationInitializer
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {
 
    public SecurityWebAppInitializer() {
    	//specify which class creates springsecurityfilterchain for us.
        super(SecurityConfig.class);
    }
 
}
