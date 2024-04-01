package com.spring.book.repository;

import com.spring.book.base.BaseRepository;
import com.spring.book.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends BaseRepository<Book> {

    @Transactional
    @Modifying
    @Query("delete from Book where author.id = :id")
    public int deleteByAuthorId(Long id);
}
