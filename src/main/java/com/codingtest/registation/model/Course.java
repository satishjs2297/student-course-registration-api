package com.codingtest.registation.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course implements Serializable {

	private static final long serialVersionUID = -3770142805983192214L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID", unique = true, nullable = false, length = 20)
	private Long courseId;

	@Column(name = "COURSE_NAME")
	private String courseName;

	@Column(name = "COURSE_DETAILS")
	private String courseDetails;

	@Column(name = "COURSE_DURATION")
	private String courseDuration;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = {
			@JoinColumn(name = "COURSE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "STUDENT_ID", nullable = false, updatable = false) })
	private Set<Student> students;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseDetails == null) ? 0 : courseDetails.hashCode());
		result = prime * result + ((courseDuration == null) ? 0 : courseDuration.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseDetails == null) {
			if (other.courseDetails != null)
				return false;
		} else if (!courseDetails.equals(other.courseDetails))
			return false;
		if (courseDuration == null) {
			if (other.courseDuration != null)
				return false;
		} else if (!courseDuration.equals(other.courseDuration))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDetails=" + courseDetails
				+ ", courseDuration=" + courseDuration + "]";
	}

}
