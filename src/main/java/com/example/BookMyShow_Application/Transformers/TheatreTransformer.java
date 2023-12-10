package com.example.BookMyShow_Application.Transformers;

import com.example.BookMyShow_Application.Models.Theatre;
import com.example.BookMyShow_Application.RequestDtos.AddTheatreRequest;

public class TheatreTransformer {

    public static Theatre convertAddTheatreReqToTheatreEntity(AddTheatreRequest addTheatreRequest) {
        Theatre theatre = Theatre.builder()
                .name(addTheatreRequest.getName())
                .address(addTheatreRequest.getAddress())
                .city(addTheatreRequest.getCity())
                .build();

        return theatre;
    }
}
