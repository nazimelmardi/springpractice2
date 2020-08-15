package com.wup.libraryservice;

import org.openapitools.model.NewAuthor;
import org.openapitools.model.NewAuthorResponse;
import org.openapitools.model.NewBookResponse;
import org.openapitools.model.NewBook;

import java.time.LocalDate;


public class Data {

    public static NewAuthor createNewAuthor() {
        NewAuthor model = new NewAuthor();
        model.setAuthorName("John Smith");
        return model;
    }

    public static NewAuthorResponse createNewAuthorResponse() {
        NewAuthorResponse model = new NewAuthorResponse();
        model.setAuthorName("John Smith");
        return model;
    }

    public static NewBook createNewBook() {
        NewBook model = new NewBook();
        model.setAuthorName("John Smith");
        model.setDescription("test");
        model.setTitle("test title");
        model.setYearOfPublication(LocalDate.parse("2020-02-11"));
        return model;
    }

    public static NewBookResponse createNewBookResponse() {
        NewBookResponse model = new NewBookResponse();
        model.setAuthorName("John Smith");
        model.setDescription("test");
        model.setTitle("test title");
        model.setYearOfPublication(LocalDate.parse("2020-02-11"));
        return model;
    }
}