package com.wup.libraryservice;

import com.wup.libraryservice.adapter.LibraryAdapter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openapitools.model.NewAuthor;
import org.openapitools.model.NewAuthorResponse;
import org.openapitools.model.NewBook;
import org.openapitools.model.NewBookResponse;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LibraryIT {


    @MockBean
    private LibraryAdapter libraryAdapter;

    @Test
    @DisplayName("testNewAuthorCreation")
    void testNewAuthorCreation() {
        new LibraryDriver(libraryAdapter)
                .whenNewAuthorAdded(Data.createNewAuthor())
                .thenAuthorCraeted(Data.createNewAuthorResponse())
                .whenNewBookAdded(Data.createNewBook())
                .thenBookCreated(Data.createNewBookResponse());
    }

    @RequiredArgsConstructor
    public class LibraryDriver {

        private final LibraryAdapter libraryAdapter;
        private NewAuthorResponse newAuthorResponse;
        private NewBookResponse newBookResponse;

        public LibraryDriver whenNewAuthorAdded(NewAuthor newAuthor) {
            newAuthorResponse = libraryAdapter.addNewAuthor(newAuthor);
            return this;
        }

        public LibraryDriver whenNewBookAdded(NewBook newBook) {
            newBookResponse = libraryAdapter.createNewBook(newBook);
            return this;
        }

        public LibraryDriver thenAuthorCraeted(NewAuthorResponse response) {
            then(response.getAuthorName()).isEqualTo(newAuthorResponse.getAuthorName());
            return this;
        }

        public LibraryDriver thenBookCreated(NewBookResponse response) {
            then(response.getTitle()).isEqualTo(newBookResponse.getTitle());
            then(response.getYearOfPublication()).isEqualTo(newBookResponse.getYearOfPublication());
            return this;
        }
    }
}
