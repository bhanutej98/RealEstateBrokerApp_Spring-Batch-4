package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Broker;
import com.cg.entity.User;
import com.cg.repository.UserRepositoryImpl;

/**
 * @author Anila Meenavalli
 *
 * 
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepositoryImpl userRepo;

	@Override
	public User login(int userid) {
		User user = new Broker();
		user.setUserid(userid);
		if (userRepo.existsById(userid)) {
			return user;
		}
		return null;
	}

	@Override
	public User logout(int userid) {
		User user = new Broker();
		user.setUserid(userid);
		if (userRepo.existsById(userid)) {
			System.exit(0);
			return user;
		}
		return null;
	}

}
