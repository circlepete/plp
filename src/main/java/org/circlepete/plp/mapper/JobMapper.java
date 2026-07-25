package org.circlepete.plp.mapper;

import org.circlepete.plp.dto.JobRequest;
import org.circlepete.plp.dto.JobResponse;
import org.circlepete.plp.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface JobMapper {
    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    Job toJob(JobRequest request);

    JobResponse toResponse(Job job);
}
