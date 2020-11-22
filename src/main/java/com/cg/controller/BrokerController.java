package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.service.IBrokerService;

@RestController
@RequestMapping("/realestate")
public class BrokerController {
	/**
	 * @author Rithvik Krishna Sigala
	 *
	 * 
	 */

	@Autowired
	private IBrokerService brokerService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/broker/add")
	public ResponseEntity<Broker> saveBroker(@RequestBody Broker broker) {
		Broker bro = brokerService.addBroker(broker);
		if (bro == null) {
			return new ResponseEntity("Sorry! couldn't add!!", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Broker>(bro, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/broker/edit")
	public ResponseEntity<Broker> updateBroker(@RequestBody Broker broker) {
		Broker bro = null;
		try {
			bro = brokerService.editBroker(broker);
		} catch (BrokerNotFoundException e) {
			e.printStackTrace();
		}
		if (bro == null) {
			return new ResponseEntity("Sorry! couldn't update!!", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Broker>(bro, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/broker/delete/{broId}")
	public ResponseEntity<Broker> removeBroker(@PathVariable("broId") Integer broId) {

		Broker bro = null;
		try {
			bro = brokerService.removeBroker(broId);
			if (bro == null) {
				throw new BrokerNotFoundException("Broker Id is null!!");
			}
		} catch (BrokerNotFoundException e) {
			return new ResponseEntity("Sorry! couldn't delete!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Broker>(bro, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/broker/{broId}")
	public ResponseEntity<Broker> findProduct(@PathVariable("broId") Integer broId) {
		Broker bro = null;
		try {
			bro = brokerService.viewBroker(broId);
			if (bro == null) {
				throw new BrokerNotFoundException("Broker not found!");
			}
		} catch (BrokerNotFoundException e) {
			return new ResponseEntity("Sorry! Broker not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Broker>(bro, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/broker/brokers")
	public ResponseEntity<List<Broker>> getAllBrokers() {
		List<Broker> brokers = brokerService.listAllBrokers();
		if (brokers.isEmpty()) {
			return new ResponseEntity("Sorry! Brokers not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Broker>>(brokers, HttpStatus.OK);
	}

}
