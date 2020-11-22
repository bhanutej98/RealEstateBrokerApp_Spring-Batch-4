package com.cg.repository;

import com.cg.entity.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rithvik Krishna Sigala
 *
 * 
 */
@Repository
public interface BrokerRepoImpl extends JpaRepository<Broker, Integer> {

}
