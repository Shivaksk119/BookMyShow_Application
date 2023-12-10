package com.example.BookMyShow_Application.Controllers;

import com.example.BookMyShow_Application.RequestDtos.BookTicketRequest;
import com.example.BookMyShow_Application.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest) {
        String result = ticketService.bookTicket(bookTicketRequest);
        return result;
    }

}
