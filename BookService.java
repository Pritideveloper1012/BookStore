package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entities.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	public void save(Book  book) {
		bookRepository.save(book);
		
		
	}
	public List<Book> availableBooks(){
		return bookRepository.findAll();	
		}
	
	}
	


