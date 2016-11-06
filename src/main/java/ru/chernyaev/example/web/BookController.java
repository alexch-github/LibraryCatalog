package ru.chernyaev.example.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.chernyaev.example.domain.Author;
import ru.chernyaev.example.domain.Book;
import ru.chernyaev.example.domain.LibraryItem;
import ru.chernyaev.example.domain.PublishingHouse;
import ru.chernyaev.example.service.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@RequestMapping("/init")
	@ResponseBody
	String init() {
		Author a1 = new Author();
		a1.setName("John Smith");
		Author a2 = new Author();
		a2.setName("Sam Jones");
		Author a3 = new Author();
		a3.setName("Homer Simpson");

		PublishingHouse p1 = new PublishingHouse();
		p1.setName("Publishing Inc.");
		PublishingHouse p2 = new PublishingHouse();
		p2.setName("New Age");

		Book b1 = new Book();
		b1.setTitle("Java Book");
		Set<Author> authors1 = new HashSet<Author>();
		authors1.add(a1);
		b1.setAuthors(authors1);
		b1.setPublishingHouse(p1);

		LibraryItem li1 = new LibraryItem();
		li1.setRoom(1);
		li1.setBookcase(1);
		li1.setBookshelf(1);
		li1.setStatus(LibraryItem.Status.INSTOCK);

		LibraryItem li2 = new LibraryItem();
		li2.setRoom(1);
		li2.setBookcase(1);
		li2.setBookshelf(2);
		li2.setStatus(LibraryItem.Status.INSTOCK);

		Set<LibraryItem> libItems1 = new HashSet<LibraryItem>();
		libItems1.add(li1);
		libItems1.add(li2);

		b1.setLibraryItems(libItems1);

		Book b2 = new Book();
		b2.setTitle("Java + Hibernate");
		Set<Author> authors2 = new HashSet<Author>();
		authors2.add(a1);
		authors2.add(a2);
		b2.setAuthors(authors2);
		b2.setPublishingHouse(p1);

		LibraryItem li3 = new LibraryItem();
		li3.setRoom(2);
		li3.setBookcase(1);
		li3.setBookshelf(1);
		li3.setStatus(LibraryItem.Status.INSTOCK);

		LibraryItem li4 = new LibraryItem();
		li4.setRoom(2);
		li4.setBookcase(1);
		li4.setBookshelf(2);
		li4.setStatus(LibraryItem.Status.INSTOCK);

		LibraryItem li5 = new LibraryItem();
		li5.setRoom(2);
		li5.setBookcase(1);
		li5.setBookshelf(2);
		li5.setStatus(LibraryItem.Status.TAKEN);

		Set<LibraryItem> libItems2 = new HashSet<LibraryItem>();
		libItems2.add(li3);
		libItems2.add(li4);
		libItems2.add(li5);

		b2.setLibraryItems(libItems2);

		Book b3 = new Book();
		b3.setTitle("Poetry");
		Set<Author> authors3 = new HashSet<Author>();
		authors3.add(a3);
		b3.setAuthors(authors3);
		b3.setPublishingHouse(p2);

		LibraryItem li6 = new LibraryItem();
		li6.setRoom(3);
		li6.setBookcase(1);
		li6.setBookshelf(1);
		li6.setStatus(LibraryItem.Status.TAKEN);

		Set<LibraryItem> libItems3 = new HashSet<LibraryItem>();
		libItems3.add(li6);

		b3.setLibraryItems(libItems3);

		bookRepository.save(b1);
		bookRepository.save(b2);
		bookRepository.save(b3);

		return "Books are initialized";
	}

	@RequestMapping("/")
	@ResponseBody
	public List<Book> findAll() {
		List<Book> books = (ArrayList<Book>) bookRepository.findAll();
		return books;
	}

	@RequestMapping(value = "/author", params = "authorId")
	@ResponseBody
	public List<Book> findByAuthorId(@RequestParam(value = "authorId") Long authorId) {
		List<Book> books = (ArrayList<Book>) bookRepository.findByAuthorId(authorId);
		return books;
	}

	@RequestMapping(value = "/author", params = "authorName")
	@ResponseBody
	public List<Book> findByAuthorName(@RequestParam(value = "authorName") String authorName) {
		List<Book> books = (ArrayList<Book>) bookRepository.findByAuthorName(authorName);
		return books;
	}

	@RequestMapping(value = "/publishingHouse", params = "publishingHouseId")
	@ResponseBody
	public List<Book> findByPublishingHouseId(@RequestParam(value = "publishingHouseId") Long publishingHouseId) {
		List<Book> books = (ArrayList<Book>) bookRepository.findByPublishingHouseId(publishingHouseId);
		return books;
	}

	@RequestMapping(value = "/publishingHouse", params = "publishingHouseName")
	@ResponseBody
	public List<Book> findByPublishingHouseName(
			@RequestParam(value = "publishingHouseName") String publishingHouseName) {
		List<Book> books = (ArrayList<Book>) bookRepository.findByPublishingHouseName(publishingHouseName);
		return books;
	}
}
