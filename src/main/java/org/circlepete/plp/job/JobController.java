package org.circlepete.plp.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
public class JobController {

    JobRepository jobRepository;

    // create resource
    @PostMapping("/jobs")
    public String save(JobEntity job) {
        log.info("saving job");
        String response = jobRepository.save(job);
        return response;
    }

    // read all resources
    @GetMapping("/jobs")
    public List<JobEntity> getJobs() {
        log.info("fetching all jobs");
        List<JobEntity> jobs = jobRepository.getAllJobs();
        return jobs;
    }

    // read single resource
    @GetMapping("/jobs/{id}")
    public String getJob(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);
        log.info("fetching job id: " + uuid);
        String response = jobRepository.getJob(uuid);
        return response;
    }

    // update resource
    @PutMapping("/jobs/{id}")
    public String update(@PathVariable("id") String id, JobEntity job) {
        UUID uuid = UUID.fromString(id);
        log.info("updating job id: " + uuid);
        String response = jobRepository.updateJobInDb(job);
        return response;
    }

    // delete all resources
    @DeleteMapping("/jobs")
    public String delete() {
        log.info("deleting all jobs");
        String response = jobRepository.deleteAllJobsInDb(job);
        return response;
    }

    // delete single resource
    @DeleteMapping("/jobs/{id}")
    public String delete(@PathVariable("id") String id, JobEntity job) {
        UUID uuid = UUID.fromString(id);
        log.info("deleting job id: " + uuid);
        String response = jobRepository.deleteJobInDb(job);
        return response;
    }
}
