/**
 * 
 */
package com.student.mvc.dom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * @author VIRU
 * 
 */
@Entity
@Table(name = "STUDENT_INFO")
@Repository
public class StudentDom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 818110944871430697L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLL_NUMBER")
	private Integer rollNumber;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "MIDDLENAME")
	private String middleName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "STD_CLASS")
	private String stdClass;
	@Column(name = "MOBILE_NUMBER")
	private Long mobileNumber;
	@Column(name = "ADDRESS")
	private String address;

	/**
	 * 
	 */
	public StudentDom() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rollNumber
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param stdClass
	 * @param mobileNumber
	 * @param address
	 */
	public StudentDom(Integer rollNumber, String firstName, String middleName,
			String lastName, String stdClass, Long mobileNumber, String address) {
		super();
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.stdClass = stdClass;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	/**
	 * @return the rollNumber
	 */
	public Integer getRollNumber() {
		return rollNumber;
	}

	/**
	 * @param rollNumber
	 *            the rollNumber to set
	 */
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the stdClass
	 */
	public String getStdClass() {
		return stdClass;
	}

	/**
	 * @param stdClass
	 *            the stdClass to set
	 */
	public void setStdClass(String stdClass) {
		this.stdClass = stdClass;
	}

	/**
	 * @return the mobileNumber
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
