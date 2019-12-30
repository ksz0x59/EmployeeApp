package com.ksz.example.EmployeeApp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


public class Employee {

    Integer empid;
    String empname;
    String jobTitle;
    LocalDate hiredate;
    BigDecimal salary;

    public Employee (){}

    public Employee(Integer empid, String empname, String jobTitle, LocalDate hiredate, BigDecimal salary) {
        this.empid = empid;
        this.empname = empname;
        this.jobTitle = jobTitle;
        this.hiredate = hiredate;
        this.salary = salary;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(empid, employee.empid) &&
                Objects.equals(empname, employee.empname) &&
                Objects.equals(jobTitle, employee.jobTitle) &&
                Objects.equals(hiredate, employee.hiredate) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empid, empname, jobTitle, hiredate, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", hiredate=" + hiredate +
                ", salary=" + salary +
                '}';
    }
}
