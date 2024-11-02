package com.example.demo.config;

import com.example.demo.models.jobs;
import com.example.demo.repository.JobRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class SeedDataLoader  {

    @Bean
    CommandLineRunner loadJobsData(JobRepo jobsRepository) {
        return args -> {
            if (jobsRepository.count() == 0) {
                jobs job1 = new jobs(null, "Software Engineer", "Develop and maintain software solutions.", "Java, Spring Boot, SQL", "TechCorp", null);
                jobs job2 = new jobs(null, "Data Analyst", "Analyze and interpret complex data sets.", "Python, SQL, Data Visualization", "DataInsights", null);

                jobsRepository.save(job1);
                jobsRepository.save(job2);
            }
        };
    }
}