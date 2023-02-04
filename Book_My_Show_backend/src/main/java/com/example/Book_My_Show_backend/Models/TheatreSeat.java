package com.example.Book_My_Show_backend.Models;

import com.example.Book_My_Show_backend.Enums.SeatType;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheatreSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String seatno;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private int rate;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;

    public TheatreSeat(String seatno, SeatType seatType, int rate) {
        this.seatno = seatno;
        this.seatType = seatType;
        this.rate = rate;
    }
}
