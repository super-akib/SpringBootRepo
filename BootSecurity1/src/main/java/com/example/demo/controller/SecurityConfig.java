package com.example.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsService getoobj() {
        UserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails build = User.withUsername("sam").password("1234").authorities("read").build();
        manager.createUser(build);
        return manager;
	}
@Bean
public PasswordEncoder get() {
	return NoOpPasswordEncoder.getInstance();
}

}
