package com.mike.springjpa.crud.service;

import com.mike.springjpa.crud.bean.Employee;
import com.mike.springjpa.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * - Implementation of the EmployeeService service for the management of employees and departments of the application
 *     - Create a department
 *     - Show a list all departments register in the app
 *     - Show a employees list of a departments.
 * 	   - Delete an employee
 * 	   - Update an employee
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */
@Service("EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * - Implementation of the method createEmployeeService to create a new employee
     * @param employee
     * @return
     */
	@Override
	public Employee createEmployeeService(Employee employee){

		employeeRepository.save(employee);
        return employee;
    }

	/**
	 * - Implementation of the method showEmployeeListServicio to show a list of all employees
	 * @return Iterable<Department>
	 */
	@Override
	public Iterable<Employee> showAllEmployeesListService(){

		Iterable<Employee> employeee = employeeRepository.findAll();
		return  employeee;
	}

	/**
	 * - Implementation of the method showEmployeeListServicio to show a list of all employees
	 * @param idDepartment
	 * @return Iterable<Department>
	 */
	@Override
	public List<Employee> showEmployeesByDepartmentListService(long idDepartment){

		TypedQuery<Employee> querySelec  = entityManager.createQuery("select e from employee e  where  e.department.id = :idDepartment", Employee.class)
				.setParameter("idDepartment" , idDepartment);

		List<Employee> employeee = querySelec.getResultList();
		return  employeee;
	}

	/**
	 * - Implementation of the method deleteEmployeeService to delete a Employee
	 * @param id
	 */
	@Override
	public void deleteEmployeeService(long id){
		employeeRepository.delete(id);
	}

	/**
	 * - Implementation of the method deleteEmployeeService to update a Employee
	 * @param employeeeNew
	 */
	@Override
	public void updateEmployeeService(Employee employeeeNew){

		Employee employeee = employeeRepository.findOne(employeeeNew.getId());

		employeee.setName(employeeeNew.getName());
		employeee.setLastName(employeeeNew.getLastName());
		employeee.setDepartment(employeeeNew.getDepartment());
		employeeRepository.save(employeeeNew);
	}
}
