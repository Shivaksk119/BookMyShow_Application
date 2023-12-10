package com.example.BookMyShow_Application.RequestDtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookTicketRequest {

    private String movieName;

    private Integer theatreId;

    private LocalDate showDate;

    private LocalTime showTime;

    private List<String> requestedSeatNos;

    private Integer userId;

    //food coupons is our part



}
