package org.circlepete.plp.mapper;

import org.circlepete.plp.dto.JobRequest;
import org.circlepete.plp.entity.Job;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JobMapperImpl.class)
public class JobMapperTest {

    @Autowired
    JobMapper mapper;

    @Test
    public void shouldMapFromRequestToJob() {
        // given
        JobRequest request = new JobRequest("some name", "some details");

        // when
        Job result = mapper.toJob(request);

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(request.title()).isEqualTo(result.getTitle());
            softAssertions.assertThat(request.details()).isEqualTo(result.getDetails());
            softAssertions.assertThat(result.getId()).isNotNull();
        });
    }
}
