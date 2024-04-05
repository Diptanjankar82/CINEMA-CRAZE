package com.example.Book.My.show.Application.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder // Using for creating an object of Theater Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "theaters")
public class Theater {
    @Id
    private Integer theaterId;

    private String name;

    private String address;

    private Integer noOfScreens;

}
