package com.spring.book.service;

import com.spring.book.entity.Author;
import com.spring.book.entity.AuthorSearch;
import com.spring.book.error.DaplicateRecordException;
import com.spring.book.error.RecordNotFoundException;
import com.spring.book.repository.AuthorRepo;
import com.spring.book.repository.AuthorSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;



    public Author findById(Long id) {

        Optional<Author> entity = authorRepo.findById(id);
        if(entity.isPresent()) {
            return entity.get();
        } else {
            throw new RecordNotFoundException("this record with id:- " + id + " not found");
        }
    }

    private Optional<Author> findByEmail(String emial) {
        return authorRepo.findByEmail(emial);
    }


    /*
    public Author getOne(Long id) {
        return authorRepo.getById(id);
    }
    */

    public List<Author> findByAuthorSpec(AuthorSearch search) {
        AuthorSpecification authorSpecification = new AuthorSpecification(search);
        return authorRepo.findAll(authorSpecification);

    }

    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    public Author insert(Author author) {

        if(!author.getEmail().isEmpty() && author.getEmail() != null) {
            Optional<Author> entity = findByEmail(author.getEmail());

            if(entity.isPresent()) {
                throw new DaplicateRecordException("this email :- " + author.getEmail() + " is already exist");
            } else {
                authorRepo.save(author);
            }
        }
        return author;
    }

    public List<Author> insertAll(List<Author> authors) {
        return authorRepo.saveAll(authors);
    }

    public Author update(Author author) {
        Author entity = findById(author.getId());
        entity.setName(author.getName());
        return authorRepo.save(author);
    }

    public void deleteById(Long id) {
        authorRepo.deleteById(id);
    }
}
