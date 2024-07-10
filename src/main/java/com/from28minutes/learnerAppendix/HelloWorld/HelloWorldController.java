package com.from28minutes.learnerAppendix.HelloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public HelloWorld getRequestMappping() {
		return new HelloWorld("Hello World!");
	}
	
	@GetMapping("/hello")
	public HelloWorld getMappping() {
		return new HelloWorld("Hello World!");
	}
	
	@GetMapping("/helloWorld")
	public String helloWorld() {
		
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("Good.morning.english", null, null, locale );
	}
}
