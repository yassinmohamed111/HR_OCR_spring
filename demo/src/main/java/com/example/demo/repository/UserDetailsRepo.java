package com.example.demo.repository;

import com.example.demo.models.user_details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<user_details, Long> {
}
