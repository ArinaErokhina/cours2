package com.cours1.cours1;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static Map<String, Employee> employees = new HashMap<>();
    private static int maxEmployeeCount = 2;

    public Employee addEmployee(Employee employee) {
        if (employee.getNameEmployee() == null || employee.getSurnameEmployee() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (maxEmployeeCount == employees.size()) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getNameEmployee()+employee.getSurnameEmployee())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getNameEmployee()+employee.getSurnameEmployee(), employee);
        return employee;
    }

    public Employee deleteEmployee(Employee employee) {
        if (employee.getNameEmployee() == null || employee.getSurnameEmployee() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (employees.containsKey(employee.getNameEmployee()+employee.getSurnameEmployee()))
            return employees.remove(employee.getNameEmployee()+employee.getSurnameEmployee());

        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(Employee employee) {
        if (employee.getNameEmployee() == null || employee.getSurnameEmployee() == null) {
            throw new EmployeeDataEnteredIncorrectlyException();
        }
        if (employees.containsKey(employee.getNameEmployee()+employee.getSurnameEmployee())) {
            return employees.get(employee.getNameEmployee()+employee.getSurnameEmployee());
       }

        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> allEmployee() {
        return Collections.unmodifiableCollection(employees.values());
    }


}