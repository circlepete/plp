package org.circlepete.plp.repository;

import org.circlepete.plp.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
    @Query(value = "SELECT * FROM job WHERE (:title IS NULL OR title = :title) AND (:details IS NULL OR details = :details)", nativeQuery = true)
    List<Job> findBytitleAndDetails(
            @Param("title") String title,
            @Param("details") String details
    );
}
