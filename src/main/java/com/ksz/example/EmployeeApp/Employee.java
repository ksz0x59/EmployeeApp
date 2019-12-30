package com.ksz.example.EmployeeApp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


public class Employee {

    public final long empid;
    public final String empname;
    public final String jobTitle;
    public final LocalDate hiredate;
    public final BigDecimal salary;

    public Employee(long empid, String empname, String jobTitle, LocalDate hiredate, BigDecimal salary) {
        this.empid = empid;
        this.empname = empname;
        this.jobTitle = jobTitle;
        this.hiredate = hiredate;
        this.salary = salary;
    }
}
