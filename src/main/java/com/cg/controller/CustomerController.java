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

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.service.ICustomerService;

@RestController
@RequestMapping("/realestate")
public class CustomerController {
	/**
	 * @author Gowri Sneha Priya
	 *
	 * 
	 */

	@Autowired
	private ICustomerService customerService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/customer/add")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer cust = customerService.addCustomer(customer);
		if (cust == null) {
			return new ResponseEntity("Sorry! couldn't add!!", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/customer/edit")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer cust = customerService.editCustomer(customer);
		if (cust == null) {
			return new ResponseEntity("Sorry! couldn't update!!", HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/customer/delete/{custId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("custId") Integer custId) {

		Customer cust = null;
		try {
			cust = customerService.removeCustomer(custId);
			if (cust == null) {
				throw new CustomerNotFoundException("Customer Id is null!!");
			}
		} catch (CustomerNotFoundException e) {
			return new ResponseEntity("Sorry! couldn't delete!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/customer/{custId}")
	public ResponseEntity<Customer> findProduct(@PathVariable("custId") Integer custId) {
		Customer cust = null;
		try {
			cust = customerService.viewCustomer(custId);
			if (cust == null) {
				throw new CustomerNotFoundException("Customer not found!!");
			}
		} catch (CustomerNotFoundException e) {
			return new ResponseEntity("Sorry! Customer not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/customer/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.listAllCustomers();
		if (customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customers not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

}
