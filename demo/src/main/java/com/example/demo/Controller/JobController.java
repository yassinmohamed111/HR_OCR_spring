package com.example.demo.Controller;

import com.example.demo.Model.jobs;
import com.example.demo.Service.JobService;
import com.example.demo.ServiceImpl.JobServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/job")
public class JobController {
    final private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
//
    @GetMapping()
    public List<jobs> getAllJobs(){
        return jobService.getAllJob();
    }

    @GetMapping("{id}")
    public Optional<jobs> getJobById(@PathVariable long id){
        return jobService.getJobById(id);
    }
//
    @PostMapping
    public String createJob(@RequestBody jobs job){
        jobService.createJob(job);
        return "Job created";
    }

    @PostMapping("s")
    public String createJobs(@RequestBody List<jobs> jobsList) {
        for (jobs job : jobsList) {
            jobService.createJob(job);
        }
        return "Jobs created";
    }
// commented functions require fixing
//
//    @PostMapping("upsert/{id}")
//    public void addUpdateJob(@PathVariable Long id, @RequestBody jobs job){
//        jobService.addUpdateJob(id, job.getTitle(), job.getDescription(), job.getRecruiter());
//    }

//    @PutMapping("{id}")
//    public void updateJob(@PathVariable long id,
//                              @RequestParam(required = false) String title,
//                              @RequestParam(required = false) String description,
//                              @RequestParam(required = false) String recruiter){
//        jobService.updateJob(id, title, description, recruiter);
//    }

    //update column with out too much json hustle
//    aka { "z": new z } instead of {"x": x, "Y": y, "Z": new z}
    @PatchMapping("{id}")
    public void patchJob(@PathVariable long id, @RequestBody Map<String, Object> updatedJob){
        jobService.patchJob(id, updatedJob);
    }

    @DeleteMapping("{id}")
    public String deleteJob(@PathVariable long id){
        jobService.deleteJob(id);
        return "Job deleted";
    }



}
