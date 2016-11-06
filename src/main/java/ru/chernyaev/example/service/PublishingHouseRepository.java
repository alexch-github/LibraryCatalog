package ru.chernyaev.example.service;

import org.springframework.data.repository.CrudRepository;

import ru.chernyaev.example.domain.PublishingHouse;

public interface PublishingHouseRepository extends CrudRepository<PublishingHouse, Long> {

}
