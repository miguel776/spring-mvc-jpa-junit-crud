package com.mike.springjpa.crud.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 *  - The Employee class is annotated with @Entity, indicating that it is a JPA entity. For lack of a @Table annotation, it is assumed
 *    that this entity will be mapped to a table named EMPLOYEE.
 *  - The Employee´s id property is annotated with @Id so that JPA will recognize it as the object’s ID. The id property is also annotated
 *    with @GeneratedValue to indicate that the ID should be generated automatically.
 *  - The properties call name, lastName and  department are annotate as @Column, it is mean that will be mapped to columns that share, on the other hand, name and lastName
 *    properties can have max length 20, can´t be null as indicated in the annotation @Column, also the property department is going to join with table DEPARMENT
 *    in a relation many to one  as indicated in the annotations @JoinColumn and ManyToOne.
 *  - The convenient toString() method will print out the Employee’s property.
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */

@Table(name = "EMPLOYEE")
@Entity(name = "employee")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NAME", length = 20, nullable = false)	
	private String name;
	
	@Column(name = "LAST_NAME", length = 20)
	private String lastName;

	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "DEPARMENT_ID")
	protected Department department;
	/**
	 * Employee identifier
	 * @return id (long)
	 */
	public long getId() {
		return id;
	}

	/**
	 * Employee identifier
	 * @param id (long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Employee name
	 * @return  String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Employee name
	 * @param name (String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Employee lastName
	 * @return  String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Employee lastName
	 * @param lastName (String)
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Department related to the employee
	 * @return Department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Department related to the employee
	 * @param department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * This  method will print out the department’s properties.
	 * @return (String)
	 */
	@Override
	public String toString() {
		return String.format(
				"Department[id=%d, name='%s', lastName='%s']",
				id, name, lastName);
	}
}
