package com.ms.wscourse.course;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(CourseController.class)
@AutoConfigureMockMvc
class CourseControllerTest {

	@Autowired
	MockMvc mockMvc;

	List<Course> courses = new ArrayList<>();

	
	// create courses
	@BeforeEach
	void setUp() {
	
		courses = List.of(
				new Course(1, "Introduction to Java Programming", "Learn the basics of Java programming.", 3),
				new Course(2, "Advanced Java Programming", "Explore advanced Java topics.", 4));
	}
	
	
	//List all courses
	@Test
	void shoudFindAllCourses() throws Exception
	{
		mockMvc.perform(get("/api/courses")).andExpect(status().isOk());
	}
	
	
	
	
	
	

}
