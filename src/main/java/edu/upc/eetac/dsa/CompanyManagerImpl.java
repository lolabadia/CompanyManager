package main.java.edu.upc.eetac.dsa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyManagerImpl implements CompanyManager {

    private Map<String, Company> companies;

    public CompanyManagerImpl() {
        this.companies = new HashMap<>();
    }

    @Override
    public void addCompany(String companyName, String description) {
        Company company = new Company(companyName, description);
        companies.put(companyName, company);
    }

    @Override
    public void addEmployee(String name, String surname, Date birthday,
                            double salary, String companyName) throws MyException {

        Company company = companies.get(companyName);

        if (company == null) {
            throw new MyException("Company not found: " + companyName);
        }

        Employee employee = new Employee(name, surname, birthday, salary);
        company.addEmployee(employee);
    }

    @Override
    public List<Employee> findAllEmployeesOrderedByName() {

        List<Employee> employees = new ArrayList<>();

        for (Company company : companies.values()) {
            employees.addAll(company.getEmployees());
        }

        employees.sort(Comparator.comparing(Employee::getName));

        return employees;
    }

    @Override
    public List<Employee> findAllEmployeesOrderedBySalary() {

        List<Employee> employees = new ArrayList<>();

        for (Company company : companies.values()) {
            employees.addAll(company.getEmployees());
        }

        employees.sort(Comparator.comparingDouble(Employee::getSalary));

        return employees;
    }

    @Override
    public List<Employee> employees(String company) {

        Company selectedCompany = companies.get(company);

        if (selectedCompany == null) {
            return new ArrayList<>();
        }

        return selectedCompany.getEmployees();
    }

    @Override
    public List<Company> findAllCompanies() {
        return new ArrayList<>(companies.values());
    }
}