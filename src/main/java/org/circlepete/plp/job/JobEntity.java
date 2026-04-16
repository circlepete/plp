package org.circlepete.plp.job;

import java.util.UUID;

public record JobEntity(
        UUID id,
        String name,
        String details
) {
}
