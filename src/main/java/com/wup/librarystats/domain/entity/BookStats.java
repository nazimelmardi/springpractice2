package com.wup.librarystats.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "book_stats")
@NoArgsConstructor
public class BookStats {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "date_added_to_library")
    private LocalDate dateAddedToLibrary;

    @Column(name = "date_of_publication")
    private LocalDate dateOfPublication;

}
