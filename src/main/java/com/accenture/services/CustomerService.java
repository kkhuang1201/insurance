package com.accenture.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.models.Customer;
import com.accenture.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer create(Customer customer) {
		
		return this.customerRepository.save(customer);
	}
	
	public Customer find(int id) {
		
		LOGGER.info("Getting a Customer from DB");
		return this.customerRepository.findById(id);
	}
	
	public Customer update(Customer customer) {
		
		Customer existedCustomer = this.customerRepository.findById(customer.getId());
		
		if(existedCustomer!=null) {
			
			return this.customerRepository.save(customer);
			
		}	
		
		return existedCustomer;
	}
	
	public void delete(int id) {
		
		Customer existedCustomer = this.customerRepository.findById(id);
		
		if(existedCustomer!=null) {
			
			this.customerRepository.delete(existedCustomer);
			
		}
	}
	
	public List<Customer> findAll(){
		
		return this.customerRepository.findAll();
	}
	
}
