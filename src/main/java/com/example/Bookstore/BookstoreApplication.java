package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.UserClass;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			UserClass userClass1 = new UserClass("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "testi@testi.com");
			UserClass userClass2 = new UserClass("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "testi@testi.com");
			userRepository.save(userClass1);
			userRepository.save(userClass2);
			
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Scifi"));
			
			bookRepository.save(new Book("The Lord of the Rings", "J.R.R. Tolkien", categoryRepository.findByName("Fantasy").get(0)));
			bookRepository.save(new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams", categoryRepository.findByName("Scifi").get(0)));
		};
	}

}
