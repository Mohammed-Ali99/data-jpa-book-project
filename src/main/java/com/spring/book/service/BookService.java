package com.spring.book.service;

import com.spring.book.entity.Book;
import com.spring.book.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;


    public Book findById(Long id) {
        return bookRepo.findById(id).get();
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Book insert(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> insertAll(List<Book> books) {
        return bookRepo.saveAll(books);
    }

    public Book update(Book book) {
        Book bok = findById(book.getId());
        bok.setName(book.getName());
        bok.setSalary(book.getSalary());
        bok.setAuthor(book.getAuthor());

        return bok;
    }

    public void delete(Long id) {
        bookRepo.deleteById(id);
    }


    public int deleteByAuthorId(Long id) {
        return bookRepo.deleteByAuthorId(id);
    }


}
