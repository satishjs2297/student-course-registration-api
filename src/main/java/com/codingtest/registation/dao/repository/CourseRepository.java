package com.codingtest.registation.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingtest.registation.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	public Optional<Course> findCourseByCourseName(String courseName);
}
