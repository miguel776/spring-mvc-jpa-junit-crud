package com.mike.springjpa.crud.repository;

import com.mike.springjpa.crud.bean.Department;
import org.springframework.data.repository.CrudRepository;

/**
 *  - This is a  CrudRepository  of the Department entity.
 *  - CrudRepository is a Spring Data interface for generic CRUD operations on a repository of a
 *    specific type. It provides several methods out of the box for interacting with a database.
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
