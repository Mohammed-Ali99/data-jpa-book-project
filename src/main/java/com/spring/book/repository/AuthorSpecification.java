package com.spring.book.repository;

import com.spring.book.entity.Author;
import com.spring.book.entity.AuthorSearch;
import com.spring.book.entity.Book;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AuthorSpecification implements Specification<Author> {

    private AuthorSearch search;

    public AuthorSpecification(AuthorSearch search) {
        this.search = search;
    }

    @Override
    public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        Join<Author , Book> bookJoin = root.join("books" , JoinType.LEFT);

        // author name
        if(search.getName() != null && !search.getName().isEmpty()) {
            predicates.add(cb.like(root.get("name") , search.getName()));
        }

        if (search.getEmail() != null && !search.getEmail().isEmpty()) {
            predicates.add(cb.like(root.get("email") , search.getEmail()));
        }

        if (search.getIpAddress() != null && !search.getIpAddress().isEmpty()) {
            predicates.add(cb.like(root.get("ipAddress") , search.getIpAddress()));
        }

        if (search.getBookName() != null && !search.getBookName().isEmpty()) {
            predicates.add(cb.like(bookJoin.get("name") , search.getBookName()));
        }

        if (search.getPrice() != 0) {
            predicates.add(cb.greaterThanOrEqualTo(bookJoin.get("salary") , search.getPrice()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
