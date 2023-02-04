package com.example.Book_My_Show_backend.Service;

import com.example.Book_My_Show_backend.Convertors.ShowConvertor;
import com.example.Book_My_Show_backend.Models.*;
import com.example.Book_My_Show_backend.Repository.MovieRepository;
import com.example.Book_My_Show_backend.Repository.ShowRepository;
import com.example.Book_My_Show_backend.Repository.ShowSeatRepository;
import com.example.Book_My_Show_backend.Repository.TheatreRepository;
import com.example.Book_My_Show_backend.RequestDto.ShowRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    public Shows addShow(ShowRequestDto showRequestDto){

        Shows show = ShowConvertor.ConvertToEntity(showRequestDto);

        Movie movie = movieRepository.findByName(showRequestDto.getMovieName());
        Theatre theatre = theatreRepository.findById(showRequestDto.getTheatreId()).get();

        show.setMovie(movie);
        show.setTheatre(theatre);

        movie.getShowList().add(show);
        theatre.getShowList().add(show);

        List<ShowSeat> showSeatList = createShowSeat(theatre.getTheatreSeatList());

        show.setShowSeatList(showSeatList);


        for(ShowSeat showSeat:showSeatList){

            showSeat.setShow(show);
        }

//        showRepository.save(show);
        movieRepository.save(movie);
        theatreRepository.save(theatre);

        return show;

    }

    public List<ShowSeat> createShowSeat(List<TheatreSeat> theatreSeatList){

        List<ShowSeat> seats = new ArrayList<>();

        for(TheatreSeat theatreSeat:theatreSeatList){
             ShowSeat showSeat = ShowSeat.builder().seatno(theatreSeat.getSeatno()).seatType(theatreSeat.getSeatType()).build();
             seats.add(showSeat);
        }
        showSeatRepository.saveAll(seats);
        return seats;
    }
}
