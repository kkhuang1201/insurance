package com.accenture.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.models.Address;
import com.accenture.models.Customer;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>{
	
	void delete(Address address);
	Address findById(int id);
	List<Address> findAll();
}
