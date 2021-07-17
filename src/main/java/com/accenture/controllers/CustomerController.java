package com.accenture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.models.Customer;
import com.accenture.services.CustomerService;

@RestController
@RequestMapping(path = "/insurance/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> list(){
		
		return this.customerService.findAll();
	}
	
	@GetMapping("{id}")
	@Cacheable(value = "Customer", key = "#id")
	public Customer get(@PathVariable int id) {
		
		return this.customerService.find(id);
	}
	
	@PostMapping()
	public Customer create(@RequestBody Customer customer) {
		
		return this.customerService.create(customer);
		
	}
	
	@PutMapping
	public Customer update(@RequestBody Customer customer) {
		
		return this.customerService.update(customer);
		
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		
		this.customerService.delete(id);
		
	}
	
	
}
