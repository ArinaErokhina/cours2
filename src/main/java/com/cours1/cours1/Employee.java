package com.cours1.cours1;

import java.util.Objects;

public class Employee {
    private String nameEmployee;
    private String surnameEmployee;
    private int department;
    private int salary;


    public Employee(String nameEmployee, String surnameEmployee, int department, int salary) {
        this.nameEmployee = nameEmployee;
        this.surnameEmployee = surnameEmployee;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String nameEmployee, String surnameEmployee) {
        this.nameEmployee = nameEmployee;
        this.surnameEmployee = surnameEmployee;
    }

    public String getNameEmployee() {
        return this.nameEmployee;
    }

    public String getSurnameEmployee() {
        return this.surnameEmployee;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Ф.И.О: " + surnameEmployee + " " + nameEmployee + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return nameEmployee.equals(employee.nameEmployee) && surnameEmployee.equals(employee.surnameEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameEmployee, surnameEmployee);
    }
}

