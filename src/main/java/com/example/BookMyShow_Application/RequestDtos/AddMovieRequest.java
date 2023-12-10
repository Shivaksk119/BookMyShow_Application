package com.example.BookMyShow_Application.RequestDtos;

import com.example.BookMyShow_Application.Enums.Genre;
import lombok.*;

import java.time.LocalDate;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddMovieRequest {

    private String movieName;

    private Double rating;

    private Genre genre;

    private LocalDate releaseDate; //In YYYY/MM/DD format

}
