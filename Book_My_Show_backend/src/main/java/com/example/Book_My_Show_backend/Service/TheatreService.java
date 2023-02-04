package com.example.Book_My_Show_backend.Service;

import com.example.Book_My_Show_backend.Convertors.TheatreConvertor;
import com.example.Book_My_Show_backend.Enums.SeatType;
import com.example.Book_My_Show_backend.Models.Theatre;
import com.example.Book_My_Show_backend.Models.TheatreSeat;
import com.example.Book_My_Show_backend.Repository.TheatreRepository;
import com.example.Book_My_Show_backend.Repository.TheatreSeatRepository;
import com.example.Book_My_Show_backend.RequestDto.TheatreRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService
{

    @Autowired
    TheatreSeatRepository theatreSeatRepository;
    @Autowired
    TheatreRepository theatreRepository;

    public Theatre createTheatre(TheatreRequestDto theatreRequestDto){

        Theatre theatre = TheatreConvertor.ConvertToEntity(theatreRequestDto);

        List<TheatreSeat> theatreSeatList = createTheatreSeats();
        theatre.setTheatreSeatList(theatreSeatList);

        for(TheatreSeat t:theatreSeatList){
            t.setTheatre(theatre);
        }

        theatreRepository.save(theatre);

        return theatre;

    }

    private List<TheatreSeat> createTheatreSeats(){

        List<TheatreSeat> theatreSeatList = new ArrayList<>();

//        TheatreSeat theatreSeat1 = new TheatreSeat("1A", SeatType.CLASSIC,100);
//
//        TheatreSeat theatreSeat2 = new TheatreSeat("1B", SeatType.CLASSIC,100);
//
//        TheatreSeat theatreSeat3 = new TheatreSeat("1C", SeatType.CLASSIC,100);
//
//        TheatreSeat theatreSeat4 = new TheatreSeat("1D", SeatType.CLASSIC,100);
//
//        TheatreSeat theatreSeat5 = new TheatreSeat("1E", SeatType.CLASSIC,100);
//
//        TheatreSeat theatreSeat6 = new TheatreSeat("2A",SeatType.PLATINUM,200);
//
//        TheatreSeat theatreSeat7 = new TheatreSeat("2A",SeatType.PLATINUM,200);
//
//        TheatreSeat theatreSeat8 = new TheatreSeat("2A",SeatType.PLATINUM,200);
//
//        TheatreSeat theatreSeat9 = new TheatreSeat("2A",SeatType.PLATINUM,200);
//
//        TheatreSeat theatreSeat10 = new TheatreSeat("2A",SeatType.PLATINUM,200);

      for(int i=0;i<5;i++){

          char ch =(char)('A'+i);
          String seatno = "1"+ch;
          TheatreSeat theatreSeat = new TheatreSeat(seatno,SeatType.CLASSIC,100);
          theatreSeatList.add(theatreSeat);
      }
        for(int i=0;i<5;i++){

            char ch =(char)('A'+i);
            String seatno = "2"+ch;
            TheatreSeat theatreSeat = new TheatreSeat(seatno,SeatType.PLATINUM,200);
            theatreSeatList.add(theatreSeat);
        }
        theatreSeatRepository.saveAll(theatreSeatList);
        return theatreSeatList;

    }
}
