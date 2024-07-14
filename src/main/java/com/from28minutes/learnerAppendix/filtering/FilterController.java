package com.from28minutes.learnerAppendix.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
	
	@GetMapping("/fields")
	public SomeBean getAllfields() {
		return new SomeBean("field1","field2","field3");
	}
	
	@GetMapping("/fields-list")
	public List<SomeBean>  getAllfieldsList() {
		return Arrays.asList(new SomeBean("field1","field2","field3"), new SomeBean("field4","field5","field6"));
	}
}
