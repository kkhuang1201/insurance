package com.accenture.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.models.Address;
import com.accenture.models.Customer;
import com.accenture.models.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer>{

	void delete(Policy policy);
	Policy findByPolNumber(int id);
	List<Policy> findAll();
}
