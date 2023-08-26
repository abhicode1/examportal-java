package com.exam.entities;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String authority;
	
	public Authority(String auth)
	{
		this.authority=auth;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

}
