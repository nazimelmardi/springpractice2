package com.wup.libraryservice.service;

import com.wup.libraryservice.domain.entity.Author;
import com.wup.libraryservice.domain.persistence.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public PersistedAuthor createNewAuthor(Author author) {
        return new PersistedAuthor(authorRepository.save(author));
    }

    @Transactional
    public PersistedAuthor author(UUID authorId) {
        return new PersistedAuthor(authorRepository.findById(authorId)
                .orElseThrow(NoSuchElementException::new));
    }

    public PersistedAuthor authorByName(String name) {
        return new PersistedAuthor(authorRepository.findByAuthorName(name));
    }

    public class PersistedAuthor {
        private Author author;

        public PersistedAuthor(Author author) {
            this.author = author;
        }

        public Author data() {
            return this.author;
        }

        public BookService bookService() {
            return new BookService(authorRepository, author);
        }
    }
}
