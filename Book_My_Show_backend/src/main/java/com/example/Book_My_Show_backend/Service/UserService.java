package com.example.Book_My_Show_backend.Service;

import com.example.Book_My_Show_backend.Convertors.UserConvertor;
import com.example.Book_My_Show_backend.Models.User;
import com.example.Book_My_Show_backend.Repository.UserRepository;
import com.example.Book_My_Show_backend.RequestDto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(UserRequestDto userRequestDto){

        User user = UserConvertor.ConvertToEntity(userRequestDto);
        userRepository.save(user);
        return user;
    }

}
