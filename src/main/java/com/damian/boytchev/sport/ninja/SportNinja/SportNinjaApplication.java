package com.damian.boytchev.sport.ninja.SportNinja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class SportNinjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportNinjaApplication.class, args);
	}

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	ResponseEntity<String> hello(@PathVariable String name){
		return new ResponseEntity<>("Hello " + name,HttpStatus.OK);
	}

}

