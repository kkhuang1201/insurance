package com.accenture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.models.Address;
import com.accenture.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Address create(Address address) {
		
		return this.addressRepository.save(address);
	}
	
	public Address find(int id) {
		
		return this.addressRepository.findById(id);
	}
	
	public Address update(Address address) {
		
		Address existedAddress = this.addressRepository.findById(address.getId());
		
		if(existedAddress!=null) {
			
			return this.addressRepository.save(address);
			
		}	
		
		return null;
	}
	
	public void delete(int id) {
		
		Address existedAddress = this.addressRepository.findById(id);
		
		if(existedAddress!=null) {
			
			this.addressRepository.delete(existedAddress);
			
		}
		
		
	}
	
	public List<Address> findAll(){
		
		return this.addressRepository.findAll();
	}
}
