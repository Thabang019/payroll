package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/payroll/employee";

    private Employee employee;
    @BeforeEach
    void setUp() {
        employee = EmployeeFactory.createEmployee(1003, "Mpumelelo", "Mkhwanazi", "Mpumelelom@gmail.com", "0784512263", "0841594487");
    }

    @Test
    @Order(1)
    void create() {
        String url =  BASE_URL +"/create";
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Employee newEmp = postResponse.getBody();
        System.out.println(newEmp);
    }

    @Test
    @Order(2)
    void read() {
        Long empNum = employee.getEmployeeNumber();
        String url = BASE_URL + "/read/" + empNum;
        ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);
        //assertSame(employee, response);
        assertNotNull(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Contact updateContact = new Contact.Builder().copy(employee.getContact()).setEmail("Mpumelelo@gmail.com").build();
        Employee updateEmployee = new Employee.Builder().copy(employee).setContact(updateContact).build();
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, updateEmployee, Employee.class);
        Employee empUpdate = postResponse.getBody();
        assertNotNull(empUpdate);
        System.out.println(empUpdate);
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL +  "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        //System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    @Disabled
    void delete() {
    }


}