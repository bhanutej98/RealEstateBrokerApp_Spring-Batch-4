package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Deal;
import com.cg.entity.Property;
import com.cg.repository.DealRepoImpl;

@Service
public class DealServiceimpl implements IDealService {
	/**
	 * @author VSSVSN Raju
	 *
	 * 
	 */
	@Autowired
	private DealRepoImpl dealRepo;

	@Override
	public Deal addDeal(Property property, Customer customer) {
		Deal deal = new Deal();
		deal.setProperty(property);
		deal.setCustomer(customer);
		LocalDate date = LocalDate.now();
		deal.setDealDate(date);
		return dealRepo.save(deal);
	}

	@Override
	public List<Deal> listAllDeals() {
		return dealRepo.findAll();
	}

}
