package com.forex.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.forex.dev.model.ExchangeValue;
import com.forex.dev.repo.ExchangeRepo;

@RestController
public class ExchangeController {

	@Value("${server.port}")
	private String port;

	
	@Autowired
	private ExchangeRepo exchangeRepo;

	@GetMapping(value = "/currency-exchange")
	public ResponseEntity<?> retrieveExchange(@RequestParam("from") String from, @RequestParam("to") String to) {
		System.out.println("PORT :: "+port);
		System.out.println("FROM :: "+from);
		System.out.println("TO :: "+to);
		
		List<?> list= exchangeRepo.findAll();
		System.out.println(list);
		
		ExchangeValue value = exchangeRepo.findByFromAndTo(from, to);
		System.out.println("ExchangeValue :: "+value);
		value.setPort(Integer.parseInt(port));
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

}
