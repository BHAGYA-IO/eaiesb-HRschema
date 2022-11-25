package com.example.demo.regions;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface regionsRepository 
	
	extends MongoRepository <regions, String>{
		regions findByid(String id);

}
