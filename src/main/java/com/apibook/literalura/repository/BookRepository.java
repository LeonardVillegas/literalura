package com.apibook.literalura.repository;

import com.apibook.literalura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
