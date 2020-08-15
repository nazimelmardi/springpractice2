package com.wup.librarystats.service;

import com.wup.librarystats.domain.entity.AuthorStats;
import com.wup.librarystats.domain.entity.BookStats;
import com.wup.librarystats.domain.persistence.AuthorStatsRepository;
import com.wup.librarystats.domain.persistence.BookStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LibraryStatsService {

    private final BookStatsRepository bookStatsRepository;
    private final AuthorStatsRepository authorStatsRepository;

    @Transactional
    public PersistedAuthorStats addNewBookStats(BookStats bookStats, String authorName) {
        AuthorStats authorStats = authorStatsRepository.findByAuthorName(authorName);
        authorStats.addBookStats(bookStats);
        return new PersistedAuthorStats(authorStatsRepository.save(authorStats));
    }

    public class PersistedAuthorStats {
        private AuthorStats authorStats;

        public PersistedAuthorStats(AuthorStats authorStats) {
            this.authorStats = authorStats;
        }

        public AuthorStats data() {
            return this.authorStats;
        }

    }
}
