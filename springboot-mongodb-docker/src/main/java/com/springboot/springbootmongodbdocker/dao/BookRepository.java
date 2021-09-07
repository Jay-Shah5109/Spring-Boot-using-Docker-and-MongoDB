package com.springboot.springbootmongodbdocker.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.springbootmongodbdocker.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
