/**
 * 
 */
package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.mvc.domain.Student;

/**
 * @author VIRU
 *
 */
@Service
public interface StudentService {

	public Student addStudent(Student student);
    public Student deleteStudent(Integer rollNumber);
    public Student updateStudent(Student student);
    public Student findStudentByRollNumber(Integer rollNumber);
    public List<Student> getAllStudent();
}
