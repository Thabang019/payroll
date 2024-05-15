package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    private static Employee employee1, employee2;

    @BeforeEach
    void setUp() {
        employee1 = EmployeeFactory.createEmployee(1001, "Xolani","Mkhwanazi","20212121@mycput.ac.za", "0681523305", "0763588323");
        employee2 = EmployeeFactory.createEmployee(1002, "Bongumusa","Mkhwanazi","bongumusa@gmail.com", "0660238558", "0891475566");
        assertNotNull(employee1);
        assertNotNull(employee2);
    }

    @Test
    @Order(1)
    void create() {
        Employee createEmp1 = service.create(employee1);
        Employee createEmp2 = service.create(employee2);
        assertNotNull(createEmp1);
        assertNotNull(createEmp2);
        System.out.println(createEmp1);
        System.out.println(createEmp2);
    }

    @Test
    @Order(2)
    void read() {
        Long empNum = employee1.getEmployeeNumber();
        Employee readEmp = service.read(empNum);
        assertNotNull(readEmp);
        System.out.println(readEmp);
    }

    @Test
    @Order(3)
    void update() {
        Contact updateContact = new Contact.Builder().copy(employee1.getContact()).setMobile("0687523305").build();
        Employee updateEmpContact = service.update(new Employee.Builder().copy(employee1).setContact(updateContact).build());
        Employee updateEmplastName = service.update(new Employee.Builder().copy(employee1).setLastName("Mndebele").build());
        assertNotNull(updateEmpContact);
        assertNotNull(updateEmplastName);
        System.out.println(updateEmpContact);
        System.out.println(updateEmplastName);
    }

    @Test
    @Order(5)
    @Disabled
    void deleteEmployeeByEmployeeNumber(){
        Long employeeNum = employee1.getEmployeeNumber();
        service.deleteEmployeeByEmployeeNumber(employeeNum);
        System.out.println("Successfully ");
    }
}