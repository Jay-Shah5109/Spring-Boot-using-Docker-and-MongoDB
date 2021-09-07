package com.springboot.springbootmongodbdocker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootmongodbdocker.dao.BookRepository;
import com.springboot.springbootmongodbdocker.model.Book;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class SpringbootMongodbDockerApplication {
	
	@Autowired
	private BookRepository repository;
	
	@PostMapping
	public Book saveBook(@RequestBody Book book){
		return repository.save(book);
	}
	
	@GetMapping
	public List<Book> getBooks(){
		return repository.findAll();
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbDockerApplication.class, args);
	}

}
