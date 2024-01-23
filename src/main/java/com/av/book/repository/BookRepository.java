package com.av.book.repository;

import com.av.book.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Query("select c from BookEntity c ")
    List<BookEntity> getAll();

}
