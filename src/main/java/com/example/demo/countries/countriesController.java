package com.example.demo.countries;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController

public class countriesController {

	
	
	@Autowired
	private countriesRepository conRepo;

	@GetMapping("/countries")
	public List<countries> getAllcountries() {
		return conRepo.findAll();

	}

	@PostMapping("/countries")
	public countries saveCountries(@Validated @RequestBody countries countries)

	{
		return conRepo.save(countries);

	}

	@PutMapping("/countries/{id}")
	public countries update(@PathVariable String id, @Validated @RequestBody countries con) {
		con.setId(id);
		return conRepo.save(con);
	}

	@DeleteMapping("/countries/{id}")
	public void deleteCountries(@PathVariable String id) {
		conRepo.deleteById(id);
	}

}
