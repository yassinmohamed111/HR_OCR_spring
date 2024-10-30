package com.example.demo.Controller;

import com.example.demo.DTO.JobRecordsRequestDto;
import com.example.demo.Service.JobRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobRecords")
public class JobRecordsController {
    @Autowired
    private JobRecordsService jobRecordsService;
    @PostMapping
    public String ApplyJob(@RequestBody JobRecordsRequestDto jobRecordsRequestDto) {
        jobRecordsService.ApplyJob(jobRecordsRequestDto);
        return "job applied successfully";
    }
}
