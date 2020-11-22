package com.cg.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.controller.DealController;
import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.service.DealServiceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = DealController.class)
class DealControllerTest {
	/**
	 * @author VSSVSN Raju
	 *
	 * 
	 */
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DealServiceimpl dealserviceimpl;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetExample() throws Exception {
		List<Deal> deals = new ArrayList<>();
		Deal deal = new Deal();
		deal.setDealId(1);
		deal.setDealDate(LocalDate.now());
		deal.setDealCost(5000000);
		deals.add(deal);
		Mockito.when(dealserviceimpl.listAllDeals()).thenReturn(deals);
		mockMvc.perform(get("http://localhost:8080/realestate/deal/deals")).andExpect(status().isOk());
	}

	@Test
	public void testPostExample() throws Exception {
		Deal deal = new Deal();
		Customer customer = new Customer();
		Property property = new Property();
		property.setPropId(1);
		property.setConfiguration("Flat");
		property.setOfferType("Rent");
		property.setOfferCost(15000);
		customer.setCustId(1);
		customer.setCustName("Raju");
		deal.setCustomer(customer);
		deal.setProperty(property);
		Mockito.when(dealserviceimpl.addDeal(property, customer)).thenReturn(deal);
		String json = mapper.writeValueAsString(deal);
		mockMvc.perform(post("http://localhost:8080/realestate/deal/add").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

}
