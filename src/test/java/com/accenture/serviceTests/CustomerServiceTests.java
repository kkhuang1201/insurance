package com.accenture.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


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
import com.accenture.repositories.CustomerRepository;
import com.accenture.services.CustomerService;

public class CustomerServiceTests {

	@InjectMocks
	private static CustomerService customerService;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.openMocks(this);
		Address address = new Address(1,"2027 abc","","NY","BK","11220","USA");
		Customer cust1 = new Customer(1,"a1","b1",address,29,LocalDate.of(1991, 12, 1)); 
		Customer cust2 = new Customer(2,"a2","b2",address,10,LocalDate.of(2001, 12, 1)); 
		Customer cust3 = new Customer(3,"a3","b3",address,9,LocalDate.of(2011, 12, 1)); 
		
		List<Customer> customers = new ArrayList<>();
		customers.add(cust1);
		customers.add(cust2);
		customers.add(cust3);
		
		when(customerRepository.findAll()).thenReturn(customers);
		when(customerRepository.save(new Customer())).thenReturn(cust1);
		when(customerRepository.findById(1)).thenReturn(cust1);
	}
	
	@Test
	public void testFindAll() {
		
		List<Customer> result = customerService.findAll();
		int i =1;
		for(Customer c:result) {
			
			Assert.assertEquals(i++, c.getId());
		}
	}
	
	@Test
	public void testFind() {
		
		Customer cust = customerService.find(1);
		
		Assert.assertEquals(1, cust.getId());
		Assert.assertEquals("a1", cust.getFirst_name());
		Assert.assertEquals("b1", cust.getLast_name());
		
	}
	
	@Test 
	public void testCreat() {
		
		Customer cust = customerService.create(new Customer());
		assertEquals(1, cust.getId());
		
	}
	
	@Test
	public void testUpdate() {
		
		Customer cust = new Customer();
		cust.setId(1);
		Customer result = customerService.update(cust);
		Assert.assertEquals(null, result);
	
		
	}
	
	
}
