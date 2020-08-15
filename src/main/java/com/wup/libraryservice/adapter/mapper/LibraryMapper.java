package com.wup.libraryservice.adapter.mapper;

import com.wup.libraryservice.domain.entity.Author;
import com.wup.libraryservice.domain.entity.Book;
import org.mapstruct.Mapper;
import org.openapitools.model.NewAuthor;
import org.openapitools.model.NewAuthorResponse;
import org.openapitools.model.NewBook;
import org.openapitools.model.NewBookResponse;

@Mapper(componentModel = "spring")
public interface LibraryMapper {

    Author toNewAuthorEntity(NewAuthor model);

    NewAuthorResponse toNewAuthorResponseModel(Author entity);

    Book toNewBookEntity(NewBook model);

    NewBookResponse toNewBookResponseModel(Book entity);

}
