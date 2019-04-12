package com.springboot.comm.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springboot.auth.AuthProvider;


@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@ComponentScan(basePackages = {"com.itsbox.*"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    AuthProvider authProvider;
    
    @Autowired
    AuthFailureHandler authFailureHandler;
 
    @Autowired
    AuthSuccessHandler authSuccessHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		//WEB리소스라 무시해야 함
		web.ignoring().antMatchers("/css/**", 
								   "/script/**", 
								   "/static/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.httpBasic();

		http.authorizeRequests().antMatchers("/","/ping","/test","/hello", "/login", "/logout", "/register", "/swagger-ui.html").permitAll()
								.antMatchers("/**").access("ROLE_USER")
								.antMatchers("/**").access("ROLE_ADMIN")
								.antMatchers("/admin/**").access("ROLE_ADMIN")
								.antMatchers("/**").authenticated()
								.and()
						    .formLogin()
						        .loginPage("/login")
						        .defaultSuccessUrl("/")
						        .failureHandler(authFailureHandler)
						        .successHandler(authSuccessHandler)
						        .usernameParameter("userId")
						        .passwordParameter("password")
						        .and()    
						    .logout()
					            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
					            .logoutSuccessUrl("/")
					            .invalidateHttpSession(true)
					        .and()
					        	.csrf()
				        	.and()
				        		.authenticationProvider(authProvider);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
