package com.gl.service;

import com.gl.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(int id, Employee employee);
    String deleteEmployee(int id);
    List<Employee> searchEmployees(String firstName);
    List<Employee> getAllEmployeesSorted(String order);
}
