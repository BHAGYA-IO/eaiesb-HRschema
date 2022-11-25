package com.example.demo.countries;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface countriesRepository 

	
	extends MongoRepository <countries, String>{
		countries findByid(String id);

}
