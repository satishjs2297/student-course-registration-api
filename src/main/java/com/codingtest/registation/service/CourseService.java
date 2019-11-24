package com.codingtest.registation.service;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingtest.registation.dao.repository.CourseRepository;
import com.codingtest.registation.model.Course;
import com.codingtest.registation.model.Student;

@Service
public class CourseService {
	private final static Logger LOG = LoggerFactory.getLogger(CourseService.class);

	private CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public Long addCourse(Course course) {
		course = courseRepository.save(course);
		LOG.info("Course: {} has been successfully added. ", course.getCourseId());
		return course.getCourseId();
	}
	
	public void removeCourse(Long courseId) {
		courseRepository.deleteById(courseId);
	}

	public void registerStudentToCourse(Long courseId, Set<Student> students) {
		LOG.info("CourseId :: {} , Student :: {}", courseId, students);
		Optional<Course> courseOptional = courseRepository.findById(courseId);
		if (courseOptional.isPresent()) {
			Course course = courseOptional.get();
			students.addAll(course.getStudents());
			course.setStudents(students);
			courseRepository.save(course);
		}
	}

	public Optional<Course> getCourseByCourseName(String courseName) {
		return courseRepository.findCourseByCourseName(courseName);
	}

}
