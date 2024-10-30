package com.example.demo.Controller;

import com.example.demo.DTO.JobRecordsRequestDto;
import com.example.demo.DTO.updateStatusDTO;
import com.example.demo.Model.JobRecords;
import com.example.demo.Service.JobRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobRecords")
public class JobRecordsController {
    @Autowired
    private JobRecordsService jobRecordsService;


    //api for user to apply for a job
    @PostMapping
    public String ApplyJob(@RequestBody JobRecordsRequestDto jobRecordsRequestDto) {
        jobRecordsService.ApplyJob(jobRecordsRequestDto);
        return "job applied successfully";
    }

    //api for admin to edit job status
    @PutMapping
    public String UpdateJob(@RequestBody updateStatusDTO updateStatusDTO) {
        jobRecordsService.editStatus(updateStatusDTO);
        return "job status updated successfully";
    }

    //api to return all job records
    @GetMapping("/getall")
    public List<JobRecords> retrieveAllJobRecords() {
        return jobRecordsService.retriveAllJobRecords();
    }

}
