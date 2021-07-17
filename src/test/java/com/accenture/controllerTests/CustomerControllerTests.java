package com.accenture.controllerTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import com.accenture.models.Address;
import com.accenture.models.Customer;
import com.accenture.services.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTests {
	
	@MockBean
	private CustomerService customerService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private Customer mockCustomer;
	
	@Before
	public void setup() {
		
		Address address = new Address(1,"2027 abc","","NY","BK","11220","USA");
		Customer cust1 = new Customer(1,"a1","b1",address,29,LocalDate.of(2001, 12, 1)); 
		Customer cust2 = new Customer(2,"a2","b2",address,10,LocalDate.of(2001, 12, 2)); 
		Customer cust3 = new Customer(3,"a3","b3",address,9,LocalDate.of(2001, 12, 3)); 
		
		List<Customer> customers = new ArrayList<>();
		customers.add(cust1);
		customers.add(cust2);
		customers.add(cust3);
		
		when(customerService.findAll()).thenReturn(customers);
	}
	
	@Test
	public void testList() throws Exception{
		
		MvcResult result = mockMvc.perform(get("/insurance/customers"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		Assert.assertNotNull(result.getResponse());
	}
	
}
