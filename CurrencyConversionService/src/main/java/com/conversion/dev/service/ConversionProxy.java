package com.conversion.dev.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.conversion.dev.model.CurrencyConversionBean;

@FeignClient(name = "forex-service")
@RibbonClient(name = "forex-service")
public interface ConversionProxy {

	@GetMapping("/currency-exchange")
	public CurrencyConversionBean retrieveVals(@RequestParam("from") String from, @RequestParam("to") String to);

}
