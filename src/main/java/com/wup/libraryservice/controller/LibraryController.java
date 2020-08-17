package com.wup.libraryservice.controller;

import com.wup.libraryservice.adapter.LibraryAdapter;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.LibraryApi;
import org.openapitools.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LibraryController implements LibraryApi {

    private final LibraryAdapter libraryAdapter;

    @Override
    public ResponseEntity<NewAuthorResponse> addNewAuthor(@Valid NewAuthor newAuthor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryAdapter.addNewAuthor(newAuthor));
    }

    @Override
    public ResponseEntity<NewBookResponse> addNewBook(@Valid NewBook newBook) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryAdapter.callPort(newBook));
    }

    @Override
    public ResponseEntity<List<NewBookResponse>> getBooksByParams(@Valid BookRequest bookRequest) {
        return ResponseEntity.ok(libraryAdapter.getBooksByParams(bookRequest));
    }
}
