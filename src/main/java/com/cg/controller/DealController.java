package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Deal;
import com.cg.pojo.PropertyCustomer;
import com.cg.service.IDealService;

@RestController
@RequestMapping("/realestate")
public class DealController {
	/**
	 * @author VSSVSN Raju
	 *
	 * 
	 */
	@Autowired
	private IDealService dealService;

	@PostMapping("/deal/add")
	public ResponseEntity<Deal> saveDeal(@RequestBody PropertyCustomer propertycustomer) {
		Deal deal = dealService.addDeal(propertycustomer.getProperty(), propertycustomer.getCustomer());
		return new ResponseEntity<Deal>(deal, HttpStatus.OK);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/deal/deals")
	public ResponseEntity<List<Deal>> getAllDeals() {
		List<Deal> deal = dealService.listAllDeals();
		if (deal.isEmpty()) {
			return new ResponseEntity("Sorry! Deals not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Deal>>(deal, HttpStatus.OK);

	}

}
