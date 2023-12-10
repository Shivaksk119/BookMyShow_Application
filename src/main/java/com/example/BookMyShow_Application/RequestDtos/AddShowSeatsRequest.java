package com.example.BookMyShow_Application.RequestDtos;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddShowSeatsRequest {

    private Integer showId;

    private Integer priceOfClassicSeats;

    private Integer priceOfPremiumSeats;


}
