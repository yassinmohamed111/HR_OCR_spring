package com.example.demo.services;


import com.example.demo.dto.JobDto;
import com.example.demo.models.jobs;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface JobService {
    List<JobDto> getAllJob();

    JobDto getJobById(long id) throws ChangeSetPersister.NotFoundException;

    void deleteJob(long id);

    void updateJob(JobDto job);
    JobDto createJob(JobDto job);
}
