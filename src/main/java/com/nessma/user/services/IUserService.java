package com.nessma.user.services;

import java.util.List;

import com.nessma.user.models.User;

public interface IUserService   {
	
	User save(User user);
	List<User> getAllUsers();
	User findOne(String email);

}
