package com.example.demo.ServiceImpl;

import com.example.demo.Model.jobs;
import com.example.demo.Service.JobService;
import com.example.demo.repository.JobRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    final private JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public void createJob( @RequestBody jobs job) {
        jobRepo.save(job);
    }

    @Override
    public List<jobs> getAllJob() {
        return jobRepo.findAll();
    }

    @Override
    public Optional<jobs> getJobById(long id) {
        return jobRepo.findById(id);
    }

    @Override
    public void deleteJob(long id) {
        boolean exists = jobRepo.existsById(id);
        if (exists) {
            jobRepo.deleteById(id);
        }else {
            System.out.println("Job not found");
        }
    }

//    @Transactional
//    @Override
//    public void updateJob(long id, String title, String description, String recruiter) {
//        jobs job = jobRepo.findById(id).orElseThrow(()-> new IllegalStateException("Job not found"));
//        if (title != null && !title.isEmpty() && !Objects.equals(title, job.getTitle())) {
//            job.setTitle(title);
//        }
//        if (description != null && !description.isEmpty() && !Objects.equals(description, job.getDescription())) {
//            job.setDescription(description);
//        }
//        if (recruiter != null && !recruiter.isEmpty() && !Objects.equals(recruiter, job.getRecruiter())) {
//            job.setRecruiter(recruiter);
//        }
//        jobRepo.save(job);
//    }

    @Override
    public void patchJob(long id, Map<String, Object> updates) {
        jobRepo.findById(id).ifPresent(job -> {
            if (updates.containsKey("title")) {
                job.setTitle((String) updates.get("title"));
            }
            if (updates.containsKey("description")) {
                job.setDescription((String) updates.get("description"));
            }
            if (updates.containsKey("requirements")) {
                job.setRequirements((String) updates.get("requirements"));
            }
            if (updates.containsKey("recruiter")) {
                job.setRecruiter((String) updates.get("recruiter"));
            }

            jobRepo.save(job);
        });
    }

    @Transactional
    @Override
    public void addUpdateJob(Long id, String title, String description, String recruiter) {
        jobs job = jobRepo.findById(id).orElseGet(jobs::new);

        if (title != null && !title.isEmpty() && !Objects.equals(title, job.getTitle())) {
            job.setTitle(title);
        }
        if (description != null && !description.isEmpty() && !Objects.equals(description, job.getDescription())) {
            job.setDescription(description);
        }
        if (recruiter != null && !recruiter.isEmpty() && !Objects.equals(recruiter, job.getRecruiter())) {
            job.setRecruiter(recruiter);
        }

        jobRepo.save(job);
    }

}
