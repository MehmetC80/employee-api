package de.memozone.employeeapi.services;

import de.memozone.employeeapi.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(UUID id);

    Employee getEmployeeById(UUID id);

    Employee updateEmployee(UUID id, Employee employee);
}
