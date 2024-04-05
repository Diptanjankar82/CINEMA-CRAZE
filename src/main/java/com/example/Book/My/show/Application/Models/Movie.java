package com.example.Book.My.show.Application.Models;

import com.example.Book.My.show.Application.Enums.Genre;
import com.example.Book.My.show.Application.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(unique = true)
    private String movieName;

    private double duration;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private LocalDate releaseDate;

    private double rating;

    private Language language;

}
