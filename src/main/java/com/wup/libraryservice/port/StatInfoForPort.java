package com.wup.libraryservice.port;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StatInfoForPort {

    private String bookTitle;

    private String authorName;

    private LocalDate dateOfPublication;

    private LocalDate addedToLibrary;
}
