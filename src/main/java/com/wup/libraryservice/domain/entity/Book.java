package com.wup.libraryservice.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "book")
@NoArgsConstructor
public class Book {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "date_of_publication")
    private LocalDate dateOfPublication;

    @Column(name = "added_to_library")
    private LocalDate addedToLibrary;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id", nullable = false)
    private Publisher publisher;
}
