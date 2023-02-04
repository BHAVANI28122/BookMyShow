package com.example.Book_My_Show_backend.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String address;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<TheatreSeat> theatreSeatList;
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<Shows> showList;

}
