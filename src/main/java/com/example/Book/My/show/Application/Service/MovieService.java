package com.example.Book.My.show.Application.Service;

import com.example.Book.My.show.Application.Models.Movie;
import com.example.Book.My.show.Application.Repository.MovieRepository;
import com.example.Book.My.show.Application.Request.UpdateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(Movie movie){

        movie = movieRepository.save(movie);
        return "The Movie added sucessfully to the DB"+movie.getMovieId();
    }

    public String updateMovieAttribute(UpdateMovieRequest updateMovieRequest){
        Movie movie = movieRepository.findById(updateMovieRequest.getMovieId()).get();

        double rating = updateMovieRequest.getRating();
        double duration = updateMovieRequest.getDuration();

        movie.setDuration(duration);
        movie.setRating(rating);
        movieRepository.save(movie);
        return "Attributes are modified";
    }
}
