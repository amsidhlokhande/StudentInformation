/**
 * 
 */
package com.student.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.student.mvc.dao.StudentDao;
import com.student.mvc.dom.StudentDom;

/**
 * @author VIRU
 * 
 */

public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.student.mvc.dao.StudentDao#addStudent(com.student.mvc.domain.Student)
	 */
	public StudentDom addStudent(StudentDom studentDom) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(studentDom);
		session.flush();
		session.getTransaction().commit();
		session.close();
       return studentDom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.student.mvc.dao.StudentDao#deleteStudent(java.lang.Integer)
	 */
	public StudentDom deleteStudent(Integer rollNumber) {
		sessionFactory.openSession().beginTransaction();
		StudentDom studentDomReturn = (StudentDom) sessionFactory.getCurrentSession().load(
				StudentDom.class, rollNumber);
		sessionFactory.getCurrentSession().delete(studentDomReturn);
		return studentDomReturn;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.student.mvc.dao.StudentDao#updateStudent(com.student.mvc.domain.Student
	 * )
	 */
	public StudentDom updateStudent(StudentDom studentDom) {
		sessionFactory.openSession().beginTransaction();
		StudentDom studentDomReturn = (StudentDom) sessionFactory.getCurrentSession().load(StudentDom.class, studentDom.getRollNumber());
		sessionFactory.getCurrentSession().saveOrUpdate(studentDom);
		return studentDomReturn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.student.mvc.dao.StudentDao#findStudentByRollNumber(java.lang.Integer)
	 */
	public StudentDom findStudentByRollNumber(Integer rollNumber) {
		StudentDom studentDomReturn = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		studentDomReturn = (StudentDom) session.get(StudentDom.class,
				rollNumber);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return studentDomReturn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.student.mvc.dao.StudentDao#getAllStudent()
	 */
	public List<StudentDom> getAllStudent() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<StudentDom> studentDomList = session.createQuery(
				"from com.student.mvc.dom.StudentDom").list();
		session.flush();
		session.getTransaction().commit();
		session.close(); 
		return studentDomList;
	}

}
