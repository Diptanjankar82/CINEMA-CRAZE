package com.example.Book.My.show.Application.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTheaterSeatRequest {

    private Integer noOfClassicSeat;

    private Integer noOfPremiumSeat;

    private Integer theaterId;
}
