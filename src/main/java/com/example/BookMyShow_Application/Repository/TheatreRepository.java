package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
}
