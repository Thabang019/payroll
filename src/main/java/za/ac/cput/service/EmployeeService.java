package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.ContactRepository;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService{

    private EmployeeRepository repository;
    private ContactRepository contactRepository;

    @Autowired
    EmployeeService(EmployeeRepository repository,ContactRepository contactRepository) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        contactRepository.save(employee.getContact());
        return repository.save(employee);
    }

    @Override
    public Employee read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        contactRepository.save(employee.getContact());
        return repository.save(employee);
    }
    public void deleteEmployeeByEmployeeNumber(Long employeeNumber){
        repository.deleteEmployeeByEmployeeNumber(employeeNumber);
    }
}
