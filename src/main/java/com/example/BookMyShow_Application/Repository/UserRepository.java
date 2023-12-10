package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
