package com.thumati.eugen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.thumati.eugen.domain.Book;
import com.thumati.eugen.repo.BookRepository;

@SpringBootApplication
public class EugenApplication {
	
	@Autowired
	private BookRepository bookRepo;

	@Component
	class DataSetup implements ApplicationRunner{
		@Override
		public void run(ApplicationArguments args) throws Exception {
			bookRepo.save(Book.builder().title("Gone with the Wind").isbn("12345").build());
			bookRepo.save(Book.builder().title("Effective Java").isbn("224253").build());
			bookRepo.save(Book.builder().title("Thinking in java").isbn("98765").build());
			bookRepo.save(Book.builder().title("Head First Java").isbn("339912").build());
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EugenApplication.class, args);
	}
}
