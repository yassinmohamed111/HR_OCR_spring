package com.example.demo.ServiceImpl;

import com.example.demo.Model.jobs;
import com.example.demo.Service.JobService;
import com.example.demo.repository.JobRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class JobServiceImpl implements JobService {

    final private JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public void createJob( @RequestBody jobs job) {
        jobRepo.save(job);
    }
}
