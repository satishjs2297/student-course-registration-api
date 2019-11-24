package com.codingtest.registation.exception;

public class StudentCourseIllegalStateException extends IllegalStateException {
	private static final long serialVersionUID = 1L;
	
	public StudentCourseIllegalStateException(String message) {
		super(message);
	}
	
	public StudentCourseIllegalStateException(Throwable e) {
		super(e);
	}

}
