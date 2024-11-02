package com.example.demo.services;

import com.example.demo.dto.JobRecordsRequestDto;
import com.example.demo.dto.UpdateStatusDTO;
import com.example.demo.models.JobRecords;

import java.util.List;

public interface JobRecordsService {
    public void ApplyJob(JobRecordsRequestDto jobRecordsRequestDto);
    public void editStatus(UpdateStatusDTO updateStatusDTO);
    public List<JobRecords> retriveAllJobRecords();
}
