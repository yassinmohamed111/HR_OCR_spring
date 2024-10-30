package com.example.demo.Service;

import com.example.demo.DTO.JobRecordsRequestDto;
import com.example.demo.DTO.JobrecordResponseDTO;
import com.example.demo.DTO.updateStatusDTO;
import com.example.demo.Model.JobRecords;

import java.util.List;

public interface JobRecordsService {
    public void ApplyJob(JobRecordsRequestDto jobRecordsRequestDto);
    public void editStatus(updateStatusDTO updateStatusDTO);
    public List<JobRecords> retriveAllJobRecords();
}
