package com.ksz.example.EmployeeApp;

import com.ksz.example.EmployeeApp.db.EmployeeRepository;
import com.ksz.example.EmployeeApp.db.EmployeeRow;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Optional<Employee> setSalary(long id, BigDecimal newSalary)
    {
        Optional<EmployeeRow> employeeRow = employeeRepository.findById(id);
        return employeeRow.map(e -> {
            e.setSalary(newSalary);
            return e.toEmployee();
        });
    }
}
