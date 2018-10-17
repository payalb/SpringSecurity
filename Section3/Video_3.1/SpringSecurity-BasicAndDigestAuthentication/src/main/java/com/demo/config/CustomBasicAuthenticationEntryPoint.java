package com.demo.config;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author ankidaemon
 *
 */
@Component
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
 
	//If we want custom response messages to be sent to user-agent, we need to override commence method.
    @Override
    public void commence
      (HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) 
      throws IOException, ServletException {
    	response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("Basic Authentication : You are not authorized. " + exception.getMessage());
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
    	//Needed as a scope within application. Else app will fail
        setRealmName("Spring");
        super.afterPropertiesSet();
    }
}
