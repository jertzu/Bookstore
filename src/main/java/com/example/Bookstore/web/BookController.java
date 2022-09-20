package com.example.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
    @RequestMapping(value= {"/", "/booklist"})
    public String bookList(Model model) {	
        model.addAttribute("books", bookRepository.findAll());
        return "/booklist";
    }
  
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categorys", categoryRepository.findAll());
        return "/addbook";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("book") Book book){
    	bookRepository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	bookRepository.deleteById(bookId);
        return "redirect:/booklist";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) { 
    	model.addAttribute("book", bookRepository.findById(bookId));
    	model.addAttribute("categorys", categoryRepository.findAll());
        return "/editbook";
    }
}
