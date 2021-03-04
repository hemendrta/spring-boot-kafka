package com.kafka.example.model;

import java.util.List;

public class Employee {

    private String name;
    private List<String> departments;

    public Employee() {
    }

    public Employee(String name, List<String> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }
}
