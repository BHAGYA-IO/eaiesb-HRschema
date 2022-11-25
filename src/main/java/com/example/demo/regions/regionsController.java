package com.example.demo.regions;


import java.util.List;
import java.util.Optional;

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

@SuppressWarnings("unused")
@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class regionsController {

	@Autowired
	private regionsRepository regRepo;

	@GetMapping("/regions")
	public List<regions> getAllRegions() {
		return regRepo.findAll();

	}
		@GetMapping("/regions/{id}")
	public Optional<regions> getregionsById(@PathVariable String id) {
		 return regRepo.findById(id);	}

	@PostMapping("/regions")
	public regions saveRegions(@Validated @RequestBody regions regions)

	{
		return regRepo.save(regions);

	}

	@PutMapping("/regions/{id}")
	public regions update(@PathVariable String id, @Validated @RequestBody regions reg) {
		reg.setId(id);
		return regRepo.save(reg);
	}

	@DeleteMapping("/regions/{id}")
	public void deleteRegions(@PathVariable String id) {
		regRepo.deleteById(id);
	}
}
