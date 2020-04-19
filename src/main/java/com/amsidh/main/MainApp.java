/**
 * 
 */
package com.amsidh.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.student.mvc.domain.Student;
import com.student.service.StudentService;

/**
 * @author VIRU
 * 
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"resource/spring.xml");
		StudentService studentService = (StudentService) context.getBean("studentService");
		Student student = new Student(new Integer(123), "Amsidh", "B",
				"Lokhande", "IX", new Long(8108551845L), "Kate Puram Pune");
		try {
			studentService.addStudent(student);
			Student student1=studentService.findStudentByRollNumber(123);
			System.out.println(student1.getRollNumber() +"  "+ student1.getFirstName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		for (Student st : studentService.getAllStudent()) {
			System.out.println(st.getRollNumber() +"  "+ st.getFirstName());
		}
	}

}
