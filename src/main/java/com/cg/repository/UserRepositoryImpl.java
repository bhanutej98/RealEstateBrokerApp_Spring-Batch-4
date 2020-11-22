package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.entity.User;

/**
 * @author Anila Meenavalli
 *
 * 
 */
@Repository
public interface UserRepositoryImpl extends JpaRepository<User, Integer> {

}
