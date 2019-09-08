package com.mike.springjpa.crud.service;

import com.mike.springjpa.crud.bean.Department;

/**
 * Interface of the DepartmentService for the management of department of the application
 *
 *  - Create an department.
 *  - Show a list of the departments register the app.
 *  - Show a employees list of a departments.
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */

public interface DepartmentService {

    /**
     * - Abstract method showDepartmentListService to create a new department
     * @param department
     */
    Department createDepartmentService(Department department);

    /**
     * - Abstract method showDepartmentListService to show a list of the departments register the app
     * @return Iterable<Department>
     */
    Iterable<Department> showAllDepartmentListService();

}
