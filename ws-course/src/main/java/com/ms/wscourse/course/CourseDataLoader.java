package com.ms.wscourse.course;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CourseDataLoader implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(CourseDataLoader.class);
	private final ObjectMapper objectMapper;
	private final CourseRespository courseRespository;

	public CourseDataLoader(ObjectMapper objectMapper, CourseRespository courseRespository) {
		this.objectMapper = objectMapper;
		this.courseRespository = courseRespository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	     if(courseRespository.count() ==0)
	     {
	    	 String coursesJson ="/data/courses.json";
	    	 log.info("MARKER : Loading courses info database from json: {}", coursesJson);
	         try(InputStream inputStream = TypeReference.class.getResourceAsStream(coursesJson)) {
			   Courses response = objectMapper.readValue(inputStream, Courses.class);
			   courseRespository.saveAll(response.courses());
	         } catch (RuntimeException e) {
				    e.getStackTrace();
			}     
	     }

	}

}
