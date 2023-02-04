package com.example.Book_My_Show_backend.Controllers;


import com.example.Book_My_Show_backend.RequestDto.TheatreRequestDto;
import com.example.Book_My_Show_backend.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity<String> createTheatre(@RequestBody TheatreRequestDto theatreRequestDto){
        theatreService.createTheatre(theatreRequestDto);
        return new ResponseEntity<>("Theatre Created Successfully", HttpStatus.CREATED);
    }

}
