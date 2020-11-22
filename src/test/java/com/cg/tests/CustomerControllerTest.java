package com.cg.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.controller.CustomerController;
import com.cg.entity.Customer;
import com.cg.service.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = CustomerController.class)
class CustomerControllerTest {
	/**
	 * @author Gowri Sneha Priya
	 *
	 * 
	 */
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerServiceImpl customerService;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetExample() throws Exception {
		List<Customer> customers = new ArrayList<>();
		Customer customer = new Customer();
		customer.setUserid(7);
		customer.setCustId(3);
		customer.setCustName("Sneha");
		customers.add(customer);
		Mockito.when(customerService.listAllCustomers()).thenReturn(customers);
		mockMvc.perform(get("http://localhost:8080/realestate/customer/customers")).andExpect(status().isOk());
	}

	@Test
	public void testPostExample() throws Exception {
		Customer customer = new Customer();
		customer.setCustId(3);
		customer.setCustName("Anila");
		Mockito.when(customerService.addCustomer(ArgumentMatchers.any())).thenReturn(customer);
		String json = mapper.writeValueAsString(customer);
		mockMvc.perform(post("http://localhost:8080/realestate/customer/add").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testPutExample() throws Exception {
		Customer customer = new Customer();
		customer.setCustId(5);
		customer.setCustName("John");
		Mockito.when(customerService.editCustomer(ArgumentMatchers.any())).thenReturn(customer);
		String json = mapper.writeValueAsString(customer);
		mockMvc.perform(put("http://localhost:8080/realestate/customer/edit").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testDeleteExample() throws Exception {
		Customer customer = new Customer();
		customer.setCustId(5);
		Mockito.when(customerService.removeCustomer(customer.getCustId())).thenReturn(customer);
		mockMvc.perform(delete("http://localhost:8080/realestate/customer/delete/5").param("custId", "5"))
				.andExpect(status().isOk());
	}
}
