package com.example.demo.Service;

import com.example.demo.DTO.JobRecordsRequestDto;
import com.example.demo.DTO.updateStatusDTO;

public interface JobRecordsService {
    public void ApplyJob(JobRecordsRequestDto jobRecordsRequestDto);
    public void editStatus(updateStatusDTO updateStatusDTO);
}
