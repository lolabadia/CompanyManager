package main.java.edu.upc.eetac.dsa;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CompanyManager manager = new CompanyManagerImpl();

        manager.addCompany("Google", "Technology company");
        manager.addCompany("Amazon", "E-commerce company");

        try {
            manager.addEmployee("Anna", "Garcia", new Date(), 3000, "Google");
            manager.addEmployee("Marc", "Lopez", new Date(), 2500, "Google");
            manager.addEmployee("Laura", "Martinez", new Date(), 2800, "Amazon");

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("EMPLOYEES ORDERED BY NAME:");

        List<Employee> employeesByName = manager.findAllEmployeesOrderedByName();

        for (Employee employee : employeesByName) {
            System.out.println(employee.getName() + " " + employee.getSurname());
        }

        System.out.println();

        System.out.println("EMPLOYEES ORDERED BY SALARY:");

        List<Employee> employeesBySalary = manager.findAllEmployeesOrderedBySalary();

        for (Employee employee : employeesBySalary) {
            System.out.println(employee.getName() + " - " + employee.getSalary());
        }

        System.out.println();

        System.out.println("GOOGLE EMPLOYEES:");

        for (Employee employee : manager.employees("Google")) {
            System.out.println(employee.getName());
        }

        System.out.println();

        System.out.println("COMPANIES:");

        for (Company company : manager.findAllCompanies()) {
            System.out.println(company.getName());
        }
    }
}