package com.example.BookMyShow_Application.Services;

import com.example.BookMyShow_Application.Enums.Genre;
import com.example.BookMyShow_Application.Models.Movie;
import com.example.BookMyShow_Application.Repository.MovieRepository;
import com.example.BookMyShow_Application.RequestDtos.AddMovieRequest;
import com.example.BookMyShow_Application.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(AddMovieRequest addMovieRequest) throws Exception{

        Movie movie = MovieTransformer.convertAddMovieRequestToMovie(addMovieRequest);
        movieRepository.save(movie);

        return "Movie has been added to the DB successfully";

    }

}
