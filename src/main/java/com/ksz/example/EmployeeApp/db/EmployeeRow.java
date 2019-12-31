package com.ksz.example.EmployeeApp.db;

import com.ksz.example.EmployeeApp.Employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class EmployeeRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long empid;

    private  String empname;
    private  String jobTitle;
    private  LocalDate hiredate;
    private  BigDecimal salary;

    public EmployeeRow() {
    }

    public EmployeeRow(String empname, String jobTitle, LocalDate hiredate, BigDecimal salary) {
        this.empname = empname;
        this.jobTitle = jobTitle;
        this.hiredate = hiredate;
        this.salary = salary;
    }

    public long getEmpid() {
        return empid;
    }

    public void setEmpid(long empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee toEmployee ()
    {
        return new Employee(this.empid,this.empname,this.jobTitle,this.hiredate, this.salary);
    }
}
