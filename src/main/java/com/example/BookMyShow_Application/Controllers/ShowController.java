package com.example.BookMyShow_Application.Controllers;

import com.example.BookMyShow_Application.RequestDtos.AddShowRequest;
import com.example.BookMyShow_Application.RequestDtos.AddShowSeatsRequest;
import com.example.BookMyShow_Application.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest) {

        String result = showService.addShow(addShowRequest);
        return result;
    }

    @PostMapping("/createShowSeats")
    public String enableShowSeats(@RequestBody AddShowSeatsRequest addShowSeatsRequest) {
        String result = showService.createShowSeats(addShowSeatsRequest);
        return result;
    }
}
