package com.example.BookMyShow_Application.Services;

import com.example.BookMyShow_Application.Enums.SeatType;
import com.example.BookMyShow_Application.Models.*;
import com.example.BookMyShow_Application.Repository.MovieRepository;
import com.example.BookMyShow_Application.Repository.ShowRepository;
import com.example.BookMyShow_Application.Repository.ShowSeatRepository;
import com.example.BookMyShow_Application.Repository.TheatreRepository;
import com.example.BookMyShow_Application.RequestDtos.AddShowRequest;
import com.example.BookMyShow_Application.RequestDtos.AddShowSeatsRequest;
import com.example.BookMyShow_Application.Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String addShow(AddShowRequest addShowRequest) {

        Show show = ShowTransformer.convertAddRequestToEntity(addShowRequest);

        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());

        Optional<Theatre> optionalTheatre = theatreRepository.findById(addShowRequest.getTheatreId());
        Theatre theatre = optionalTheatre.get();

        //setting FK's
        show.setMovie(movie);
        show.setTheatre(theatre);
//
//        // setting the bidirection mapping
        theatre.getShowList().add(show);
        movie.getShowList().add(show);

        show = showRepository.save(show);

        return "Show has been saved to the DB with showID" + show.getShowId();
    }

    public String createShowSeats(AddShowSeatsRequest addShowSeatsRequest) {
        // I need to create showSeats and Save to DB.
        Show show = showRepository.findById(addShowSeatsRequest.getShowId()).get();
        Theatre theatre = show.getTheatre();
        List<TheatreSeat> theatreSeatList = theatre.getTheatreSeatList();

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheatreSeat theatreSeat : theatreSeatList) {

            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theatreSeat.getSeatNo())
                    .seatType(theatreSeat.getSeatType())
                    .isAvailable(true)
                    .isFoodAttached(false)
                    .show(show)
                    .build();

            if(theatreSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setCost(addShowSeatsRequest.getPriceOfClassicSeats());
            }
            else {
                showSeat.setCost(addShowSeatsRequest.getPriceOfPremiumSeats());
            }
            showSeatList.add(showSeat);
        }

        show.setShowSeatList(showSeatList);

        //Either save  parent or Save
        //Child is having alot of seats(neef to save the list)

        showRepository.save(show); //saving the list of showSeats

        return "The shows Seats have been added";


    }


}
