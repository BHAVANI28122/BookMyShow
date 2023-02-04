package com.example.Book_My_Show_backend.Convertors;

import com.example.Book_My_Show_backend.Models.User;
import com.example.Book_My_Show_backend.RequestDto.UserRequestDto;
import lombok.Builder;
import lombok.Data;

@Data
public class UserConvertor {


    public static User ConvertToEntity(UserRequestDto userRequestDto){

        User user = User.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();
        return user;
    }
}
