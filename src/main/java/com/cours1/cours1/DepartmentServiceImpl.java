package com.cours1.cours1;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalary(int department) {
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee minSalary(int department){
        return employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public List<Employee> employeeInDepartment(int department){
        List<Employee> allEmployeeInDepartment = employeeService.allEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
        return allEmployeeInDepartment;
    }

    public List<Employee> allEmployeeInDepartment(){
        List<Employee> allEmployee = employeeService.allEmployee().stream()
                .sorted(Comparator.comparingInt(employee -> employee.getDepartment()))
                .toList();
        return allEmployee;
    }

}
