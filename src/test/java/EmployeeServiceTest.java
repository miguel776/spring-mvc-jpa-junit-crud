import com.mike.springjpa.crud.bean.Department;
import com.mike.springjpa.crud.bean.Employee;
import com.mike.springjpa.crud.config.InfrastructureConfig;
import com.mike.springjpa.crud.service.DepartmentService;
import com.mike.springjpa.crud.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 *  - This is the unitary testing of the service EmployeeServiceTest  using the technology Junit integrating with spring.
 *  - Annotate the JUnit test class with @RunWith(SpringJUnit4ClassRunner.class) and loads the Spring configuration file manually
 *  - Each methods is going to test each method of the service EmployeeServiceTest
 *
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InfrastructureConfig.class})
public class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    /**
     * Test from the method showEmployeesByDepartmentListService of the service EmployeeService
     */
    @Test
    @Order(1)
    public void  myATest(){

        Department departmentIT = new Department();
        departmentIT.setName("IT");
        departmentIT.setId(1);

        Department departmentTC = new Department();
        departmentTC.setName("TC");
        departmentTC.setId(2);

        Employee employee1 = new Employee();
        employee1.setName("Paco");
        employee1.setLastName("Lopez");
        employee1.setDepartment(departmentIT);

        Employee employee2 = new Employee();
        employee2.setName("Ramon");
        employee2.setLastName("Fernandez");
        employee2.setDepartment(departmentIT);

        Employee employee3 = new Employee();
        employee3.setName("Raquel");
        employee3.setLastName("Aguirre");
        employee3.setDepartment(departmentTC);

        departmentService.createDepartmentService(departmentIT);
        departmentService.createDepartmentService(departmentTC);

        Employee employeeNew1 = employeeService.createEmployeeService(employee1);
        Employee employeeNew2 = employeeService.createEmployeeService(employee2);
        Employee employeeNew3 = employeeService.createEmployeeService(employee3);

        assertReflectionEquals(employee1, employeeNew1);
        assertReflectionEquals(employee2, employeeNew2);
        assertReflectionEquals(employee3, employeeNew3);
    }

    /**
     * Test from the method showEmployeesByDepartmentListService of the service EmployeeService
     */
    @Test
    @Order(2)
    public void myBTest(){

        List<Employee> employeesListService= (List<Employee>) employeeService.showAllEmployeesListService();

        assertEquals(1, employeesListService.get(0).getId());
        assertEquals("Paco", employeesListService.get(0).getName());
        assertEquals("Lopez", employeesListService.get(0).getLastName());
        assertEquals(1, employeesListService.get(0).getDepartment().getId());
        assertEquals("IT", employeesListService.get(0).getDepartment().getName());

        assertEquals(2, employeesListService.get(1).getId());
        assertEquals("Ramon", employeesListService.get(1).getName());
        assertEquals("Fernandez", employeesListService.get(1).getLastName());
        assertEquals(1, employeesListService.get(1).getDepartment().getId());
        assertEquals("IT", employeesListService.get(1).getDepartment().getName());

        assertEquals(3, employeesListService.get(2).getId());
        assertEquals("Raquel", employeesListService.get(2).getName());
        assertEquals("Aguirre", employeesListService.get(2).getLastName());
        assertEquals(2, employeesListService.get(2).getDepartment().getId());
        assertEquals("TC", employeesListService.get(2).getDepartment().getName());
    }

    /**
     * Test from the method showEmployeesByDepartmentListService of the service EmployeeService
     */
    @Test
    @Order(3)
    public void myCTest(){

        List<Employee> employeesListServiceIT= (List<Employee>) employeeService.showEmployeesByDepartmentListService(1);
        List<Employee> employeesListServiceTC= (List<Employee>) employeeService.showEmployeesByDepartmentListService(2);

        assertEquals(1, employeesListServiceIT.get(0).getId());
        assertEquals("Paco", employeesListServiceIT.get(0).getName());
        assertEquals("Lopez", employeesListServiceIT.get(0).getLastName());
        assertEquals(1, employeesListServiceIT.get(0).getDepartment().getId());
        assertEquals("IT", employeesListServiceIT.get(0).getDepartment().getName());

        assertEquals(2, employeesListServiceIT.get(1).getId());
        assertEquals("Ramon", employeesListServiceIT.get(1).getName());
        assertEquals("Fernandez", employeesListServiceIT.get(1).getLastName());
        assertEquals(1, employeesListServiceIT.get(1).getDepartment().getId());
        assertEquals("IT", employeesListServiceIT.get(1).getDepartment().getName());

        assertEquals(3, employeesListServiceTC.get(0).getId());
        assertEquals("Raquel", employeesListServiceTC.get(0).getName());
        assertEquals("Aguirre", employeesListServiceTC.get(0).getLastName());
        assertEquals(2, employeesListServiceTC.get(0).getDepartment().getId());
        assertEquals("TC", employeesListServiceTC.get(0).getDepartment().getName());
    }

    /**
     * Test from the method DeleteEmployeeService of the service EmployeeService
     */
    @Test
    @Order(4)
    public void myDTest(){

        employeeService.deleteEmployeeService(3);
        employeeService.deleteEmployeeService(2);

        List<Employee> employeesListService= (List<Employee>) employeeService.showAllEmployeesListService();

        assertEquals(1,  employeesListService.size());

        assertEquals(1, employeesListService.get(0).getId());
        assertEquals("Paco", employeesListService.get(0).getName());
        assertEquals("Lopez", employeesListService.get(0).getLastName());
        assertEquals(1, employeesListService.get(0).getDepartment().getId());
        assertEquals("IT", employeesListService.get(0).getDepartment().getName());
    }

    /**
     * Test from the method UpdateEmployeeService of the service EmployeeService
     */
    @Test
    @Order(5)
    public void myETest(){

        Department departmentTC = new Department();
        departmentTC.setName("TC");
        departmentTC.setId(2);

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Irene");
        employee1.setLastName("Gonzalez");
        employee1.setDepartment(departmentTC);

        employeeService.updateEmployeeService(employee1);

        List<Employee> employeesListService= (List<Employee>) employeeService.showAllEmployeesListService();

        assertEquals(1,  employeesListService.size());

        assertEquals(1, employeesListService.get(0).getId());
        assertEquals("Irene", employeesListService.get(0).getName());
        assertEquals("Gonzalez", employeesListService.get(0).getLastName());
        assertEquals(2, employeesListService.get(0).getDepartment().getId());
        assertEquals("TC", employeesListService.get(0).getDepartment().getName());
    }
}