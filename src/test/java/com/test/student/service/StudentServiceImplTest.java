/**
 * 
 */
package com.test.student.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.student.exceptions.NullValueException;
import com.student.mvc.dao.StudentDao;
import com.student.mvc.dom.StudentDom;
import com.student.mvc.domain.Student;
import com.student.service.StudentService;
import com.student.service.StudentServiceImpl;
import com.student.util.Utility;

/**
 * @author VIRU
 * 
 */
public class StudentServiceImplTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();
	public StudentService studentService;
	public StudentDao studentDaoMock;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		studentService = new StudentServiceImpl();
		studentDaoMock = context.mock(StudentDao.class);
		ReflectionTestUtils.setField(studentService, "studentDao",
				studentDaoMock, StudentDao.class);

	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#addStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test
	public final void testAddStudentSuccess() {
		final Student student = populateStudent();
		context.checking(new Expectations() {
			{

				allowing(studentDaoMock)
						.addStudent(with(any(StudentDom.class)));
				will(returnValue(Utility.dtoToDom(student)));
			}
		});
		Student st = studentService.addStudent(student);
		Assert.assertEquals(student.getRollNumber(), st.getRollNumber());
	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#addStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test(expected = NullValueException.class)
	public final void testAddStudentAsNullStudent() {
		studentService.addStudent(null);

	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#addStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test(expected = NullValueException.class)
	public final void testAddStudentRollNumberNull() {
		final Student student = populateStudent();
		student.setRollNumber(null);
		studentService.addStudent(student);

	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#addStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test(expected = NullValueException.class)
	public final void testAddStudentForNegativeRollNumberNull() {
		final Student student = populateStudent();
		student.setRollNumber(-123);
		studentService.addStudent(student);

	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#addStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test(expected = NullValueException.class)
	public final void testAddStudentThrowNullValueException() {
		final Student student = populateStudent();

		context.checking(new Expectations() {
			{

				allowing(studentDaoMock)
						.addStudent(with(any(StudentDom.class)));
				will(throwException(new Exception()));
			}
		});
		studentService.addStudent(student);

	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#deleteStudent(java.lang.Integer)}
	 * .
	 */
	@Test
	public final void testDeleteStudentSuccess() {

		final Student student = populateStudent();

		context.checking(new Expectations() {
			{

				allowing(studentDaoMock)
						.deleteStudent(with(any(Integer.class)));
				will(returnValue(Utility.dtoToDom(student)));

			}
		});
		Student st = studentService.deleteStudent(new Integer(123));
		Assert.assertEquals(student.getRollNumber(), st.getRollNumber());
	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#deleteStudent(java.lang.Integer)}
	 * .
	 */

	@Test(expected = NullValueException.class)
	public final void testDeleteStudentRollNumberAsNull() {
		studentService.deleteStudent(null);
	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#deleteStudent(java.lang.Integer)}
	 * .
	 */

	@Test(expected = NullValueException.class)
	public final void testDeleteStudentDaoMethodthrowException() {
		context.checking(new Expectations() {
			{

				allowing(studentDaoMock)
						.deleteStudent(with(any(Integer.class)));
				will(throwException(new Exception()));
			}
		});
		studentService.deleteStudent(new Integer(123));
	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#deleteStudent(java.lang.Integer)}
	 * .
	 */

	@Test(expected = NullValueException.class)
	public final void testDeleteStudentForNegativeRollNumber() {
		studentService.deleteStudent(new Integer(-123));
	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#updateStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test
	public final void testUpdateStudentForSuccess() {
		final Student student = populateStudent();
		context.checking(new Expectations() {
			{
				allowing(studentDaoMock).updateStudent(
						with(any(StudentDom.class)));
				will(returnValue(Utility.dtoToDom(student)));

			}
		});

		Student st = studentService.updateStudent(student);
		Assert.assertEquals(student.getRollNumber(), st.getRollNumber());
	}
	
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#updateStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test(expected=NullValueException.class)
	public final void testUpdateStudentForNullStudent() {
		studentService.updateStudent(null);
	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#updateStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test(expected=NullValueException.class)
	public final void testUpdateStudentForNullRollNumber() {
		final Student student = populateStudent();
		student.setRollNumber(null);
		studentService.updateStudent(student);
		
	}
	
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#updateStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test(expected=NullValueException.class)
	public final void testUpdateStudentForNegativeRollNumber() {
		final Student student = populateStudent();
		student.setRollNumber(-123);
		studentService.updateStudent(student);
		
	}
	
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#updateStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test(expected=NullValueException.class)
	public final void testUpdateStudentForDaoReturnNull() {
		final Student student = populateStudent();
		context.checking(new Expectations(){{
			allowing(studentDaoMock).updateStudent(
					with(any(StudentDom.class)));
			will(returnValue(null));
			
			
		}});
		studentService.updateStudent(student);
		
	}
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#updateStudent(com.student.mvc.domain.Student)}
	 * .
	 */
	@Test(expected=NullValueException.class)
	public final void testUpdateStudentForDaoReturnException() {
		final Student student = populateStudent();
		context.checking(new Expectations(){{
			allowing(studentDaoMock).updateStudent(
					with(any(StudentDom.class)));
			will(throwException(new Exception()));
			
			
		}});
		studentService.updateStudent(student);
		
	}
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#findStudentByRollNumber(java.lang.Integer)}
	 * .
	 */
	@Test
	public final void testFindStudentByRollNumberForSuceess() {
         final Student student=populateStudent();
         context.checking(new Expectations(){{
 			allowing(studentDaoMock).findStudentByRollNumber(with(any(Integer.class)));
 			will(returnValue(Utility.dtoToDom(student)));
 		}});
         
         Student st=studentService.findStudentByRollNumber(123);
         Assert.assertEquals(student.getRollNumber(), st.getRollNumber());
 		
	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#findStudentByRollNumber(java.lang.Integer)}
	 * .
	 */
	@Test(expected=NullValueException.class)
	public final void testFindStudentByRollNumberForDaoReturnNull() {
         context.checking(new Expectations(){{
 			allowing(studentDaoMock).findStudentByRollNumber(with(any(Integer.class)));
 			will(returnValue(null));
 		}});
         
         studentService.findStudentByRollNumber(123);
         
	}
	
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#findStudentByRollNumber(java.lang.Integer)}
	 * .
	 */
	@Test(expected=NullValueException.class)
	public final void testFindStudentByRollNumberForDaoReturnException() {
         context.checking(new Expectations(){{
 			allowing(studentDaoMock).findStudentByRollNumber(with(any(Integer.class)));
 			will(throwException(new Exception()));
 		}});
         
         studentService.findStudentByRollNumber(123);
         
	}
	
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#findStudentByRollNumber(java.lang.Integer)}
	 * .
	 */
	@Test(expected=NullValueException.class)
	public final void testFindStudentByRollNumberForRollNumberNull() {
     studentService.findStudentByRollNumber(null);
         
	}
	
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#findStudentByRollNumber(java.lang.Integer)}
	 * .
	 */
	@Test(expected=NullValueException.class)
	public final void testFindStudentByRollNumberForNegativeRollNumber() {
     studentService.findStudentByRollNumber(-123);
         
	}


	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#getAllStudent()}.
	 */
	@Test
	public final void testGetAllStudentForSuccess() {
		final List<StudentDom> listOfStudentDom=new ArrayList<StudentDom>();
		listOfStudentDom.add(Utility.dtoToDom(populateStudent()));
		context.checking(new Expectations(){{
 			allowing(studentDaoMock).getAllStudent();
 			will(returnValue(listOfStudentDom));
 		}});

		List<Student> listOfStudent=studentService.getAllStudent();
		Assert.assertEquals(listOfStudentDom.get(0).getRollNumber(), listOfStudent.get(0).getRollNumber());
		
	}
	
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#getAllStudent()}.
	 */
	@Test
	public final void testGetAllStudentForDaoReturnEmptyList() {
		final List<StudentDom> listOfStudentDom=new ArrayList<StudentDom>();
		context.checking(new Expectations(){{
 			allowing(studentDaoMock).getAllStudent();
 			will(returnValue(listOfStudentDom));
 		}});

		List<Student> listOfStudent=studentService.getAllStudent();
		Assert.assertNull(listOfStudent);
		
	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#getAllStudent()}.
	 */
	@Test
	public final void testGetAllStudentForDaoReturnNull() {
		
		context.checking(new Expectations(){{
 			allowing(studentDaoMock).getAllStudent();
 			will(returnValue(null));
 		}});

		List<Student> listOfStudent=studentService.getAllStudent();
		Assert.assertNull(listOfStudent);
		
	}

	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#getAllStudent()}.
	 */
	@Test
	public final void testGetAllStudentForDaoReturnListOfNull() {
		final List<StudentDom> listOfStudentDom=new ArrayList<StudentDom>();
		listOfStudentDom.add(null);
		
		context.checking(new Expectations(){{
 			allowing(studentDaoMock).getAllStudent();
 			will(returnValue(listOfStudentDom));
 		}});

		List<Student> listOfStudent=studentService.getAllStudent();
		Assert.assertTrue(listOfStudent.isEmpty());
		
	}
	
	/**
	 * Test method for
	 * {@link com.student.service.StudentServiceImpl#getAllStudent()}.
	 */
	@Test(expected=NullValueException.class)
	public final void testGetAllStudentForDaoThrowException() {
		context.checking(new Expectations(){{
 			allowing(studentDaoMock).getAllStudent();
 			will(throwException(new Exception()));
 		}});

		studentService.getAllStudent();
		
	}
	
	
	private Student populateStudent() {
		return new Student(new Integer(123), "Amsidh", "B", "Lokhande", "XI",
				new Long(8108551845L), "Pune");
	}

}
