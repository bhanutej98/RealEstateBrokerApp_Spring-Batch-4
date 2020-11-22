package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.service.IUserService;

@RestController
@RequestMapping("/realestate")
public class UserController {
	/**
	 * @author Anila Meenavalli
	 *
	 * 
	 */
	@Autowired
	private IUserService userService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/user/login/{userid}")
	public ResponseEntity<User> login(@PathVariable("userid") Integer userid) {
		User user = userService.login(userid);
		if (user == null) {
			return new ResponseEntity("Login Failed!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/user/logout/{userid}")
	public ResponseEntity<User> logout(@PathVariable("userid") Integer userid) {
		User user = userService.logout(userid);
		if (user == null) {
			return new ResponseEntity("Logout Failed!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
