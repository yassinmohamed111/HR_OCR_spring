package com.example.demo.services;

import com.example.demo.dto.JobRecordDto;
import com.example.demo.dto.JobRecordsRequestDto;
import com.example.demo.dto.UpdateStatusDTO;
import com.example.demo.dto.UserJobLinkDto;
import com.example.demo.models.JobRecords;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface JobRecordsService {
    List<JobRecordDto> getAllJobRecords();
    JobRecordDto getJobRecordById(long id) throws ChangeSetPersister.NotFoundException;
    JobRecordDto createJobRecord(JobRecordDto jobRecord);
//    void editStatus(UpdateStatusDTO updateStatusDTO);
    void updateJobRecord(JobRecordDto jobRecord);

    void editStatus(UpdateStatusDTO updateStatusDTO);

    void createJobRecord(@RequestBody UserJobLinkDto userJobLinkDto);
}
