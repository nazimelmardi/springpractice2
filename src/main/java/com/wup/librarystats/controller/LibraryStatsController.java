package com.wup.librarystats.controller;


import com.wup.librarystats.adapter.LibraryStatsAdapter;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.BooksOfPublisherAndAuthor;
import org.openapitools.model.StatInfoForPort;
import org.openapitools.model.YoungestOldestBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LibraryStatsController implements org.openapitools.api.LibraryStatsApi {

    private final LibraryStatsAdapter libraryStatsAdapter;

    @Override
    public ResponseEntity<StatInfoForPort> addNewBookInfo(@Valid StatInfoForPort statInfoForPort) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryStatsAdapter.addNewBookInfo(statInfoForPort));
    }

    @Override
    public ResponseEntity<BooksOfPublisherAndAuthor> getBooksByAuthorAndPublisher(@Valid org.openapitools.model.AuthorPublisherRequest authorPublisherRequest) {
        return ResponseEntity.ok(libraryStatsAdapter.getNumberOfBooksByAuthorAndPublisher(authorPublisherRequest));
    }

    @Override
    public ResponseEntity<YoungestOldestBook> getYoungestOldestBook() {
        return ResponseEntity.ok(libraryStatsAdapter.getYoungestAndOldestBook());
    }
}
