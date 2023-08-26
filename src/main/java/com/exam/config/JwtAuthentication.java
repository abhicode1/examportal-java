package com.exam.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.service.impl.UserDetailserviceImpl;

@Component
public class JwtAuthentication extends OncePerRequestFilter {

	@Autowired
	private UserDetailserviceImpl userDetailservice; 
	@Autowired
	private JwtUtils jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println("requestTokenHeader"+requestTokenHeader);
//		requestTokenHeader
		String username = null;
		String token = null;
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer"))
		{
			token=requestTokenHeader.substring(7);
			try {
				username=jwtUtil.extractUsername(token);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("token expired");
			}
		}
		else
		{
			System.out.println("Invalid-token bearer");
		}
		//validated
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userdetails=this.userDetailservice.loadUserByUsername(username);
			if(jwtUtil.validateToken(token, userdetails)) {
				UsernamePasswordAuthenticationToken filter = new UsernamePasswordAuthenticationToken(userdetails,userdetails.getPassword(),userdetails.getAuthorities());
				filter.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(filter);
			}
		}
		else
		{
			System.out.println("Invalid-token");
		}
		
		filterChain.doFilter(request, response);
	}

}
