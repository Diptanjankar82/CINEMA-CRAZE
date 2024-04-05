package com.example.Book.My.show.Application.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTheaterRequest {
    private String name;

    private String address;

    private Integer noOfScreens;
}
