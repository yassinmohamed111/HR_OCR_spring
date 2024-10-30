package com.example.demo.repository;

import com.example.demo.Model.JobRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRecordsRepo extends JpaRepository<JobRecords, Long> {
}