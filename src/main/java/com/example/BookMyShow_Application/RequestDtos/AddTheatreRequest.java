package com.example.BookMyShow_Application.RequestDtos;

import com.example.BookMyShow_Application.Enums.City;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddTheatreRequest {

    private String name;

    private String address;

    private City city;

    private Integer noOfPremiumSeats;

    private Integer noOfClassicSeats;

    private Integer noOfSeatsPerRow;
}
