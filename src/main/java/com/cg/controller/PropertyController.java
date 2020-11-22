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

import com.cg.entity.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.pojo.PropertyCriteria;
import com.cg.service.IPropertyService;

@RestController
@RequestMapping("/realestate")
public class PropertyController {
	/**
	 * @author Chiranjeevi Bhanu Teja Tatavarthi
	 *
	 * 
	 */
	@Autowired
	private IPropertyService propertyService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/property/add")
	public ResponseEntity<Property> saveProperty(@RequestBody Property property) {
		Property prop = propertyService.addProperty(property);
		if (prop == null) {
			return new ResponseEntity("Sorry! couldn't add!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Property>(prop, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/property/edit")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property) {
		Property prop = propertyService.editProperty(property);
		if (prop == null) {
			return new ResponseEntity("Sorry! couldn't update!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Property>(prop, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/property/delete/{propId}")
	public ResponseEntity<Property> removeProperty(@PathVariable("propId") Integer propId) {
		Property prop = null;
		try {
			prop = propertyService.removeProperty(propId);
			if (prop == null) {
				throw new PropertyNotFoundException("Property Id is null!!");
			}
		} catch (PropertyNotFoundException e) {
			e.getMessage();
			return new ResponseEntity("Sorry! couldn't delete!!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Property>(prop, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/property/fetch/{propId}")
	public ResponseEntity<Property> viewProperty(@PathVariable("propId") Integer propId) {
		Property prop = null;
		try {
			prop = propertyService.viewProperty(propId);
			if (prop == null) {
				throw new PropertyNotFoundException("Property Id is null!!");
			}
		} catch (PropertyNotFoundException e) {
			e.getMessage();
			return new ResponseEntity("Sorry! couldn't fetch!!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Property>(prop, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/property/properties")
	public ResponseEntity<List<Property>> getAllProperties() {
		List<Property> properties = propertyService.listAllProperties();
		if (properties.isEmpty()) {
			return new ResponseEntity("Sorry! Properties not available!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Property>>(properties, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/property/filterproperties")
	public ResponseEntity<List<Property>> getPropertiesByCriteria(@RequestBody PropertyCriteria criteria) {
		List<Property> properties = propertyService.listPropertyByCriteria(criteria);
		if (properties.isEmpty()) {
			return new ResponseEntity("Sorry! Properties not available!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Property>>(properties, HttpStatus.OK);
	}

}
