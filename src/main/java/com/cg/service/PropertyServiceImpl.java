package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.repository.PropertyRepoImpl;

@Service
public class PropertyServiceImpl implements IPropertyService {
	/**
	 * @author Chiranjeevi Bhanu Teja Tatavarthi
	 *
	 * 
	 */
	@Autowired
	private PropertyRepoImpl propertyRepo;

	@Override
	public Property addProperty(Property property) {
		// TODO Auto-generated method stub
		return propertyRepo.save(property);
	}

	@Override
	public Property editProperty(Property property) {
		// TODO Auto-generated method stub
		return propertyRepo.save(property);
	}

	@Override
	public Property removeProperty(int propId) throws PropertyNotFoundException {
		// TODO Auto-generated method stub
		Optional<Property> property = propertyRepo.findById(propId);
		Property prop = null;
		if (property.isPresent()) {
			prop = property.get();
		}
		propertyRepo.delete(prop);
		return prop;
	}

	@Override
	public Property viewProperty(int propId) throws PropertyNotFoundException {
		Optional<Property> property = propertyRepo.findById(propId);
		Property prop = null;
		if (property.isPresent()) {
			prop = property.get();
		}
		return prop;
	}

	@Override
	public List<Property> listAllProperties() {
		return propertyRepo.findAll();
	}

	@Override
	public List<Property> listPropertyByCriteria(PropertyCriteria criteria) {

		return propertyRepo.listPropertyByCriteria(criteria.getConfig(), criteria.getOffer(), criteria.getCity(),
				criteria.getMinCost(), criteria.getMaxCost());
	}

}
