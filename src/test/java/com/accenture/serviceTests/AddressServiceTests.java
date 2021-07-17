package com.accenture.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accenture.models.Address;
import com.accenture.repositories.AddressRepository;
import com.accenture.services.AddressService;

public class AddressServiceTests {

	@InjectMocks
	private static AddressService addressService;
	
	@Mock
	private AddressRepository addressRepository;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.openMocks(this);
		Address address1 = new Address(1,"2027 abc","","NY","BK","11220","USA");
		Address address2 = new Address(2,"2028 abc","","NY","BK","11220","USA");
		Address address3 = new Address(3,"2029 abc","","NY","BK","11220","USA");
		 
		
		List<Address> addresses = new ArrayList<>();
		addresses.add(address1);
		addresses.add(address2);
		addresses.add(address3);
		
		when(addressRepository.findAll()).thenReturn(addresses);
		when(addressRepository.save(new Address())).thenReturn(address1);
		when(addressRepository.findById(1)).thenReturn(address1);
	}
	
	@Test
	public void testFindAll() {
		
		List<Address> result = addressService.findAll();
		int i =1;
		for(Address c:result) {
			
			Assert.assertEquals(i++, c.getId());
		}
	}
	
	@Test
	public void testFind() {
		
		Address addr = addressService.find(1);
		
		Assert.assertEquals(1, addr.getId());
		Assert.assertEquals("2027 abc", addr.getLine1());

		
	}
	
	@Test 
	public void testCreat() {
		
		Address addr = addressService.create(new Address());
		assertEquals(1, addr.getId());
		
	}
	
	@Test
	public void testUpdate() {
		
		Address addr = new Address();
		addr.setId(1);
		Address result = addressService.update(addr);
		Assert.assertEquals(null, result);
	
		
	}
	
}
