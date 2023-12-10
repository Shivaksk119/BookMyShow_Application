package com.example.BookMyShow_Application.Transformers;

import com.example.BookMyShow_Application.Models.Show;
import com.example.BookMyShow_Application.RequestDtos.AddShowRequest;

public class ShowTransformer {

    public  static Show convertAddRequestToEntity(AddShowRequest addShowRequest) {
        Show showObj = Show.builder()
                .showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .build();

        return showObj;
    }
}
