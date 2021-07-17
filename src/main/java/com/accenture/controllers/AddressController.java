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

import com.accenture.models.Address;
import com.accenture.services.AddressService;


@RestController
@RequestMapping(path = "/insurance/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public List<Address> list(){
		
		return this.addressService.findAll();
	}
	
	@GetMapping("{id}")
	public Address get(@PathVariable int id) {
		
		return this.addressService.find(id);
	}
	
	@PostMapping
	public Address create(@RequestBody Address address) {
		
		return this.addressService.create(address);
		
	}
	
	@PutMapping
	public Address update(@RequestBody Address address) {
		
		return this.addressService.update(address);
		
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		
		this.addressService.delete(id);
		
	}
	

}
