package com.wup.librarystats.adapter;

import com.wup.librarystats.service.LibraryStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.openapitools.model.*;

@Service
@RequiredArgsConstructor
public class LibraryStatsAdapter {

    private final LibraryStatsService libraryStatsService;

    public StatInfoForPort addNewBookInfo(StatInfoForPort statInfoForPort) {
        return null;
    }

    public BooksOfPublisherAndAuthor getNumberOfBooksByAuthorAndPublisher(AuthorPublisherRequest request) {
        return libraryStatsService.getBooks(request);
    }

    public YoungestOldestBook getYoungestAndOldestBook() {
        return libraryStatsService.getBooksByAge();
    }
}
