/**
 * 
 */
package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.exceptions.NullValueException;
import com.student.mvc.dao.StudentDao;
import com.student.mvc.dom.StudentDom;
import com.student.mvc.domain.Student;
import com.student.util.Utility;

/**
 * @author VIRU
 * 
 */
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.student.service.StudentService#addStudent(com.student.mvc.domain.
	 * Student)
	 */
	public Student addStudent(Student student) {
		Student st = null;
		try {
			if (null != student && null != student.getRollNumber()
					&& 0 < student.getRollNumber()) {
				st = Utility.domToDto(studentDao.addStudent(Utility
						.dtoToDom(student)));
			} else {
				throw new NullValueException(
						"Student or RollNumber is not valid");
			}
		} catch (Exception ex) {
			throw new NullValueException(ex.getMessage());

		}

		return st;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.student.service.StudentService#deleteStudent(java.lang.Integer)
	 */
	public Student deleteStudent(Integer rollNumber) {
		Student student = null;
		try {
			if (null != rollNumber && 0 < rollNumber) {
				student = Utility
						.domToDto(studentDao.deleteStudent(rollNumber));
			} else {
				throw new NullValueException("RollNumber not valid");
			}
		} catch (Exception ex) {
			throw new NullValueException(ex.getMessage());
		}
		return student;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.student.service.StudentService#updateStudent(com.student.mvc.domain
	 * .Student)
	 */
	public Student updateStudent(Student student) {
		Student st = null;
		try {
			if (null != student && null != student.getRollNumber()
					&& 0 < student.getRollNumber()) {
				st = Utility.domToDto(studentDao.updateStudent(Utility
						.dtoToDom(student)));
			} else {
				throw new NullValueException("Not a valid Student");
			}
		} catch (Exception ex) {
			throw new NullValueException(ex.getMessage());
		}
		return st;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.student.service.StudentService#findStudentByRollNumber(java.lang.
	 * Integer)
	 */
	public Student findStudentByRollNumber(Integer rollNumber) {
		Student student = null;
		try {
			if (null != rollNumber && 0 < rollNumber) {
				student = Utility.domToDto(studentDao
						.findStudentByRollNumber(rollNumber));
			} else {
				throw new NullValueException("Not a valid Student");
			}
		} catch (Exception ex) {
			throw new NullValueException(ex.getMessage());
		}

		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.student.service.StudentService#getAllStudent()
	 */
	public List<Student> getAllStudent() {
		List<Student> studentList = null;
		List<StudentDom> studentDomList = null;
		try {
			studentDomList = studentDao.getAllStudent();
			if (null != studentDomList && !studentDomList.isEmpty()) {
				studentList = new ArrayList<Student>();
				for (StudentDom studentDom : studentDomList) {
					if (studentDom != null) {
						studentList.add(Utility.domToDto(studentDom));
					}
				}
			}
		} catch (Exception ex) {
			throw new NullValueException(ex.getMessage());
		}
		return studentList;
	}
}
