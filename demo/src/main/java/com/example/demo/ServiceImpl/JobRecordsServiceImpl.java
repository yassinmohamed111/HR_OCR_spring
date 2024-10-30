package com.example.demo.ServiceImpl;

import com.example.demo.DTO.JobRecordsRequestDto;
import com.example.demo.DTO.updateStatusDTO;
import com.example.demo.Mapper.JobRecordMapper;
import com.example.demo.Model.JobRecords;
import com.example.demo.Service.JobRecordsService;
import com.example.demo.repository.JobRecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void editStatus(updateStatusDTO u) {
        System.out.println(u.getStatus());
        System.out.println(u.getJobRecordId());
        JobRecords jobRecords = JobRecordsRepo.findById(u.getJobRecordId()).orElseThrow();
        jobRecords.setJob_status(u.getStatus());
        JobRecordsRepo.save(jobRecords);

    }
}
