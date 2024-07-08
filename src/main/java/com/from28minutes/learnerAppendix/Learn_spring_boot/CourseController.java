package com.from28minutes.learnerAppendix.Learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/course")
	public List<Course> getAllCourses(){
		return Arrays.asList(
				new Course(1, "course1","in28minutes"),
				new Course(1, "course2","in28minutes")
				);
	}
}
