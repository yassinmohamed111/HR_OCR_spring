package com.example.demo.mapper;

import com.example.demo.dto.JobRecordsRequestDto;
import com.example.demo.models.JobRecords;
import com.example.demo.repository.JobRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobRecordMapper {
    @Autowired
    JobRepo jobRepo;
    @Autowired
    UserRepo userRepo;
    public  JobRecords ToEntityJobRecords(JobRecordsRequestDto jobRecordsDto){
        JobRecords jobRecords = new JobRecords();

        jobRecords.setJob(jobRepo.findById(jobRecordsDto.getJobId()).get());
        jobRecords.setUser(userRepo.findByEmail(jobRecordsDto.getUserEmail()));
        return jobRecords;
    }
}
