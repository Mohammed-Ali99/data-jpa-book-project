package com.spring.book.controller;

import com.spring.book.entity.Author;
import com.spring.book.entity.AuthorSearch;
import com.spring.book.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Min(value = 1) @Max(value = 200) Long id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @PostMapping("")
    public Author insert(@RequestBody @Valid Author author) {
        return authorService.insert(author);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.update(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok(null);
    }


    @PostMapping("/spec")
    public ResponseEntity<?> findByAuthorSpec(@RequestBody AuthorSearch search) {
        return ResponseEntity.ok(authorService.findByAuthorSpec(search));
    }

}
