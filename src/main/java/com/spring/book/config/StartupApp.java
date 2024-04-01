package com.spring.book.config;

import com.spring.book.entity.Author;
import com.spring.book.entity.Book;
import com.spring.book.service.AuthorService;
import com.spring.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupApp implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
       if(authorService.findAll().isEmpty()) {
           Author author1 = new Author();
           author1.setName("ali");
           author1.setEmail("ali@gmail.com");
           author1.setIpAddress("192.147.1");

           Author author2 = new Author();
           author2.setName("mohamed");
           author2.setEmail("mohamed@gmail.com");
           author2.setIpAddress("192.147.2");

           Author author3 = new Author();
           author3.setName("ahmed");
           author3.setEmail("ahmed@gmail.com");
           author3.setIpAddress("192.147.3");

           authorService.insertAll(Arrays.asList(author1 , author2 , author3));
        }
       if(bookService.findAll().isEmpty()) {
           Book book1 = new Book();
           book1.setName("Java Jpa");
           book1.setSalary(200);
           book1.setAuthor(authorService.findById(1L));

           Book book2 = new Book();
           book2.setName("Database MySQL");
           book2.setSalary(300);
           book2.setAuthor(authorService.findById(1L));

           Book book3 = new Book();
           book3.setName("Python");
           book3.setSalary(120);
           book3.setAuthor(authorService.findById(2L));

           bookService.insertAll(Arrays.asList(book1, book2, book3));
       }




    }
}
