package com.example.Book_My_Show_backend.Service;

import com.example.Book_My_Show_backend.Models.Shows;
import com.example.Book_My_Show_backend.Models.ShowSeat;
import com.example.Book_My_Show_backend.Models.Ticket;
import com.example.Book_My_Show_backend.Models.User;
import com.example.Book_My_Show_backend.Repository.ShowRepository;
import com.example.Book_My_Show_backend.Repository.TicketRepository;
import com.example.Book_My_Show_backend.Repository.UserRepository;
import com.example.Book_My_Show_backend.RequestDto.BookTicketRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String bookTicket(BookTicketRequestDto bookTicketRequestDto) throws Exception{


        List<String> requestedSeats = bookTicketRequestDto.getRequestedSeats();

        Shows show = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        User user = userRepository.findById(bookTicketRequestDto.getUserId()).get();

        List<ShowSeat> showSeatList = show.getShowSeatList();

        List<ShowSeat> bookedSeats = new ArrayList<>();

        for(ShowSeat s:showSeatList){

            String seatno = s.getSeatno();

            if(s.isBooked()== false && requestedSeats.contains(seatno)){
                bookedSeats.add(s);
            }
        }
        if(bookedSeats.size() != requestedSeats.size()){
            throw new Exception("Requested Seats not available");
        }


        double totalamount = 0;
        double multiplier = show.getMultiplier();

        String allotedSeats = "";

        int rate = 0;




        Ticket ticket = new Ticket();

         for(ShowSeat s :bookedSeats){

             s.setBooked(true);
             s.setBookedAt(new Date());
             s.setTicket(ticket);
             s.setShow(show);


             String seatno = s.getSeatno();

             allotedSeats = allotedSeats + seatno +",";

             if(seatno.charAt(0)== '1'){
                 rate =100;
             }
             else{
                 rate = 200;
             }
             totalamount = totalamount + multiplier * rate;

         }
         ticket.setBookedAt(new Date());
         ticket.setShow(show);
         ticket.setUser(user);
         ticket.setAmount((int) totalamount);
         ticket.setBookedSeats(bookedSeats);
         ticket.setAllotedSeats(allotedSeats);


         ticketRepository.save(ticket);
         return  "Tickets booked Successfully";

    }


}
