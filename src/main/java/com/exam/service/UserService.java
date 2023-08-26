package com.exam.service;

import java.util.Set;

import com.exam.entities.User;
import com.exam.entities.UserRole;

public interface UserService {
	public User createUser(User user, Set<UserRole> userRole) throws Exception;
	public User getUser(String username);
	public String deleteUser(String username);
	public User updateUser(User user);

}
