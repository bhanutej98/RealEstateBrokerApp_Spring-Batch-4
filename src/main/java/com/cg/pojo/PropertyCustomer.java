package com.cg.pojo;

import com.cg.entity.Customer;
import com.cg.entity.Property;

public class PropertyCustomer {
	/**
	 * @author VSSVSN Raju
	 *
	 * 
	 */
	private Property property;
	private Customer customer;

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
