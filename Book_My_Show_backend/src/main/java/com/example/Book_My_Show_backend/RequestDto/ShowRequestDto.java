package com.example.Book_My_Show_backend.RequestDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class ShowRequestDto {

    private LocalDate showDate;
    private LocalTime showTime;

    private double multiplier;

    private String movieName;

    private int theatreId;

}
