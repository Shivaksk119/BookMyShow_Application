package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.Models.Movie;
import com.example.BookMyShow_Application.Models.Show;
import com.example.BookMyShow_Application.Models.Theatre;
import com.example.BookMyShow_Application.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {


}
