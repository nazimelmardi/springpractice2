package com.wup.librarystats.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "author_stats")
@NoArgsConstructor
public class AuthorStats {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "author_name", unique = true, nullable = false)
    private String authorName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_stats_id", nullable = false)
    private Set<BookStats> bookStats = new HashSet<>();

    public List<BookStats> findBookStatsByTitle(String bookTitle) {
        return this.bookStats.stream().filter(bookStat -> bookStat.getBookTitle().equals(bookTitle)).collect(Collectors.toList());
    }

    public void addBookStats(BookStats bookStats) {
        this.bookStats.add(bookStats);
    }
}