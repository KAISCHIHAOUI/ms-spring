package com.ms.wscourse.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@GetMapping("")
	List<Course> findAll()
	{
		return new ArrayList<>();
	}
	
}
