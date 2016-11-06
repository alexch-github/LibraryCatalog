package ru.chernyaev.example.service;

import org.springframework.data.repository.CrudRepository;

import ru.chernyaev.example.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
