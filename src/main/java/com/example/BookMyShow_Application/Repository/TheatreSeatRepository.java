package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.Models.TheatreSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeat, Integer> {
}
