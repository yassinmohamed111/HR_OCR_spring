package com.example.demo.controllers;

import com.example.demo.dto.JobRecordDto;
import com.example.demo.dto.UpdateStatusDTO;
import com.example.demo.services.JobRecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobRecords")
@CrossOrigin("*")
@RequiredArgsConstructor
public class JobRecordsController {
    private final JobRecordsService jobRecordsService;

    @GetMapping()
    public ResponseEntity<List<JobRecordDto>> getAllJobRecords() {
        return ResponseEntity.ok(jobRecordsService.getAllJobRecords());
    }

    @GetMapping("{id}")
    public ResponseEntity<JobRecordDto> getJobRecordById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        JobRecordDto jobRecordDto = jobRecordsService.getJobRecordById(id);
        return ResponseEntity.ok().body(jobRecordDto);
    }

    @PostMapping()
    public ResponseEntity<?> createJobRecord(@RequestBody JobRecordDto jobRecordDto) {
        return ResponseEntity.ok().body(jobRecordsService.createJobRecord(jobRecordDto));
    }

    @PutMapping
    public String UpdateJob(@RequestBody UpdateStatusDTO updateStatusDTO) {
        jobRecordsService.editStatus(updateStatusDTO);
        return "job status updated successfully";
    }
}
