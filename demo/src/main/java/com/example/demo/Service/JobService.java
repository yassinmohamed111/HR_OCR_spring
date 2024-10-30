package com.example.demo.Service;


import com.example.demo.Model.jobs;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

public interface JobService {
    public void createJob(jobs job);
}
