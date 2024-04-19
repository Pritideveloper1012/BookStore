package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entities.Book;
import com.bookStore.service.BookService;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
		
	}
	@GetMapping("/book_register")
	public String bookRegister() {
		return "book_register";
		
	}
	@GetMapping("/available_books")
	public ModelAndView availableBooks() {
		List<Book> list=bookService.availableBooks();
		ModelAndView modelAndView=new ModelAndView("available_books");	
	     //modelAndView.setViewName("available_books");
	     modelAndView.addObject("book",list );
	     return modelAndView;
	}
	
//	@GetMapping("/my_books")
//	public String myBooks() {
//		return "my_books";
//		
//	}
	@PostMapping("/save")
	public String addbook(@ModelAttribute Book b) {
		bookService.save(b);
		return"redirect:/available_books";
	}
	@GetMapping("/addBook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book()); // Assuming Book is your domain model class
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
        // Logic to add the book to the bookstore
        // You can handle saving the book to a database or any other actions here
        return "redirect:/"; // Redirect to home page after adding the book
    }
	
	
}
