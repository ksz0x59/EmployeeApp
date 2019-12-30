package com.ksz.example.EmployeeApp;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EmployeeService {

    List<Employee> employees = new CopyOnWriteArrayList<>();

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public Employee addEmployee (NewEmployee employee)
    {
        // ugly because not thread safe !
        Employee createdEmployee = new Employee(employees.size() + 1, employee.empname,
                employee.jobTitle, employee.hiredate, employee.salary);

        employees.add(createdEmployee);

        return createdEmployee;
    }
}
