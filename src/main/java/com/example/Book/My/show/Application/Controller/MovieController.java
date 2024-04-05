package com.example.Book.My.show.Application.Controller;

import com.example.Book.My.show.Application.Models.Movie;
import com.example.Book.My.show.Application.Request.UpdateMovieRequest;
import com.example.Book.My.show.Application.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @PostMapping("/addmovie")
    public String addMovie(@RequestBody Movie movie){

        String response= movieService.addMovie(movie);
        return response;
    }

    @PutMapping("updateMovieAttribute")
    public String updateMovieAttribute(@RequestBody UpdateMovieRequest updateMovieRequest){
        //You have made sue that only relevant attributes
        //are expose to client

        String result = movieService.updateMovieAttribute(updateMovieRequest);
        return result;
    }
}
