package com.java;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class AuthenticationHandsOn {
	static MyAuthenticationManagerImpl mgr= new MyAuthenticationManagerImpl();
	public static void main(String[] args) {
		String username="PayalBansal";
		String password="password";
		Authentication object= new UsernamePasswordAuthenticationToken(username, password);
		Authentication result= mgr.authenticate(object); 
		SecurityContextHolder.getContext().setAuthentication(result);
	}

}

class MyAuthenticationManagerImpl implements AuthenticationManager{

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UserDetails userDetails=getUserDetailService().loadUserByUsername(authentication.getName());
		if(userDetails.getPassword().equals(authentication.getCredentials())) {
			Authentication obj= new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(),  userDetails.getAuthorities());
			System.out.println(obj);
			return obj;
		}
		
		throw new RuntimeException("Invalid credentials");
	}
	
	public UserDetailsService getUserDetailService() {
		InMemoryUserDetailsManager mgr= new InMemoryUserDetailsManager();
		mgr.createUser(User.withUsername("PayalBansal").password("password").roles("ADMIN").build());
		return mgr;
	}
	
}