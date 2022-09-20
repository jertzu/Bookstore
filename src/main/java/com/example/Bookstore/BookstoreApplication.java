package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Scifi"));
			
			bookRepository.save(new Book("The Lord of the Rings", "J.R.R. Tolkien", categoryRepository.findByName("Fantasy").get(0)));
			bookRepository.save(new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", categoryRepository.findByName("Scifi").get(0)));
		};
	}

}
