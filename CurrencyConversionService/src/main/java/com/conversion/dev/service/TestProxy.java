package com.conversion.dev.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="test-service")
@RibbonClient(name="test-service")
public interface TestProxy {
	
	@GetMapping("/test")
	public String retrieve();

}
