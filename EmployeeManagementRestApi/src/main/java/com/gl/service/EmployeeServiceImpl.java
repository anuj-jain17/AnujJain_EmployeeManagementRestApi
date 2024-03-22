package com.gl.service;

import com.gl.model.Employee;
import com.gl.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Deleted employee id - " + id;
    }

    @Override
    public List<Employee> searchEmployees(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }
    
    @Override
    public List<Employee> getAllEmployeesSorted(String order) {
        Sort sortByFirstName = Sort.by("firstName");
        if (order.equalsIgnoreCase("asc")) {
            sortByFirstName = sortByFirstName.ascending();
        } else if (order.equalsIgnoreCase("desc")) {
            sortByFirstName = sortByFirstName.descending();
        }
        return employeeRepository.findAll(sortByFirstName);
    }
}
