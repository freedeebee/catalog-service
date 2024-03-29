package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
@RequiredArgsConstructor
public class BookDataLoader {

    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadTestData() {
        bookRepository.deleteAll();
        var book1 = Book.of("1234567890", "Northern Lights", "Lyra Silverstar", 9.90, "Polarsophia");
        var book2 = Book.of("1234567891", "Polar Journey", "Iorek Polarson", 12.90, "Polarsophia");
        bookRepository.saveAll(List.of(book1, book2));
    }
}
