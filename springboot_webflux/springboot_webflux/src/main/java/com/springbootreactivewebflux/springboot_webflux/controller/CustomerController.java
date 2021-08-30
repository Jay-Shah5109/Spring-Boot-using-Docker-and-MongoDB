package com.springbootreactivewebflux.springboot_webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootreactivewebflux.springboot_webflux.dto.Customer;
import com.springbootreactivewebflux.springboot_webflux.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerservice;
	
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerservice.loadAllCustomers(); 
		// If we cancel the request for normal response from browser
		// in middle of execution, still in the backend the request continues to proceed, but in case of calling
		// the Flux endpoint the execution stops from the middle of execution even from the backend. This is the 
		// main point of difference between the Flux and normal Java 8 execution behaviour
		
	}
	
	@GetMapping(value="/stream",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getAllCustomersStream(){
		return customerservice.loadAllCustomersStream();
		
	}
	
	

}
