package com.ksz.example.EmployeeApp;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Test
    public void newServiceShouldReturnEmptyList ()
    {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getEmployees();
        assertTrue(employees.isEmpty());
    }

    @Test
    public void addEmployeeShouldAddNotNullEmployeeToList()
    {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService
                .addEmployee(new NewEmployee("Blake","Manager",
                        LocalDate.of(1981, 11, 21), new BigDecimal(5000)));
        assertNotNull(employee);
    }

    @Test
    public void addEmployeeShouldAddEmployeeToList()
    {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService
                .addEmployee(new NewEmployee("Blake","Manager",
                        LocalDate.of(1981, 11, 21), new BigDecimal(5000)));
        assertEquals("Blake", employee.empname);
    }

    @Test
    public void addedEmployeeHasNewId()
    {
        EmployeeService employeeService = new EmployeeService();

        Employee employee1 = employeeService
                .addEmployee(new NewEmployee("Blake","Manager",
                        LocalDate.of(1981, 11, 21), new BigDecimal(5000)));

        Employee employee2 = employeeService
                .addEmployee(new NewEmployee("Clark","Manager",
                        LocalDate.of(1981, 6, 9), new BigDecimal(6000)));

        assertNotEquals(employee1.empid, employee2.empid);

    }
}