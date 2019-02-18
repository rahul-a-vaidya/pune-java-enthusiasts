package com.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.bo.Book;


@Component
@Qualifier("SimpleBookRepository")
public class SimpleBookRepository implements BookRepository {

    @Override
    /**
     * As a Best Practice the name of the cache should be with the key
     * like booksByISBN
     */
    @Cacheable("booksByISBN")
    public Book getByIsbn(String isbn) {
    	/**
    	 * Adds a Delay by making the current thread sleep.
    	 */
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}