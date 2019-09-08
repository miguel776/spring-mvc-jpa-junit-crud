package com.mike.springjpa.crud.controller;

import com.mike.springjpa.crud.bean.Department;
import com.mike.springjpa.crud.bean.Employee;
import com.mike.springjpa.crud.service.DepartmentService;
import com.mike.springjpa.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * Controller that redirects the requests received to the different services depending on the functionality required
 *
 *  - Create an department
 * 	- Create an employee
 * 	- Show a department list
 * 	- Show a employee list
 * 	- Show a list of employees by department
 * 	- Delete an employee
 * 	- Update an employee
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */

@RestController
public class RestControllerApp {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    /**
     * - Create a new departament according to the Json recived
     *   example: {"name":"informatica"}
     * - As a result sends a json informing about the operation, if every thing was ok or not
     *
     * @param department
     * @return Map<String, Object>
     */
    @RequestMapping(value = "/createdepartament", method = RequestMethod.POST)
    public Map<String, Object>  CreateDepartament(@RequestBody Department department) {

        Map<String, Object> responseJson = new HashMap<String, Object>();

        try {
            Department departmentNew = departmentService.createDepartmentService(department);
            responseJson.put("response","The department "+ departmentNew+" has been saved right");

        } catch (Exception e) {
            responseJson.put("response",e.getMessage());
        }

        return responseJson;
    }

    /**
     * - Show a list of deparments, if every thing is ok return a json with a list  of deparments other wise
     * - return a json informing about the wrong.
     *
     * @return Map<String, Object>
     */
    @RequestMapping(value = "/showdeparmentlist", method = RequestMethod.GET)
    public Object ShowDepartmentList() {

        Map<String, Object> responseJson = new HashMap<String, Object>();

        try {
            List<Department> result = (List<Department>) departmentService.showAllDepartmentListService();
            responseJson.put("response",result);

        } catch (Exception e) {
            responseJson.put("response",e.getMessage());
        }

        return responseJson;
    }

    /**
     * - Create a new departament according to the Json recived
     *   example: {"name": "raquel","lastName": "gonzalez","department":{"id": 1,"name": "Informatica"}}
     * - As a result, return a json informing about the operation, if every thing was ok or not
     *
     * @param employee
     * @return Map<String, Object>
     */
    @RequestMapping(value = "/createdemployee", method = RequestMethod.POST)
    public Map<String, Object>  CreateEmployee(@RequestBody Employee employee) {

        Map<String, Object> responseJson = new HashMap<String, Object>();

        try {
            employeeService.createEmployeeService(employee);
            responseJson.put("response","the employee has been saved right");

        } catch (Exception e) {
            responseJson.put("response",e.getMessage());
        }

        return responseJson;
    }

    /**
     * - Show a list of employees, if every thing is ok return a json with a list  of employees other wise
     * - Return a json informing about the wrong.
     *
     * @return Map<String, Object>
     */
    @RequestMapping(value = "/showemployelist", method = RequestMethod.GET)
    public Object showEmployeeList() {

        Map<String, Object> responseJson = new HashMap<String, Object>();

        try {
            List<Employee> result = (List<Employee>) employeeService.showAllEmployeesListService();
            responseJson.put("response",result);

        } catch (Exception e) {
            responseJson.put("response",e.getMessage());
        }

        return responseJson;
    }

    /**
     * - Show a list of employees, if every thing is ok return a json with a list  of employees other wise
     * - Return a json informing about the wrong.
     *
     * @return Map<String, Object>
     */
    @ResponseBody
    @RequestMapping(value = "/showemployeesbydepartment/{id}", method = RequestMethod.GET)
    Object showEmployeesByDepartment(@PathVariable("id") long id) {

        Map<String, Object> responseJson = new HashMap<String, Object>();

        try {
            List<Employee> result = employeeService.showEmployeesByDepartmentListService(id);
            responseJson.put("response",result);

        } catch (Exception e) {
            responseJson.put("response",e.getMessage());
        }

        return responseJson;
    }

    /**
     * - Show a list of employees, if every thing is ok return a json with a list  of employees other wise
     * - Return a json informing about the wrong.
     *
     * @return Map<String, Object>
     */
    @ResponseBody
    @RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.GET)
    Object deleteEmployee(@PathVariable("id") long id) {

        Map<String, Object> responseJson = new HashMap<String, Object>();

        try {
            employeeService.deleteEmployeeService(id);
            responseJson.put("response","the employee has been deleted right");

        } catch (Exception e) {
            responseJson.put("response",e.getMessage());
        }

        return responseJson;
    }

    /**
     * - Show a list of employees, if every thing is ok return a json with a list  of employees other wise
     * - Return a json informing about the wrong.
     *
     * @return Map<String, Object>
     */
    @ResponseBody
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public Object updateEmployee(@RequestBody Employee employee){

        Map<String, Object> responseJson = new HashMap<String, Object>();

        try {
            employeeService.updateEmployeeService(employee);
            responseJson.put("response","the employee has been update right");

        } catch (Exception e) {
            responseJson.put("response",e.getMessage());
        }

        return responseJson;
    }
}