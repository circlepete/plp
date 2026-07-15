package org.circlepete.plp.service;

import org.circlepete.plp.entity.Job;
import org.circlepete.plp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public Job create(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> get() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> get(UUID id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job update(UUID id, Job job) {
        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob == null) {
            return jobRepository.save(job);
        }

        existingJob.setName(job.getName());
        existingJob.setDetails(job.getDetails());

        return jobRepository.save(existingJob);
    }

    @Override
    public boolean delete(UUID id) {
        jobRepository.deleteById(id);
        return !jobRepository.existsById(id);
    }
}
