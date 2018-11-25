package com.moon.cache.bean.repository;

import com.moon.cache.bean.Book;

public interface BookRepository {
	
	Book getByIsbn(String isbn);

}
