package com.example.Book_My_Show_backend.Controllers;

import com.example.Book_My_Show_backend.RequestDto.ShowRequestDto;
import com.example.Book_My_Show_backend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowRequestDto showRequestDto){

        showService.addShow(showRequestDto);
        return  new ResponseEntity<>("Show Added Successfully", HttpStatus.CREATED);
    }


}
