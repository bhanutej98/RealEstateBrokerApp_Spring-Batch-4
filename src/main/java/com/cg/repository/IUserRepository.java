package com.cg.repository;

import com.cg.entity.User;

/**
 * @author Anila Meenavalli
 *
 * 
 */
public interface IUserRepository {

	User login(User user);

	User logout(User user);
}
