package com.wup.libraryservice.adapter;

import com.wup.libraryservice.adapter.mapper.LibraryMapper;
import com.wup.libraryservice.domain.entity.Author;
import com.wup.libraryservice.domain.entity.Book;
import com.wup.libraryservice.port.LibraryPort;
import com.wup.libraryservice.port.StatInfoForPort;
import com.wup.libraryservice.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.NewAuthor;
import org.openapitools.model.NewAuthorResponse;
import org.openapitools.model.NewBook;
import org.openapitools.model.NewBookResponse;
import org.openapitools.model.BookRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryAdapter {

    private final LibraryMapper libraryMapper;
    private final AuthorService authorService;
    private final LibraryPort libraryPort;

    public NewAuthorResponse addNewAuthor(NewAuthor newAuthor) {
        Author author = libraryMapper.toNewAuthorEntity(newAuthor);
        return libraryMapper
                .toNewAuthorResponseModel(authorService.createNewAuthor(author).data());
    }

    public NewBookResponse createNewBook(NewBook newBookModel) {
        Book book = libraryMapper.toNewBookEntity(newBookModel);
        return libraryMapper.toNewBookResponseModel(authorService.authorByName(newBookModel.getAuthorName())
                .bookService()
                .addNewBook(book, newBookModel.getPublisherName())
                .data()
                .findBookById(book.getId()));
    }

    public NewBookResponse callPort(NewBook model) {
        NewBookResponse response = createNewBook(model);
        libraryPort.portTest(getStatInfo(response));
        return response;
    }

    public List<NewBookResponse> getBooksByParams(BookRequest request) {
        return libraryMapper.toNewBookResponseModels(authorService.authorByName(request.getAuthorName())
                .bookService()
                .bookFilteredBy(request));
    }

    private StatInfoForPort getStatInfo(NewBookResponse response) {
        StatInfoForPort info = new StatInfoForPort();
        info.setAuthorName(response.getAuthorName());
        info.setAddedToLibrary(response.getAddedToLibrary());
        info.setBookTitle(response.getTitle());
        info.setDateOfPublication(response.getYearOfPublication());
        info.setPublisherName(response.getPublisherName());
        return info;
    }
}
