package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import com.example.demo.services.ProprietaireService;
import org.springframework.context.annotation.Bean;


@Configuration
public class WebSecurity extends AbstractHttpConfigurer<WebSecurity, HttpSecurity> {

	private final ProprietaireService proprietaireService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	 public WebSecurity(ProprietaireService proprietaireService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.proprietaireService = proprietaireService;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
	 
	 	

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http,AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	    	http
		    .cors().and()
		    .csrf().disable()
		    .authorizeRequests()
		    .requestMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
		    .permitAll() 
			.anyRequest().authenticated() 
			.and().addFilter(getAuthenticationFilter(authenticationManagerBuilder))
			.addFilter(new AuthorizationFilter(authenticationManagerBuilder.getObject()));
	        return http.build();
	    }
	    protected AuthenticationFilter getAuthenticationFilter(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		    final AuthenticationFilter filter = new AuthenticationFilter(authenticationManagerBuilder.getObject());
		    filter.setFilterProcessesUrl("/proprietaire/login");
		    return filter;
		}

	    @Bean
	    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) 
	      throws Exception {
	        return http.getSharedObject(AuthenticationManagerBuilder.class)
	          .userDetailsService(proprietaireService)
	          .passwordEncoder(bCryptPasswordEncoder)
	          .and()
	          .build();
	    }


}
