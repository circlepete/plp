package org.circlepete.plp.controller;

import org.circlepete.plp.dto.JobRequest;
import org.circlepete.plp.dto.JobResponse;
import org.circlepete.plp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping("/job")
    public ResponseEntity<JobResponse> create(@RequestBody JobRequest request) {
        return ResponseEntity.ok(jobService.create(request));
    }

    @GetMapping("/job")
    public ResponseEntity<List<JobResponse>> get(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "details", required = false) String details
    ) {
        return ResponseEntity.status(200).body(jobService.get(title, details));
    }

    @PutMapping("/job/{id}")
    public ResponseEntity<JobResponse> update(@PathVariable UUID id,
                                              @RequestBody JobRequest request) {
        return ResponseEntity.ok(jobService.update(id, request));
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(jobService.delete(id));
    }
}
