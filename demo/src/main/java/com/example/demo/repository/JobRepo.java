package com.example.demo.repository;

import com.example.demo.Model.jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JobRepo extends JpaRepository<jobs, Long> {
}
