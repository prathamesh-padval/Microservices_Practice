package com.conversion.dev.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conversion.dev.model.CurrencyConversionBean;
import com.conversion.dev.service.ConversionProxy;
import com.conversion.dev.service.TestProxy;

@RestController
public class CurrencyController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	ConversionProxy proxy;
	
	@Autowired
	TestProxy testProxy;
	
//	@GetMapping(value = "/convert-currency")
//	public ResponseEntity<?> convertCurrency(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("quantity") BigDecimal quantity){
//		
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8000/currency-exchange?from="+from+"&to="+to;
//		
//		CurrencyConversionBean response = restTemplate.getForObject(url, CurrencyConversionBean.class);
//
//		System.out.println("Response :: "+response);
////		CurrencyConversionBean bean = response.getBody();
//		response.setTotalCalculatedAmount(quantity.multiply(response.getConversionMultiple()));
//		
//		return new ResponseEntity<>(response,HttpStatus.OK);
//	}

	
	@GetMapping(value = "/convert-currency-feign")
	public ResponseEntity<?> convertCurrencyFeign(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("quantity") BigDecimal quantity){
		
		CurrencyConversionBean response = proxy.retrieveVals(from, to);
		
		response.setTotalCalculatedAmount(quantity.multiply(response.getConversionMultiple()));
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/test-service")
	public ResponseEntity<?> testAnother(){
		String response = testProxy.retrieve();
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}

