package com.ksz.example.EmployeeApp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeService employeeService = new EmployeeService();

    @RequestMapping(value = "/employees",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/employees",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee addEmployee(@RequestBody NewEmployee employee)
    {
        return this.employeeService.addEmployee(employee);
    }

}
