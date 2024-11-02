package com.example.demo.serviceImpl;

import com.example.demo.dto.JobRecordsRequestDto;
import com.example.demo.dto.UpdateStatusDTO;
import com.example.demo.mapper.JobRecordMapper;
import com.example.demo.models.JobRecords;
import com.example.demo.services.JobRecordsService;
import com.example.demo.repository.JobRecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobRecordsServiceImpl implements JobRecordsService {
    @Autowired
    JobRecordsRepo JobRecordsRepo;
    @Autowired
    JobRecordMapper JobRecordMapper;
    @Override
    public void ApplyJob(JobRecordsRequestDto jobRecordsRequestDto) {
        JobRecords JobRecords = JobRecordMapper.ToEntityJobRecords(jobRecordsRequestDto);
        JobRecordsRepo.save(JobRecords);
    }

    @Override
    public void editStatus(UpdateStatusDTO u) {
        System.out.println(u.getStatus());
        System.out.println(u.getJobRecordId());
        JobRecords jobRecords = JobRecordsRepo.findById(u.getJobRecordId()).orElseThrow();
        jobRecords.setJob_status(u.getStatus());
        JobRecordsRepo.save(jobRecords);

    }

    @Override
    public List<JobRecords> retriveAllJobRecords() {
        return JobRecordsRepo.findAll();
    }
}
