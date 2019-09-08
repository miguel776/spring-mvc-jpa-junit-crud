package com.mike.springjpa.crud.service;

import com.mike.springjpa.crud.bean.Employee;

import java.util.List;

/**
 * Interface of the EmployeeService for the management of employees of the application
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
public interface EmployeeService {

    /**
     * - Abstract method showDepartmentListService to create a new department
     * @param employee
     * @return
     */
    Employee createEmployeeService(Employee employee);

    /**
     * - Abstract method showAllEmployeesListServicio to show a list departments
     * @return Iterable<Employee>
     */
    Iterable<Employee> showAllEmployeesListService();

    /**
     * - Abstract method showEmployeesByEmployeeListServicio to show a list employees by a department
     * @return Iterable<Employee>
     */
    List<Employee> showEmployeesByDepartmentListService(long id);

    /**
     * - Abstract methoddeleteEmployeeService to delete a Employee
     * @param id
     */
    void deleteEmployeeService(long id);

    /**
     * - Abstract methoddeleteEmployeeService to update a Employee
     * @param employeeeNew
     */
    void updateEmployeeService(Employee employeeeNew);
}
