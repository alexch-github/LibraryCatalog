package ru.chernyaev.example.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.chernyaev.example.domain.Author;
import ru.chernyaev.example.service.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	AuthorRepository authorRepository;

	@RequestMapping("/")
	@ResponseBody
	public List<Author> findAll() {
		List<Author> authors = (ArrayList<Author>) authorRepository.findAll();
		return authors;
	}
}
