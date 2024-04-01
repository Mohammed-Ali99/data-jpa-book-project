package com.spring.book.controller;

import com.spring.book.entity.Book;
import com.spring.book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.insert(book));
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> deleteByAuthorId(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteByAuthorId(id));
    }

}
