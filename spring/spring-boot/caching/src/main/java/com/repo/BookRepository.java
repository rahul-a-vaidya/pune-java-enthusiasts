package com.repo;

import com.bo.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

}