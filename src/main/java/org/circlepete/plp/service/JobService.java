package org.circlepete.plp.service;

import org.circlepete.plp.entity.Job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JobService {

    Job create(Job job);

    List<Job> get();

    Optional<Job> get(UUID id);

    Job update(UUID id, Job job);

    boolean delete(UUID id);
}
