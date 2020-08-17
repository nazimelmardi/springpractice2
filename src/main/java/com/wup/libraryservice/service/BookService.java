package com.wup.libraryservice.service;

import com.wup.libraryservice.domain.entity.Author;
import com.wup.libraryservice.domain.entity.Book;
import com.wup.libraryservice.domain.entity.Publisher;
import com.wup.libraryservice.domain.persistence.AuthorRepository;
import com.wup.libraryservice.domain.persistence.BookRepository;
import com.wup.libraryservice.domain.persistence.RepoUtil;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.BookRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class BookService {

    private final AuthorRepository authorRepository;
    private final Author author;
    private BookRepository bookRepository;

    @Transactional
    public BookService addNewBook(Book book, String publisherName) {
        book.setAddedToLibrary(LocalDate.now());
        Publisher publisher = author.findPublisherByName(publisherName);
        if (publisher == null) {
            publisher.setPublisherName(publisherName);
            book.setPublisher(publisher);
        } else {
            book.setPublisher(publisher);
        }
        author.addBook(book);
        authorRepository.save(author);
        return this;
    }

    public BookService getBookByTitle(String title) {
        author.findBookByTitle(title);
        return this;
    }

    public List<Book> bookFilteredBy(BookRequest request) {
        RepoUtil repoUtil = new RepoUtil();
        List<Book> books = bookRepository.findAll((Pageable) repoUtil.createNewSpecification(request)).getContent();
        return books;
    }

    public Author data() {
        return author;
    }

}
