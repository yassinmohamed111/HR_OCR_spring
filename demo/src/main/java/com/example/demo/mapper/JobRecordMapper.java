package com.example.demo.mapper;

import com.example.demo.dto.JobRecordDto;
import com.example.demo.dto.JobRecordsRequestDto;
import com.example.demo.models.JobRecords;
import com.example.demo.repository.JobRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobRecordMapper {
    public JobRecords mapper(JobRecordDto source, JobRecords target) {
        target.setJob_status(source.getJob_status());
        target.setDate(source.getDate());
        return target;
    }
}
