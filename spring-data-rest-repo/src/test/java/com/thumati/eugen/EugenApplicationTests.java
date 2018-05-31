package com.thumati.eugen;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thumati.eugen.repo.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EugenApplicationTests {

	@Autowired
	private BookRepository bookRepo;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void persistenceWorks() {
		assertThat(bookRepo.findAll(), not(Matchers.emptyIterable()));
	}
}
