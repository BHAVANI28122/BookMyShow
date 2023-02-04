package com.example.Book_My_Show_backend.Repository;

import com.example.Book_My_Show_backend.Models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Shows,Integer> {
}
