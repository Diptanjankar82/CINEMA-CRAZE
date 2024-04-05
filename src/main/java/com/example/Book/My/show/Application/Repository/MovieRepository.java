package com.example.Book.My.show.Application.Repository;

import com.example.Book.My.show.Application.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie , Integer> {
}
