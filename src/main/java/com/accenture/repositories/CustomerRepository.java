package com.accenture.repositories;

import com.accenture.models.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	void delete(Customer customer);
	Customer findById(int id);
	List<Customer> findAll();
	
}
