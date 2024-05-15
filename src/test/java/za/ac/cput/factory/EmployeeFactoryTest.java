package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeFactoryTest {

    private static Employee employee;
    @Test
    @Order(1)
    void createEmployee() {
        employee = EmployeeFactory.createEmployee(222136871, "Thabang","Mkhwanazi","222136871@mycput.ac.za", "0681523305", "0763588323");
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    @Order(2)
    void createEmployeeFailEmployeeNumber() {
        employee = EmployeeFactory.createEmployee(1, "Thabang","Mkhwanazi","222136871@mycput.ac.za", "0681523305", "0763588323");
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    @Order(3)
    void createEmployeeFailFirstName() {
        employee = EmployeeFactory.createEmployee(222136871, "","Mkhwanazi","222136871@mycput.ac.za", "0681523305", "0763588323");
        assertNotNull(employee);
        System.out.println(employee);
    }
}