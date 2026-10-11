package main.java.edu.upc.eetac.dsa;

import java.util.Date;

public class Employee {

    private String name;
    private String surname;
    private Date birthday;
    private double salary;

    public Employee(String name, String surname, Date birthday, double salary) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public double getSalary() {
        return salary;
    }
}