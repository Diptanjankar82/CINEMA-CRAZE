package com.example.Book.My.show.Application.Models;

import com.example.Book.My.show.Application.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theater Seats")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeat {

    @Id
    private Integer theaterSeatId;

    private String seatNo;

    private SeatType seatType;

    @JoinColumn
    @ManyToOne // here qst we need to write in which class we are in That write FIRST then
               //parent class Object
    private Theater theater;
}
