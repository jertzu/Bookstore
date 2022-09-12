package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository; 
	
    @RequestMapping(value= {"/", "/booklist"})
    public String studentList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
  
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
        return "booklist";
    }     
}
