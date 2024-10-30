package com.example.demo.Service;


import com.example.demo.Model.jobs;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface JobService {
    public void createJob(jobs job);
    public List<jobs> getAllJob();
    public Optional<jobs> getJobById(long id);
    public void deleteJob(long id);
//    public void updateJob(long id, String title, String description, String recruiter);
    public void addUpdateJob(Long id, String title, String description, String recruiter);
    public void patchJob(long id, Map<String, Object> updates);
}
