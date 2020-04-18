package com.mvcdemo.service;

import org.springframework.stereotype.Service;

import com.mvcdemo.model.Course;


@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
