package com.example.Book_My_Show_backend.Service;

import com.example.Book_My_Show_backend.Convertors.MovieConvertor;
import com.example.Book_My_Show_backend.Models.Movie;
import com.example.Book_My_Show_backend.Repository.MovieRepository;
import com.example.Book_My_Show_backend.RequestDto.MovieRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public Movie addMovie(MovieRequestDto movieRequestDto){

        Movie movie = MovieConvertor.ConvertToEntity(movieRequestDto);
        movieRepository.save(movie);
        return movie;
    }
}
