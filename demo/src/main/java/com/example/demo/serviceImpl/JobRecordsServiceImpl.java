package com.example.demo.serviceImpl;

import com.example.demo.dto.JobRecordDto;
import com.example.demo.dto.UpdateStatusDTO;
import com.example.demo.mapper.JobRecordMapper;
import com.example.demo.models.JobRecords;
import com.example.demo.repository.JobRecordsRepo;
import com.example.demo.services.JobRecordsService;
import com.example.demo.utils.DTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobRecordsServiceImpl implements JobRecordsService {
    final private JobRecordsRepo jobRecordsRepo;
    final private JobRecordMapper JobRecordMapper;


    @Override
    public List<JobRecordDto> getAllJobRecords() {
        return jobRecordsRepo.findAll().stream().map(e -> DTOConverter.convertToEntity(e, JobRecordDto.class)).toList();
    }

    @Override
    public JobRecordDto getJobRecordById(long id) throws ChangeSetPersister.NotFoundException {
        Optional<JobRecords> jobRecords = jobRecordsRepo.findById(id);
        if (jobRecords.isPresent()) {
            return DTOConverter.convertToEntity(jobRecords.get(), JobRecordDto.class);
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    @Override
    public JobRecordDto createJobRecord(@RequestBody JobRecordDto jobRecord) {
        return DTOConverter.convertToEntity(jobRecordsRepo.save(DTOConverter.convertToEntity(jobRecord, JobRecords.class)), JobRecordDto.class);
    }

    @Override
    public void updateJobRecord(JobRecordDto jobRecord) {

    }

    @Override
    public void editStatus(UpdateStatusDTO u) {
        System.out.println(u.getStatus());
        System.out.println(u.getJobRecordId());

        JobRecords jobRecords = jobRecordsRepo.findById(u.getJobRecordId()).orElseThrow();
        jobRecords.setJob_status(u.getStatus());
        jobRecordsRepo.save(jobRecords);

    }
}
