package com.from28minutes.learnerAppendix.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public HelloWorld getRequestMappping() {
		return new HelloWorld("Hello World!");
	}
	
	@GetMapping("/hello")
	public HelloWorld getMappping() {
		return new HelloWorld("Hello World!");
	}
}
