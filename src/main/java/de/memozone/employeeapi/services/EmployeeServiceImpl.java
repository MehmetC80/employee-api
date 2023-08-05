package de.memozone.employeeapi.services;

import de.memozone.employeeapi.entity.EmployeeEntity;
import de.memozone.employeeapi.model.Employee;
import de.memozone.employeeapi.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .id(employee.getId())
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .email(employee.getEmail())
                .build();

        employeeRepository.save(employeeEntity);
        return employee;
    }


    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                = employeeRepository.findAll();

        List<Employee> employees = employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstname(),
                        emp.getLastname(),
                        emp.getEmail()))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
        return true;

    }

    @Override
    public Employee getEmployeeById(Long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = Employee.builder()
                .id(employeeEntity.getId())
                .firstname(employeeEntity.getFirstname())
                .lastname(employeeEntity.getLastname())
                .email(employeeEntity.getEmail())
                .build();

        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setFirstname(employee.getEmail());
        employeeEntity.setLastname(employee.getLastname());
        employeeEntity.setEmail(employee.getEmail());
        employeeRepository.save(employeeEntity);
        return employee;
    }
}
