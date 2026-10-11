package main.java.edu.upc.eetac.dsa;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private String description;
    private List<Employee> employees;

    public Company(String name, String description) {
        this.name = name;
        this.description = description;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}