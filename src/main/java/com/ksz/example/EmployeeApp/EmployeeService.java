package com.ksz.example.EmployeeApp;

import com.ksz.example.EmployeeApp.db.EmployeeRepository;
import com.ksz.example.EmployeeApp.db.EmployeeRow;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeRow ->
            employees.add(employeeRow.toEmployee())
        );
        return employees;
    }

    public Employee addEmployee (NewEmployee employee)
    {
        EmployeeRow employeeRow = employeeRepository.save(
                new EmployeeRow(employee.empname,  employee.jobTitle, employee.hiredate, employee.salary));
        return employeeRow.toEmployee();
    }
}
