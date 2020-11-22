package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Property;

/**
 * @author Chiranjeevi Bhanu Teja Tatavarthi
 *
 * 
 */
@Repository
public interface PropertyRepoImpl extends JpaRepository<Property, Integer> {

	@Query("SELECT property FROM Property property WHERE property.configuration=:config OR"
			+ " property.offerType=:offer OR property.city=:city OR (property.offerCost BETWEEN :minCost AND :maxCost)")
	List<Property> listPropertyByCriteria(@Param("config") String config, @Param("offer") String offer,
			@Param("city") String city, @Param("minCost") double minCost, @Param("maxCost") double maxCost);
}
