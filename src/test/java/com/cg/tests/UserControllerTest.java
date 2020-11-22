package com.cg.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.controller.UserController;
import com.cg.entity.Broker;
import com.cg.entity.User;
import com.cg.service.UserServiceImpl;

@WebMvcTest(value = UserController.class)
class UserControllerTest {
	/**
	 * @author Anila Meenavalli
	 *
	 * 
	 */
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserServiceImpl userService;

	@Test
	public void testGetLoginExample() throws Exception {
		User user = new Broker();
		user.setUserid(2);
		Mockito.when(userService.login(user.getUserid())).thenReturn(user);
		mockMvc.perform(get("http://localhost:8080/realestate/user/login/2").param("userid", "2"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetLogoutExample() throws Exception {
		User user = new Broker();
		user.setUserid(2);
		Mockito.when(userService.logout(user.getUserid())).thenReturn(user);
		mockMvc.perform(get("http://localhost:8080/realestate/user/logout/2").param("userid", "2"))
				.andExpect(status().isOk());
	}

}
