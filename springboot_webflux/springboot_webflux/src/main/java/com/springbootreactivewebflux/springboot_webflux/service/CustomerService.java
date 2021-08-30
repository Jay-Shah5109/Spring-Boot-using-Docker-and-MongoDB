package com.springbootreactivewebflux.springboot_webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootreactivewebflux.springboot_webflux.dao.CustomerDAO;
import com.springbootreactivewebflux.springboot_webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	
	public List<Customer> loadAllCustomers(){
		
		long start_time=System.currentTimeMillis();
		List<Customer> customers=customerDAO.getCustomers();
		long end_time=System.currentTimeMillis();
		System.out.println("Total execution time is:"+(end_time-start_time));
		return customers;
		
	}
	
	public Flux<Customer> loadAllCustomersStream(){
		
		long start_time=System.currentTimeMillis();
		Flux<Customer> customers=customerDAO.getCustomersStream();
		long end_time=System.currentTimeMillis();
		System.out.println("Total execution time is:"+(end_time-start_time));
		return customers;
		
	}
	
	
	
	

}
