package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.demo", scopedProxy =
org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS)
public class WebConfig implements WebMvcConfigurer {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		/*
		 * Set whether to make all Spring beans in the application context accessible as
		 * request attributes, through lazy checking once an attribute gets accessed.
		 * This will make all such beans accessible in plain ${...}} expressions in a
		 * JSP 2.0 page, as well as in JSTL's c:out value expressions. Default is
		 * "false".
		 */

		resolver.setExposeContextBeansAsAttributes(true);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	/*
	 * Listeners, in general, are a way for the container to notify your app of
	 * events, instead of just web requests. For example, to be notified when a
	 * session is going to time out, you'd extend HttpSessionListener and implement
	 * the sessionDestroyed() method. The container would then call that on
	 * expiration of the session and you could log it alongside the login time for
	 * that user. For ContextLoaderListener, this lets you kick off non-web related
	 * parts of your app, that you want on container startup, instead of waiting on
	 * someone to hit one of your spring components. It is using the context-param
	 * contextConfigLocation set earlier in your web.xml to know what to start. For
	 * RequestContextListener, you get notified of request creation and deletion .
	 */
	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
