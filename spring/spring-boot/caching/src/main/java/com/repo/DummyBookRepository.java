package com.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bo.Book;

/**
 * Uncommenting these will end adding a New implementation of
 * {@link com.repo.BookRepository} and gives and Error :
 * <p>
 * expected single matching bean but found 2
 * </p>
 * 
 * to resolve where the interface is defined give the name of the implementation
 * class that Needs to Be injected.
 * 
 * @author nikhil
 *
 */
@Component
@Qualifier("DummyBookRepository")
public class DummyBookRepository implements BookRepository {

	/**
	 * @CachePut vs. @Cacheable : @Cacheable will skip running the method,
	 *           whereas @CachePut will actually run the method and then put its
	 *           results in the cache. @CachePut(value="addresses",
	 * condition="#customer.name=='Tom'")
	 */
	@Override
	public Book getByIsbn(String isbn) {

		return new Book("default", "default");
	}

}
