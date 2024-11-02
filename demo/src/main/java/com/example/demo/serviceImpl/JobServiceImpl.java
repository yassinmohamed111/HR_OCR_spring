package com.example.demo.serviceImpl;

import com.example.demo.dto.JobDto;
import com.example.demo.mapper.JobMapper;
import com.example.demo.models.jobs;
import com.example.demo.repository.JobRepo;
import com.example.demo.services.JobService;
import com.example.demo.utils.DTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    final private JobRepo jobRepo;
    final private JobMapper jobMapper;

    @Override
    public JobDto createJob(@RequestBody JobDto job) {
        return DTOConverter.convertToEntity(jobRepo.save(DTOConverter.convertToEntity(job, jobs.class)), JobDto.class);
    }

    @Override
    public List<JobDto> getAllJob() {
        return jobRepo.findAll().stream().map(e -> DTOConverter.convertToEntity(e, JobDto.class)).toList();
    }

    @Override
    public JobDto getJobById(long id) throws ChangeSetPersister.NotFoundException {
        Optional<jobs> job = jobRepo.findById(id);
        if (job.isPresent()) {
            return DTOConverter.convertToEntity(job.get(), JobDto.class);
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    @Override
    public void deleteJob(long id) {
        boolean exists = jobRepo.existsById(id);
        if (exists) {
            jobRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("not found");
        }
    }

    @Override
    public void updateJob(JobDto jobDto) {
        jobs jobs = jobRepo.findById(jobDto.getId()).orElse(null);
        if (jobs != null) {
            jobRepo.save(jobMapper.mapper(jobDto, jobs));
        } else {
            throw new IllegalArgumentException("not found");
        }
    }
}
