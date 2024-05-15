package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @GetMapping("/read/{employeeNumber}")
    public Employee read(@PathVariable long employeeNumber){
        return service.read(employeeNumber);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }

    @DeleteMapping("/delete/{employeeNumber}")
    public void delete(@PathVariable long employeeNumber){
        service.deleteEmployeeByEmployeeNumber(employeeNumber);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll(){
        return service.getAll();
    }
}
