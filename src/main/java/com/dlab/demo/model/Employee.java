package com.dlab.demo.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Employee.class)
public class Employee implements RequestInterface {
    private String name;
    private long salary;
    private String empid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }
}
