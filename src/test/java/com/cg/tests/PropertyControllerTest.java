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
import com.cg.controller.PropertyController;
import com.cg.entity.Broker;
import com.cg.entity.Customer;
import com.cg.entity.Property;
import com.cg.service.PropertyServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = PropertyController.class)
public class PropertyControllerTest {
	/**
	 * @author Chiranjeevi Bhanu Teja Tatavarthi
	 *
	 * 
	 */
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PropertyServiceImpl propertyService;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetExample() throws Exception {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Property> properties = new ArrayList();
		Property property = new Property();
		Broker broker = null;
		Customer customer = null;
		property.setPropId(1);
		property.setConfiguration("Flat");
		property.setOfferType("Rent");
		property.setOfferCost(15000);
		property.setAreaSqft(25);
		property.setCity("Pune");
		property.setAddress("Hinjewadi");
		property.setStreet("Hinjewadi");
		property.setStatus(true);
		property.setBroker(broker);
		property.setCustomer(customer);
		properties.add(property);
		Mockito.when(propertyService.listAllProperties()).thenReturn(properties);
		mockMvc.perform(get("http://localhost:8080/realestate/property/properties")).andExpect(status().isOk());
	}

	@Test
	public void testPostExample() throws Exception {
		Property property = new Property();
		Broker broker = null;
		Customer customer = null;
		property.setPropId(1);
		property.setConfiguration("Flat");
		property.setOfferType("Rent");
		property.setOfferCost(15000);
		property.setAreaSqft(25);
		property.setCity("Pune");
		property.setAddress("Hinjewadi");
		property.setStreet("Hinjewadi");
		property.setStatus(true);
		property.setBroker(broker);
		property.setCustomer(customer);
		Mockito.when(propertyService.addProperty(ArgumentMatchers.any())).thenReturn(property);
		String json = mapper.writeValueAsString(property);
		mockMvc.perform(post("http://localhost:8080/realestate/property/add").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testPutExample() throws Exception {
		Property property = new Property();
		Broker broker = null;
		Customer customer = null;
		property.setPropId(12);
		property.setConfiguration("Flat");
		property.setOfferType("Rent");
		property.setOfferCost(15000);
		property.setAreaSqft(35);
		property.setCity("Pune");
		property.setAddress("Hinjewadi");
		property.setStreet("Hinjewadi");
		property.setStatus(true);
		property.setBroker(broker);
		property.setCustomer(customer);
		Mockito.when(propertyService.editProperty(ArgumentMatchers.any())).thenReturn(property);
		String json = mapper.writeValueAsString(property);
		mockMvc.perform(put("http://localhost:8080/realestate/property/edit").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testDeleteExample() throws Exception {
		Property property = new Property();
		property.setPropId(12);
		Mockito.when(propertyService.removeProperty(property.getPropId())).thenReturn(property);
		mockMvc.perform(delete("http://localhost:8080/realestate/property/delete/12").param("propId", "12"))
				.andExpect(status().isOk());
	}

}
