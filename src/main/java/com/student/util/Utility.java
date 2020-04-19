/**
 * 
 */
package com.student.util;

import com.student.mvc.dom.StudentDom;
import com.student.mvc.domain.Student;

/**
 * @author VIRU
 *
 */
public class Utility {

	
	/**
	 * @param studentDom
	 * @return
	 */
	public static Student domToDto(StudentDom studentDom) throws NullPointerException {

		Student student = new Student();
		student.setRollNumber(studentDom.getRollNumber());
		student.setFirstName(studentDom.getFirstName());
		student.setMiddleName(studentDom.getMiddleName());
		student.setLastName(studentDom.getLastName());
		student.setStdClass(studentDom.getStdClass());
		student.setMobileNumber(studentDom.getMobileNumber());
		student.setAddress(studentDom.getAddress());

		return student;
	}

	/**
	 * @param student
	 * @return
	 */
	public static StudentDom dtoToDom(Student student) throws NullPointerException {

		StudentDom studentDom = new StudentDom();
		studentDom.setRollNumber(student.getRollNumber());
		studentDom.setFirstName(student.getFirstName());
		studentDom.setMiddleName(student.getMiddleName());
		studentDom.setLastName(student.getLastName());
		studentDom.setStdClass(student.getStdClass());
		studentDom.setMobileNumber(student.getMobileNumber());
		studentDom.setAddress(student.getAddress());

		return studentDom;
	}

}
