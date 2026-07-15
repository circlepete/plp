package org.circlepete.plp.controller;

import org.circlepete.plp.entity.Job;
import org.circlepete.plp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping("/job")
    public ResponseEntity<Job> create(@RequestBody Job request) {
        return ResponseEntity.ok(jobService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<Job>> get() {
        return ResponseEntity.status(200).body(jobService.get());
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Optional<Job>> get(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(jobService.get(id));
    }

    @PutMapping("/job/{id}")
    public ResponseEntity<Job> update(@PathVariable UUID id,
                                      @RequestBody Job request) {
        return ResponseEntity.ok(jobService.update(id, request));
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(jobService.delete(id));
    }
}
