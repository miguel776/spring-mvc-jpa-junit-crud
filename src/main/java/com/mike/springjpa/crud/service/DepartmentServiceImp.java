package com.mike.springjpa.crud.service;

import com.mike.springjpa.crud.bean.Department;
import com.mike.springjpa.crud.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the  service DepartmentService for the management of departments of the application
 *     - Create a department
 *     - Show a list all departments register in the app
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */
@Service("DepartmentService")
@Transactional
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * - Implementation of the method createDepartmentService to create a new department
     * @param department
     */
    @Override
    public Department createDepartmentService(Department department){
        Department departmentNew = departmentRepository.save(department);
        return departmentNew;
    }

    /**
     * - Implementation of the method showDepartmentListService to show a list of all department
     * @return Iterable<Department>
     */
    @Override
    public Iterable<Department> showAllDepartmentListService(){
        Iterable<Department> departamentos = departmentRepository.findAll();
        return  departamentos;
    }
}