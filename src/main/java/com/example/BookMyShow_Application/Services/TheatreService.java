package com.example.BookMyShow_Application.Services;

import com.example.BookMyShow_Application.Enums.SeatType;
import com.example.BookMyShow_Application.Models.Theatre;
import com.example.BookMyShow_Application.Models.TheatreSeat;
import com.example.BookMyShow_Application.Repository.TheatreRepository;
import com.example.BookMyShow_Application.RequestDtos.AddTheatreRequest;
import com.example.BookMyShow_Application.Transformers.TheatreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;


    public String addTheatre(AddTheatreRequest addTheatreRequest) {

        // Create Theatre Entity
        Theatre theatre = TheatreTransformer.convertAddTheatreReqToTheatreEntity(addTheatreRequest); // using transformer function

        //create Theatre Seats
        createTheatreSeats(theatre, addTheatreRequest);

        return "Theatre and it's seats ave been saved to DB";
    }

    public void createTheatreSeats(Theatre theatre, AddTheatreRequest addTheatreRequest) {

        int noOfClassicSeats = addTheatreRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheatreRequest.getNoOfPremiumSeats();
        int seatsPerRow = addTheatreRequest.getNoOfSeatsPerRow();


        //Creating the primary Seat Entities
        List<TheatreSeat> theatreSeatList = new ArrayList<>();

        //adding classic seats
        int row = 1;
        char ch =  'A';

        for(int i=1;i<noOfClassicSeats;i++) {
            String currSeatNo = ""+row+ch;

            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo(currSeatNo)
                    .seatType(SeatType.CLASSIC)
                    .theatre(theatre) //given in params //Foreign Key
                    .build();

            theatreSeatList.add(theatreSeat);

            if(i%seatsPerRow==0) {   //if(ch>=('A'+seatsPerRow-1))
                row++;                  //row++;
                ch= 'A';                //ch= 'A'
            }
            else {
                ch++;
            }
        }

        //adding PREMIUM seats
        ch = 'A';
        for(int i=1;i<noOfPremiumSeats;i++) {
            String currSeatNo = ""+row+ch;

            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo(currSeatNo)
                    .seatType(SeatType.PREMIUM)
                    .theatre(theatre) //Foreign Key
                    .build();

            theatreSeatList.add(theatreSeat);

            if(i%seatsPerRow==0) {   //if(ch>=('A'+seatsPerRow-1))
                row++;                  //row++;
                ch= 'A';                //ch= 'A'
            }
            else {
                ch++;
            }
        }

        //adding seat list to the Theatre
        theatre.setTheatreSeatList(theatreSeatList);

        theatreRepository.save(theatre);
    }
}
