package com.example.BookMyShow_Application.RequestDtos;

import com.example.BookMyShow_Application.Models.Movie;
import com.example.BookMyShow_Application.Models.Theatre;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddShowRequest {

    private LocalDate showDate;

    private LocalTime showTime; // 24hr Format

    private String movieName; //movie Name is unique

    private Integer theatreId;
}
