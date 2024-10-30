package com.example.demo.Service;


import com.example.demo.Model.jobs;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.List;

public interface JobService {
    public void createJob(jobs job);
    public List<jobs> getAllJob();

}
