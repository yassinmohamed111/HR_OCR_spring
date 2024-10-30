package com.example.demo.Controller;

import com.example.demo.Model.jobs;
import com.example.demo.Service.JobService;
import com.example.demo.ServiceImpl.JobServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job")
public class JobController {
    final private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public List<jobs> getAllJobs(){
        return jobService.getAllJob();
    }

    @PostMapping("")
    public String createJob(@RequestBody jobs job){
        jobService.createJob(job);
        return "Job created";
    }

//    @DeleteMapping("{id}")
//    public String deleteJob(@PathVariable long id){
//        jobService.deleteJobById(id);
//        return "Job deleted";
//    }

}
