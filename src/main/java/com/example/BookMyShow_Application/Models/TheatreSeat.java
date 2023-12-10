package com.example.BookMyShow_Application.Models;

import com.example.BookMyShow_Application.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theatre_seat")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theatreSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;

}
