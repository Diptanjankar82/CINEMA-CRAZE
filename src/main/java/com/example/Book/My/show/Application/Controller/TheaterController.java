package com.example.Book.My.show.Application.Controller;

import com.example.Book.My.show.Application.Request.AddTheaterRequest;
import com.example.Book.My.show.Application.Request.AddTheaterSeatRequest;
import com.example.Book.My.show.Application.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;
    @PostMapping("/addtheater")
    public String addTheater (@RequestBody AddTheaterRequest addTheaterRequest){

        String result = theaterService.addTheater(addTheaterRequest);
        return result;
    }

    //Add TheaterSeat

    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody AddTheaterSeatRequest addTheaterSeatRequest){

        String result = theaterService.addTheaterSeats(addTheaterSeatRequest);
        return result;
    }
}
