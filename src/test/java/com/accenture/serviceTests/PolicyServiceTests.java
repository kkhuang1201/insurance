package com.accenture.serviceTests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accenture.models.Address;
import com.accenture.models.Customer;
import com.accenture.models.Policy;
import com.accenture.models.Policy;
import com.accenture.repositories.PolicyRepository;
import com.accenture.services.PolicyService;

public class PolicyServiceTests {

	@InjectMocks
	private static PolicyService PolicyService;
	
	@Mock
	private PolicyRepository policyRepository;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.openMocks(this);
		
		Policy policy1 = new Policy(1,"vip","NJ",100,LocalDate.of(2021, 12, 1), LocalDate.of(2022, 12, 1),new Customer());
		Policy policy2 = new Policy(2,"vip","NJ",100,LocalDate.of(2021, 12, 1), LocalDate.of(2022, 12, 1),new Customer());
		Policy policy3 = new Policy(3,"vip","NJ",100,LocalDate.of(2021, 12, 1), LocalDate.of(2022, 12, 1),new Customer());

		
		List<Policy> policies = new ArrayList<>();
		policies.add(policy1);
		policies.add(policy2);
		policies.add(policy3);
		
		when(policyRepository.findAll()).thenReturn(policies);
		when(policyRepository.save(new Policy())).thenReturn(policy1);
		when(policyRepository.findByPolNumber(1)).thenReturn(policy1);
	}
	
	@Test
	public void testFindAll() {
		
		List<Policy> result = PolicyService.findAll();
		int i =1;
		for(Policy c:result) {
			
			Assert.assertEquals(i++, c.getPolNumber());
		}
	}
	
	@Test
	public void testFind() {
		
		Policy policy = PolicyService.find(1);
		
		Assert.assertEquals(1, policy.getPolNumber());
	
		
	}
	
	@Test 
	public void testCreat() {
		
		Policy policy = PolicyService.create(new Policy());
		assertEquals(1, policy.getPolNumber());
		
	}
	
	@Test
	public void testUpdate() {
		
		Policy policy = new Policy();
		policy.setPolNumber(1);
		Policy result = PolicyService.update(policy);
		Assert.assertEquals(null, result);
	
		
	}
	
}
