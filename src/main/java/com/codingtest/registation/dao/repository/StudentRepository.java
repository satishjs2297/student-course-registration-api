package com.codingtest.registation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingtest.registation.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
