package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.repository.CustomerRepoImpl;

@Service
public class CustomerServiceImpl implements ICustomerService {
	/**
	 * @author Gowri Sneha Priya
	 *
	 * 
	 */
	@Autowired
	private CustomerRepoImpl customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer editCustomer(Customer customer) {

		return customerRepo.save(customer);
	}

	@Override
	public Customer removeCustomer(int custId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> cust = customerRepo.findById(custId);
		Customer customer = null;
		if (cust.isPresent()) {
			customer = cust.get();
		}
		customerRepo.delete(customer);
		return customer;
	}

	@Override
	public Customer viewCustomer(int custId) throws CustomerNotFoundException {
		Optional<Customer> cust = customerRepo.findById(custId);
		Customer customer = null;
		if (cust.isPresent()) {
			customer = cust.get();
		}

		return customer;
	}

	@Override
	public List<Customer> listAllCustomers() {
		return customerRepo.findAll();

	}

}
