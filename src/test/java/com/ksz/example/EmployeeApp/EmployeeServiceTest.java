package com.ksz.example.EmployeeApp;

import com.ksz.example.EmployeeApp.db.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    public void cleanAfterTest()
    {
        employeeRepository.deleteAll();
    }

    @Test
    public void newServiceShouldReturnEmptyList ()
    {
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        List<Employee> employees = employeeService.getEmployees();
        assertTrue(employees.isEmpty());
    }

    @Test
    public void addEmployeeShouldAddNotNullEmployee()
    {
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee = employeeService
                .addEmployee(new NewEmployee("Blake","Manager",
                        LocalDate.of(1981, 11, 21), new BigDecimal(5000)));
        assertNotNull(employee);
    }

    @Test
    public void addEmployeeShouldAddEmployee()
    {
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee employee = employeeService
                .addEmployee(new NewEmployee("Blake","Manager",
                        LocalDate.of(1981, 11, 21), new BigDecimal(5000)));
        assertEquals("Blake", employee.empname);
    }

    @Test
    public void addedEmployeeHasNewId()
    {
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        Employee employee1 = employeeService
                .addEmployee(new NewEmployee("Blake","Manager",
                        LocalDate.of(1981, 11, 21), new BigDecimal(5000)));

        Employee employee2 = employeeService
                .addEmployee(new NewEmployee("Clark","Manager",
                        LocalDate.of(1981, 6, 9), new BigDecimal(6000)));

        assertNotEquals(employee1.empid, employee2.empid);

    }

    @Test
    public void forNewlyAddedEmployeeShouldBeAbleToChangeSalary()
    {
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        Employee employee = employeeService
                .addEmployee(new NewEmployee("Blake","Manager",
                        LocalDate.of(1981, 11, 21), new BigDecimal(5000)));

        Employee employee2 = employeeService.setSalary(employee.empid, new BigDecimal(7000)).get();

        assertEquals(new BigDecimal(7000), employee2.salary);

    }

}