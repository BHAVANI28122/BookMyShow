package com.example.Book_My_Show_backend.Convertors;

import com.example.Book_My_Show_backend.Models.Movie;
import com.example.Book_My_Show_backend.RequestDto.MovieRequestDto;

public class MovieConvertor {

    public static Movie ConvertToEntity(MovieRequestDto movieRequestDto){

        Movie movie = Movie.builder().name(movieRequestDto.getName()).
                releaseDate(movieRequestDto.getReleaseDate()).
                duration(movieRequestDto.getDuration()).build();
        return movie;

    }
}
