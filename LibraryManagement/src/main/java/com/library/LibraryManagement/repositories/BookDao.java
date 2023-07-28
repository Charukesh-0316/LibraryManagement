package com.library.LibraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.LibraryManagement.entities.Book;

@Repository
public interface BookDao extends JpaRepository<Book,Long> {}
