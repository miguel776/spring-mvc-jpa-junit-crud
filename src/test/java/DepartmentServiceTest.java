import com.mike.springjpa.crud.bean.Department;
import com.mike.springjpa.crud.config.InfrastructureConfig;
import com.mike.springjpa.crud.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 *  - This is the unitary testing of the service DepartmentServiceTest using the technology Junit integrating with spring.
 *  - Annotate the JUnit test class with @RunWith(SpringJUnit4ClassRunner.class) and loads the Spring configuration file manually
 *  - Each methods is going to test each method of the service DepartmentServiceTest
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InfrastructureConfig.class})
public class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    /**
     * Test from the method CreateDepartmentService of the service DepartmentServiceTest
     */
    @Test
    @Order(1)
    public void  myATest(){

        Department department = new Department();
        department.setName("IT");
        Department departmentNew = departmentService.createDepartmentService(department);
        assertReflectionEquals(department, departmentNew);

        Department department2 = new Department();
        department2.setName("TC");
        Department departmentNew2 = departmentService.createDepartmentService(department2);
        assertReflectionEquals(department2, departmentNew2);
    }

    /**
     * Test from the method ShowAllDepartmentListService of the service DepartmentServiceTest
     */
   @Test
   @Order(2)
    public void myBTest(){

        List<Department> departmentListService= (List<Department>) departmentService.showAllDepartmentListService();
        assertEquals(1, departmentListService.get(0).getId());
        assertEquals("IT", departmentListService.get(0).getName());
        assertEquals(2, departmentListService.get(1).getId());
        assertEquals("TC", departmentListService.get(1).getName());
    }
}