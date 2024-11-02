package com.example.demo.controllers;

import com.example.demo.dto.JobDto;
import com.example.demo.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/job")
@CrossOrigin("*")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping()
    public ResponseEntity<List<JobDto>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJob());
    }

    @GetMapping("{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        JobDto job = jobService.getJobById(id);
        return ResponseEntity.ok().body(job);
    }

    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody JobDto job) {
        return ResponseEntity.ok().body(jobService.createJob(job));
    }

    @PutMapping()
    public ResponseEntity<?> updateJob(@RequestBody JobDto jobs) {
        jobService.updateJob(jobs);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteJob(@PathVariable long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok().build();
    }
}
