package com.example.Book_My_Show_backend.Repository;

import com.example.Book_My_Show_backend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
