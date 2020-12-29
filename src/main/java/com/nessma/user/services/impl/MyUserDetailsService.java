package com.nessma.user.services.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nessma.user.Enum.ExceptionEnum;
import com.nessma.user.exceptions.NessmaException;
import com.nessma.user.models.User;
import com.nessma.user.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) {

		Optional<User> user = userRepository.findByUsername(userName);
		user.orElseThrow(() -> new NessmaException(ExceptionEnum.USER_NOT_FOUNT));
		return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(),
				new ArrayList<>());
	}

}
