package com.example.demo.Controller;

import com.example.demo.Model.jobs;
import com.example.demo.Service.JobService;
import com.example.demo.ServiceImpl.JobServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/job")
public class JobController {
    final private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @PostMapping
    public String CreateJob( @RequestBody jobs job){
        jobService.createJob(job);
        return "Job created";
    }
}
