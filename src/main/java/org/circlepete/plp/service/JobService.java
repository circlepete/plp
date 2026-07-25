package org.circlepete.plp.service;

import org.circlepete.plp.dto.JobRequest;
import org.circlepete.plp.dto.JobResponse;

import java.util.List;
import java.util.UUID;

public interface JobService {

    JobResponse create(JobRequest job);

    List<JobResponse> get();

    JobResponse get(UUID id);

    JobResponse update(UUID id, JobRequest job);

    boolean delete(UUID id);
}
