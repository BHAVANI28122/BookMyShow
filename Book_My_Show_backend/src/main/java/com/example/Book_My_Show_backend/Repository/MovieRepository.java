package com.example.Book_My_Show_backend.Repository;

import com.example.Book_My_Show_backend.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    public Movie findByName(String name);
}
