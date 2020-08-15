package com.wup.libraryservice.adapter;

import com.wup.libraryservice.adapter.mapper.LibraryMapper;
import com.wup.libraryservice.domain.entity.Author;
import com.wup.libraryservice.domain.entity.Book;
import com.wup.libraryservice.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.NewAuthor;
import org.openapitools.model.NewAuthorResponse;
import org.openapitools.model.NewBook;
import org.openapitools.model.NewBookResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryAdapter {

    private final LibraryMapper libraryMapper;
    private final AuthorService authorService;

    public NewAuthorResponse addNewAuthor(NewAuthor newAuthor) {
        Author author = libraryMapper.toNewAuthorEntity(newAuthor);
        return libraryMapper
                .toNewAuthorResponseModel(authorService.createNewAuthor(author).data());
    }

    public NewBookResponse createNewBook(NewBook newBookModel) {
        Book book = libraryMapper.toNewBookEntity(newBookModel);
        return libraryMapper.toNewBookResponseModel(authorService.authorByName(newBookModel.getAuthorName())
                .bookService()
                .addNewBook(book)
                .data()
                .findBookById(book.getId()));
    }
}
