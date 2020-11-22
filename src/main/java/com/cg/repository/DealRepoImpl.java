package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Deal;

/**
 * @author VSSVSN Raju
 *
 * 
 */
@Repository
public interface DealRepoImpl extends JpaRepository<Deal, Integer> {

}
