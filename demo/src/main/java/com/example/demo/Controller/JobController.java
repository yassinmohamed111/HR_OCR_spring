package com.example.demo.Controller;

import com.example.demo.Model.jobs;
import com.example.demo.Service.JobService;
import com.example.demo.ServiceImpl.JobServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/job")
public class JobController {
    final private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @PostMapping
    public String CreateJob(jobs job){
        jobService.createJob(job);
        return "Job created";
    }
}
