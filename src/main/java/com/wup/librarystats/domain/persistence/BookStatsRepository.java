package com.wup.librarystats.domain.persistence;

import com.wup.librarystats.domain.entity.BookStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookStatsRepository extends JpaRepository<BookStats, UUID> {

    @Query("select count (b) from BookStats b where b.publisherName = :publisherName")
    Long numberOfBooksByPublisher(String publisherName);

    BookStats findFirstByOrderByDateOfPublicationDesc();

    BookStats findFirstByOrderByDateOfPublicationAsc();
}
