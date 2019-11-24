package com.codingtest.registation.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingtest.registation.dao.repository.StudentRepository;
import com.codingtest.registation.model.Course;
import com.codingtest.registation.model.Student;

@Service
public class StudentService {
	private final static Logger LOG = LoggerFactory.getLogger(StudentService.class);

	private StudentRepository studentRepository;
	private CourseService courseService;

	@Autowired
	public StudentService(CourseService courseService, StudentRepository studentRepository) {
		this.courseService = courseService;
		this.studentRepository = studentRepository;
	}

	public Long addStudent(Student student) {
		student = studentRepository.save(student);
		LOG.info("Student {} Successfully added", student.getStudentId());
		return student.getStudentId();
	}

	public void removeStudent(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	public void registerCourse(Long studentId, Set<Course> courses) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			courses.addAll(student.getCourses());
			student.setCourses(courses);
			studentRepository.save(student);
		}
	}

	public Set<Student> getStudentsByCourseName(String courseName) {
		Optional<Course> course = courseService.getCourseByCourseName(courseName);
		if (course.isPresent()) {

			Comparator<Student> studentByName = (Student student1, Student student2) -> student1.getStudentName()
					.compareTo(student2.getStudentName());
			TreeSet<Student> sortedStudents = new TreeSet<>(studentByName);

			Set<Student> students = course.get().getStudents();
			students.forEach(student -> student.setCourses(null));
			sortedStudents.addAll(students);

			LOG.debug("Actual Students :: {} and Sorted Students by Name:: {}", students, sortedStudents);

			return sortedStudents;
		}
		return Collections.emptySet();
	}

}
