package com.example.BookMyShow_Application.Services;

import com.example.BookMyShow_Application.Models.*;
import com.example.BookMyShow_Application.Repository.*;
import com.example.BookMyShow_Application.RequestDtos.BookTicketRequest;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;


    public String bookTicket(BookTicketRequest bookTicketRequest) {
        Show show  = findRightShow(bookTicketRequest);

        //Booking Steps are:
        //Calculate total Price
        //mark available seats and not available
        //also need it to add it to the list of  booked tickets against user

        List<ShowSeat> showSeatList = show.getShowSeatList();

        int totalPrice = 0;
        for(ShowSeat showSeat:showSeatList) {
            if(bookTicketRequest.getRequestedSeatNos().contains(showSeat.getSeatNo())) {
                showSeat.setAvailable(false);
                totalPrice = totalPrice + showSeat.getCost();
            }
        }

        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        Ticket ticket = Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .theatreAddress(show.getTheatre().getAddress())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .bookedSeats(bookTicketRequest.getRequestedSeatNos().toString())
                .user(user)
                .show(show)
                .totalPrice(totalPrice)
                .build();

        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);

        ticketRepository.save(ticket);

        //Sending Mail
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String body = "Hello "+user.getName()+"Your Ticket has been booked for the "+ticket.getMovieName()+" movie on "+ticket.getShowDate()+" for "+ticket.getShowTime()+" show, at "+ticket.getTheatreAddress()+" theatre."+"Enjoy the Show!!!.";

        //sending Mails
        mailMessage.setFrom("springaccio@gmail.com");
        mailMessage.setTo(user.getEmailId());
        mailMessage.setSubject("Account Created");
        mailMessage.setText(body);

        return "Your Ticket has been booked for the "+ticket.getMovieName()+" movie on "+ticket.getShowDate()+" for "+ticket.getShowTime()+" show, at "+ticket.getTheatreAddress()+" theatre.";

    }

    public Show findRightShow(BookTicketRequest bookTicketRequest) {
        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());

        Theatre theatre = theatreRepository.findById(bookTicketRequest.getTheatreId()).get();

        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheatre(bookTicketRequest.getShowDate(), bookTicketRequest.getShowTime(), movie, theatre);

        return show;

    }
}
