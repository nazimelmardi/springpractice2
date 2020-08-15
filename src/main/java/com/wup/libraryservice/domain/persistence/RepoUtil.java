package com.wup.libraryservice.domain.persistence;

import com.wup.libraryservice.domain.entity.Book;
import org.openapitools.model.BookRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class RepoUtil {

    public Specification<Book> createNewSpecification(BookRequest request) {
        return (Specification<Book>) (root, criteriaQuery, cb) -> {
            final List<Predicate> predicates = new ArrayList<>();
            if (request.getTitle() != null) {
                predicates.add(cb.equal(root.get("title"), request.getTitle()));
            }
            if (request.getAuthorName() != null) {
                predicates.add(cb.equal(root.get("authorName"), request.getAuthorName()));
            }
            if (request.getPublisherName() != null) {
                predicates.add(cb.equal(root.get("publisherName"), request.getPublisherName()));
            }
            if (request.getYearAddedToLibrary() != null) {
                predicates.add(cb.equal(root.get("addedToLibrary"), request.getYearAddedToLibrary()));
            }
            if (request.getYearOfPublication() != null) {
                predicates.add(cb.equal(root.get("dateOfPublication"), request.getYearOfPublication()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}

