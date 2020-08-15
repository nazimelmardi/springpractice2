package com.wup.libraryservice.domain.persistence;

import com.wup.libraryservice.domain.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, UUID> {

}
