package com.example.Book.My.show.Application.Service;

import com.example.Book.My.show.Application.Enums.SeatType;
import com.example.Book.My.show.Application.Models.Theater;
import com.example.Book.My.show.Application.Models.TheaterSeat;
import com.example.Book.My.show.Application.Repository.TheaterRepository;
import com.example.Book.My.show.Application.Repository.TheaterSeatRepository;
import com.example.Book.My.show.Application.Request.AddTheaterRequest;
import com.example.Book.My.show.Application.Request.AddTheaterSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatRepository theaterSeatRepository;
    public String addTheater(AddTheaterRequest addTheaterRequest){

        //Convert this AddRequest to an Entity

        //how we can do this
        //Use a Constructor to create an object: Generally constructors
        //are not available
//
//        Theater theater = new Theater();
//        theater.setName(addTheaterRequest.getName());
//        theater.setAddress(addTheaterRequest.getAddress());
//        theater.setNoOfScreens(addTheaterRequest.getNoOfScreens());


        //Another way to build Object
        Theater theater = Theater.builder().address(addTheaterRequest.getAddress())
                .noOfScreens(addTheaterRequest.getNoOfScreens())
                .name(addTheaterRequest.getName())
                .build();

        theater = theaterRepository.save(theater);
        return "theatorRepo added"+theater.getTheaterId();
    }

    public String addTheaterSeats(AddTheaterSeatRequest addTheaterSeatRequest){
        int noOfClassicSeat = addTheaterSeatRequest.getNoOfClassicSeat();
        int noOfPremiumSeat = addTheaterSeatRequest.getNoOfPremiumSeat();

        Integer theaterId = addTheaterSeatRequest.getNoOfClassicSeat();
        Theater theater = theaterRepository.findById(theaterId).get();

        int classicSeatCounter = 0;

        char ch = 'A';
        int RowNo =1;


        List<TheaterSeat> theaterSeatList = new ArrayList<>();
        while (classicSeatCounter<noOfClassicSeat){


            String seatNo = RowNo+ch+"";
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
            //ch = (char)(ch-'A'+1);//incrementing the charcter by 1

            ch++;
            if(classicSeatCounter%5 == 0){
                RowNo = RowNo+1;
                ch ='A';
            }

            classicSeatCounter++;
        }

        int PremiumSeatCounter = 0;

        ch = 'A';
        RowNo =RowNo+1;

        while (classicSeatCounter<noOfClassicSeat){


            String seatNo = RowNo+ch+"";
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
            //ch = (char)(ch-'A'+1);//incrementing the charcter by 1
            ch++;
            if(PremiumSeatCounter%5 == 0){
                RowNo = RowNo+1;
                ch ='A';
            }
            PremiumSeatCounter++;
        }
theaterSeatRepository.saveAll(theaterSeatList);
        return "theater Seats have been generated";
    }
}
