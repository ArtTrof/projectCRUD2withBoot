package com.example.CRUDProject2Boot.repositories;

import com.example.CRUDProject2Boot.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
List<Book>findByTitleStartingWith(String title);
}
