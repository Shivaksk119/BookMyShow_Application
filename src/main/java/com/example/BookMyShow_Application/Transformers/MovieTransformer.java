package com.example.BookMyShow_Application.Transformers;

import com.example.BookMyShow_Application.Models.Movie;
import com.example.BookMyShow_Application.RequestDtos.AddMovieRequest;

public class MovieTransformer {
    public static Movie convertAddMovieRequestToMovie(AddMovieRequest addMovieRequest) {

        Movie movie = Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .rating(addMovieRequest.getRating())
                .releaseDate(addMovieRequest.getReleaseDate())
                .build();

        return movie;
    }
}
