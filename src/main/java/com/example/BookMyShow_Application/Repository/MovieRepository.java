package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieByMovieName(String movieName);
}
