package com.example.demo.mapper;

import com.example.demo.dto.JobDto;
import com.example.demo.models.Users;
import com.example.demo.models.jobs;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {
    public jobs mapper(JobDto source, jobs target) {
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setRecruiter(source.getRecruiter());
        target.setRequirements(source.getRequirements());
        return target;
    }
}
