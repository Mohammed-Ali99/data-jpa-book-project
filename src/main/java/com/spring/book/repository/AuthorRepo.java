package com.spring.book.repository;

import com.spring.book.base.BaseRepository;
import com.spring.book.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends BaseRepository<Author> , JpaSpecificationExecutor {

    Optional<Author> findByEmail(String email);


}
