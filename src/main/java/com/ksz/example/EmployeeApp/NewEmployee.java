package com.ksz.example.EmployeeApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewEmployee {

    final String empname;
    final String jobTitle;

    @JsonFormat(pattern="yyyy-MM-dd")
    final LocalDate hiredate;
    final BigDecimal salary;

    @JsonCreator
    public NewEmployee(@JsonProperty("name") String empname, @JsonProperty("title") String jobTitle,
                       @JsonProperty("hiredate")  LocalDate hiredate, @JsonProperty("salary") BigDecimal salary) {
        this.empname = empname;
        this.jobTitle = jobTitle;
        this.hiredate = hiredate;
        this.salary = salary;
    }
}
