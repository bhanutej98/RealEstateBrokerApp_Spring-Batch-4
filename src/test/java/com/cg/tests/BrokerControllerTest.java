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

import com.cg.controller.BrokerController;
import com.cg.entity.Broker;
import com.cg.service.BrokerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = BrokerController.class)
class BrokerControllerTest {
	/**
	 * @author Rithvik Krishna Sigala
	 *
	 * 
	 */

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BrokerServiceImpl brokerService;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetExample() throws Exception {
		List<Broker> brokers = new ArrayList<>();
		Broker broker = new Broker();
		broker.setUserid(7);
		broker.setBroId(3);
		broker.setBroName("Bhanu");
		brokers.add(broker);
		Mockito.when(brokerService.listAllBrokers()).thenReturn(brokers);
		mockMvc.perform(get("http://localhost:8080/realestate/broker/brokers")).andExpect(status().isOk());
	}

	@Test
	public void testPostExample() throws Exception {
		Broker broker = new Broker();
		broker.setBroId(3);
		broker.setBroName("raju");
		Mockito.when(brokerService.addBroker(ArgumentMatchers.any())).thenReturn(broker);
		String json = mapper.writeValueAsString(broker);
		mockMvc.perform(post("http://localhost:8080/realestate/broker/add").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testPutExample() throws Exception {
		Broker broker = new Broker();
		broker.setBroId(5);
		broker.setBroName("ritvik");
		Mockito.when(brokerService.editBroker(ArgumentMatchers.any())).thenReturn(broker);
		String json = mapper.writeValueAsString(broker);
		mockMvc.perform(put("http://localhost:8080/realestate/broker/edit").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testDeleteExample() throws Exception {
		Broker broker = new Broker();
		broker.setBroId(5);
		Mockito.when(brokerService.removeBroker(broker.getBroId())).thenReturn(broker);
		mockMvc.perform(delete("http://localhost:8080/realestate/broker/delete/5").param("custId", "5"))
				.andExpect(status().isOk());
	}
}
