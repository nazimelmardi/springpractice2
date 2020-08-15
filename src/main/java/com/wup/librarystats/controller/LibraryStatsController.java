package com.wup.librarystats.controller;


import com.wup.librarystats.adapter.LibraryStatsAdapter;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.StatInfoForPort;
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
}
