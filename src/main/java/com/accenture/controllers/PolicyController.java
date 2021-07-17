package com.accenture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.models.Policy;
import com.accenture.services.PolicyService;

@RestController
@RequestMapping(path = "/insurance/policies")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@GetMapping
	public List<Policy> list(){
		
		return this.policyService.findAll();
	}
	
	@GetMapping("{polNumber}")
	public Policy get(@PathVariable int polNumber) {
		
		return this.policyService.find(polNumber);
	}
	
	@PostMapping
	public Policy create(@RequestBody Policy policy) {
		
		return this.policyService.create(policy);
		
	}
	
	@PutMapping
	public Policy update(@RequestBody Policy policy) {
		
		return this.policyService.update(policy);
		
	}
	
	@DeleteMapping("{polNumber}")
	public void delete(@PathVariable int polNumber) {
		
		this.policyService.delete(polNumber);
		
	}
	

}
