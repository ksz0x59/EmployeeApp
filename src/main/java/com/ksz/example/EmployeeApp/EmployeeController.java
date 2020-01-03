package com.ksz.example.EmployeeApp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

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

    @RequestMapping(value = "/employees/{id}/salary/{salary}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public Employee setSalary(@PathVariable("id") long id, @PathVariable("salary") BigDecimal salary)
    {
        return this.employeeService.setSalary(id,salary).orElseThrow(
                () -> new NoEmployeeException(id)
        );
    }

}
