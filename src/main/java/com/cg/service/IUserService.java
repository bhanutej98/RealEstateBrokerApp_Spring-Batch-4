package com.cg.service;

import com.cg.entity.User;

/**
 * @author Anila Meenavalli
 *
 * 
 */
public interface IUserService {

	User login(int userid);

	User logout(int userid);
}
