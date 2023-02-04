package com.example.Book_My_Show_backend.Convertors;

import com.example.Book_My_Show_backend.Models.Movie;
import com.example.Book_My_Show_backend.Models.Theatre;
import com.example.Book_My_Show_backend.RequestDto.TheatreRequestDto;
import lombok.Data;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Data
public class TheatreConvertor {

  public  static Theatre ConvertToEntity(TheatreRequestDto theatreRequestDto){

      Theatre theatre = Theatre.builder().name(theatreRequestDto.getName()).city(theatreRequestDto.getCity()).address(theatreRequestDto.getAddress())
             .build();
      return theatre;
  }

}
