package com.cg.repository;

import com.cg.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gowri Sneha Priya
 *
 * 
 */
@Repository
public interface CustomerRepoImpl extends JpaRepository<Customer, Integer> {

}