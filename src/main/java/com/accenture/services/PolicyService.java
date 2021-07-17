package com.accenture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.accenture.models.Policy;
import com.accenture.repositories.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository policyRepository;
	
	public Policy create(Policy policy) {
		
		return this.policyRepository.save(policy);
	}
	
	public Policy find(int id) {
		
		return this.policyRepository.findByPolNumber(id);
	}
	
	public Policy update(Policy policy) {
		
		Policy existedPolicy= this.policyRepository.findByPolNumber(policy.getPolNumber());
		
		if(existedPolicy!=null) {
			
			return this.policyRepository.save(policy);
			
		}	
		
		return null;
	}
	
	public void delete(int id) {
		
		Policy existedPolicy = this.policyRepository.findByPolNumber(id);
		
		if(existedPolicy!=null) {
			
			this.policyRepository.delete(existedPolicy);
			
		}
		
		
	}
	
	public List<Policy> findAll(){
		
		return this.policyRepository.findAll();
	}
}
