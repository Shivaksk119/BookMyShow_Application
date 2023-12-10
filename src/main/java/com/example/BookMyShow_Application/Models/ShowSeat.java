package com.example.BookMyShow_Application.Models;

import com.example.BookMyShow_Application.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "show_seats")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer cost;

    private boolean isAvailable;

    private boolean isFoodAttached;

    @JoinColumn
    @ManyToOne
    private Show show;

}
