/**
 * 
 */
package com.student.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.mvc.dom.StudentDom;

/**
 * @author VIRU
 * 
 */
@Service
public interface StudentDao {

	public StudentDom addStudent(StudentDom studentDom);
    public StudentDom deleteStudent(Integer rollNumber);
    public StudentDom updateStudent(StudentDom studentDom);
    public StudentDom findStudentByRollNumber(Integer rollNumber);
    public List<StudentDom> getAllStudent();
    
}
