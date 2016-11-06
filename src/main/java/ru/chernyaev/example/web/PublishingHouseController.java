package ru.chernyaev.example.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.chernyaev.example.domain.PublishingHouse;
import ru.chernyaev.example.service.PublishingHouseRepository;

@RestController
@RequestMapping("/publishingHouses")
public class PublishingHouseController {

	@Autowired
	PublishingHouseRepository publishingHouseRepository;

	@RequestMapping("/")
	@ResponseBody
	public List<PublishingHouse> findAll() {
		List<PublishingHouse> publishingHouses = (ArrayList<PublishingHouse>) publishingHouseRepository.findAll();
		return publishingHouses;
	}
}
