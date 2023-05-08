package com.example.demo.security;

import java.io.IOException;
import java.sql.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.SpringApplicationContext;
import com.example.demo.request.UserLoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.demo.services.ProprietaireService;
import com.example.demo.shared.dto.ProprietaireDto;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;


	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			
			UserLoginRequest creds = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequest.class);
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	  @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
	        
	        String userName = ((User) auth.getPrincipal()).getUsername(); 
		       ProprietaireService proprietaireService =(ProprietaireService)SpringApplicationContext.getBean("proprietaireServiceImpl");
		       
		       ProprietaireDto proprietaireDto=proprietaireService.getUser(userName);
		       
	        String token = Jwts.builder()
	                .setSubject(userName)
	                .claim("id", proprietaireDto.getProprietaireid())
	                .claim("name", proprietaireDto.getFirstName()+" "+proprietaireDto.getLastName())
	                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET )
	                .compact();
	        

	       
	      //Récupérer les information dans l'Body  
	        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
	        res.addHeader("user_id", proprietaireDto.getProprietaireid());
	        
	        res.getWriter().write("{\"token\":\""+token+"\",\"id\":\""+proprietaireDto.getProprietaireid()+"\"}");
	    }  
}
