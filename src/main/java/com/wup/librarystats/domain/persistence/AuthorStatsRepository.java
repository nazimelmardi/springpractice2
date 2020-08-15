package com.wup.librarystats.domain.persistence;

import com.wup.librarystats.domain.entity.AuthorStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorStatsRepository extends JpaRepository<AuthorStats, UUID> {

    AuthorStats findByAuthorName(String authorName);

    @Query("select count (b) from BookStats b where b.bookTitle = :bookTitle")
    Long numberOfBooksWithTitle(String bookTitle);

    @Query("select count (b.bookStats) from AuthorStats b where b.authorName =:authorName")
    Long numberOfBooksOfAuthor(String authorName);
}
