package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Broker;
import com.cg.exception.BrokerNotFoundException;
import com.cg.repository.BrokerRepoImpl;

@Service
public class BrokerServiceImpl implements IBrokerService {
	/**
	 * @author Rithvik Krishna Sigala
	 *
	 * 
	 */
	@Autowired
	private BrokerRepoImpl brokerRepo;

	@Override
	public Broker addBroker(Broker bro) {
		return brokerRepo.save(bro);
	}

	@Override
	public Broker editBroker(Broker bro) throws BrokerNotFoundException {

		return brokerRepo.save(bro);
	}

	@Override
	public Broker removeBroker(int broId) throws BrokerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Broker> broker = brokerRepo.findById(broId);
		Broker bro = null;
		if (broker.isPresent()) {
			bro = broker.get();
		}
		brokerRepo.delete(bro);
		return bro;
	}

	@Override
	public Broker viewBroker(int broId) throws BrokerNotFoundException {
		Optional<Broker> broker = brokerRepo.findById(broId);
		Broker bro = null;
		if (broker.isPresent()) {
			bro = broker.get();
		}

		return bro;
	}

	@Override
	public List<Broker> listAllBrokers() {
		return brokerRepo.findAll();

	}

}
