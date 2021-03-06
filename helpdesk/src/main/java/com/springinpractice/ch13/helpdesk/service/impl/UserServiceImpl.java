package com.springinpractice.ch13.helpdesk.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springinpractice.ch13.helpdesk.model.User;
import com.springinpractice.ch13.helpdesk.repo.UserRepository;
import com.springinpractice.ch13.helpdesk.service.UserService;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Inject private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("Loading user by username: {}", username);
		User user = userRepo.findByUsername(username);
		if (user == null) { throw new UsernameNotFoundException(username); }
		return user;
	}
}
