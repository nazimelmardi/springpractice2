package com.wup.librarystats.service;

import com.wup.librarystats.domain.entity.AuthorStats;
import com.wup.librarystats.domain.entity.BookStats;
import com.wup.librarystats.domain.persistence.AuthorStatsRepository;
import com.wup.librarystats.domain.persistence.BookStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.openapitools.model.*;

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

    public BooksOfPublisherAndAuthor getBooks(AuthorPublisherRequest request) {
        BooksOfPublisherAndAuthor model = new BooksOfPublisherAndAuthor();
        model.setNameOfAuthor(request.getAuthorName());
        model.setNumberOfBooksOfAuthor(authorStatsRepository.numberOfBooksOfAuthor(request.getAuthorName()));
        model.setNameOfPublisher(request.getPublisherName());
        model.setNumberOfBooksOfPublisher(bookStatsRepository.numberOfBooksByPublisher(request.getPublisherName()));
        return model;
    }

    public YoungestOldestBook getBooksByAge() {
        YoungestOldestBook model = new YoungestOldestBook();
        BookStats young = bookStatsRepository.findFirstByOrderByDateOfPublicationAsc();
        BookStats old = bookStatsRepository.findFirstByOrderByDateOfPublicationDesc();

        model.setYoungestBookTitle(young.getBookTitle());
        model.setYoungestBookPublicationDate(young.getDateOfPublication());
        model.setOldestBookTitle(old.getBookTitle());
        model.setOldestBookPublicationDate(old.getDateOfPublication());
        return model;
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
