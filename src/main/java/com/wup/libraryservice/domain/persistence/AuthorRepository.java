package com.wup.libraryservice.domain.persistence;

import com.wup.libraryservice.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    Author findByAuthorName(String name);
}
