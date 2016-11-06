package ru.chernyaev.example.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.chernyaev.example.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	@Query("from Book b join b.authors a where a.id = :authorId")
	public Iterable<Book> findByAuthorId(@Param("authorId") Long authorId);

	@Query("from Book b join b.authors a where a.name like :authorName")
	public Iterable<Book> findByAuthorName(@Param("authorName") String authorName);

	@Query("from Book b join b.publishingHouse p where p.id = :publishingHouseId")
	public Iterable<Book> findByPublishingHouseId(@Param("publishingHouseId") Long publishingHouseId);

	@Query("from Book b join b.publishingHouse p where p.name like :publishingHouseName")
	public Iterable<Book> findByPublishingHouseName(@Param("publishingHouseName") String publishingHouseName);

}
