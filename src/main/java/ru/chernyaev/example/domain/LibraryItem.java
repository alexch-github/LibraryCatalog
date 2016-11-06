package ru.chernyaev.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library_items")
public class LibraryItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private int room;

	@Column(nullable = false)
	private int bookcase;

	@Column(nullable = false)
	private int bookshelf;

	@Enumerated(EnumType.STRING)
	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getBookcase() {
		return bookcase;
	}

	public void setBookcase(int bookcase) {
		this.bookcase = bookcase;
	}

	public int getBookshelf() {
		return bookshelf;
	}

	public void setBookshelf(int bookshelf) {
		this.bookshelf = bookshelf;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		INSTOCK, TAKEN
	}

}
