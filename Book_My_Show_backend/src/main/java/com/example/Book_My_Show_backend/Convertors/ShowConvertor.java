package com.example.Book_My_Show_backend.Convertors;

import com.example.Book_My_Show_backend.Models.Shows;
import com.example.Book_My_Show_backend.RequestDto.ShowRequestDto;
import lombok.Data;

@Data
public class ShowConvertor {

    public static Shows ConvertToEntity(ShowRequestDto showRequestDto){

        Shows show = Shows.builder().showDate(showRequestDto.getShowDate()).showTime(showRequestDto.getShowTime()).multiplier(showRequestDto.getMultiplier()).build();
        return show;

    }
}
