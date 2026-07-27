package org.circlepete.plp.service;

import jakarta.transaction.Transactional;
import org.circlepete.plp.dto.JobResponse;
import org.circlepete.plp.entity.Job;
import org.circlepete.plp.dto.JobRequest;
import org.circlepete.plp.mapper.JobMapper;
import org.circlepete.plp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    JobMapper mapper;

    @Override
    @Transactional
    public JobResponse create(JobRequest request) {
        Job job = mapper.toJob(request);

        jobRepository.save(job);

        return mapper.toResponse(job);
    }

    @Override
    public List<JobResponse> get(String title, String details) {
        List<Job> jobs = jobRepository.findBytitleAndDetails(title, details);

        return jobs.stream()
                .map(job -> mapper.toResponse(job))
                .toList();
    }

    @Override
    public JobResponse update(UUID id, JobRequest request) {
        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob == null) {
            Job newJob = mapper.toJob(request);
            jobRepository.save(newJob);

            // TODO replace with proper response
            return mapper.toResponse(newJob);
        }

        existingJob = mapper.toJob(request);
        jobRepository.save(existingJob);

        // TODO replace with proper response
        return mapper.toResponse(existingJob);
    }

    @Override
    public boolean delete(UUID id) {
        jobRepository.deleteById(id);
        return !jobRepository.existsById(id);
    }
}
