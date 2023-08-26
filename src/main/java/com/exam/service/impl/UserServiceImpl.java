package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;
	@Autowired
	private RoleRepository rolerepo;
	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception {
		// TODO Auto-generated method stub
		User local = this.userrepo.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("User already there");
			throw new Exception("User already present");
		}
		else
		{
		userRole.forEach(role->rolerepo.save(role.getRole()));
		user.getUserRoles().addAll(userRole);
		local=userrepo.save(user);
		}
		return local;
	}
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userrepo.findByUsername(username);
	}
	@Override
	public String deleteUser(String username) {
		// TODO Auto-generated method stub
		User local=userrepo.findByUsername(username);
		userrepo.deleteById(local.getId());
		return "Deleted Successfully";
		
		
	}
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userrepo.save(user);
	} 

}
