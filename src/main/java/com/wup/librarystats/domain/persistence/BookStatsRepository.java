package com.wup.librarystats.domain.persistence;

import com.wup.librarystats.domain.entity.BookStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookStatsRepository extends JpaRepository<BookStats, UUID> {
}
