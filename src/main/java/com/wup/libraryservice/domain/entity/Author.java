package com.wup.libraryservice.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "author")
@NoArgsConstructor
public class Author {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private Set<Book> books = new HashSet<>();

    public Book findBookById(UUID bookId) {
        return this.books.stream().filter(b -> b.getId().equals(bookId))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public Book findBookByTitle(String title) {
        return this.books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Publisher findPublisherByName(String name) {
        return this.books.stream().filter(book -> book.getPublisher().getPublisherName().equals(name)).findAny().get().getPublisher();
    }

    public String findNameOfPublisher(UUID bookId) {
        return this.books.stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .getPublisher().getPublisherName();
    }
}
