package com.example.Book_My_Show_backend.Models;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String name;

    private Date releaseDate;

    private int duration;


    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private  List<Shows> showList;

}
