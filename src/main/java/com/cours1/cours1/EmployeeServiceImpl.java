package com.cours1.cours1;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Федоров", 3, 56000),
            new Employee("Алина", "Смирнова", 2, 70000),
            new Employee("Егор", "Прохоров", 3, 69000),
            new Employee("Роман", "Григорьев", 4, 75000),
            new Employee("Вера", "Кузнецова", 3, 80000),
            new Employee("Максим", "Сидоров", 5, 100000),
            new Employee("Андрей", "Васильев", 1, 85000),
            new Employee("Валерия", "Коровина", 2, 98000),
            new Employee("Иван", "Серков", 4, 45000),
            new Employee("Дмитрий", "Дробков", 1, 77000)
    ));
    private static int maxEmployeeCount = 11;

    public Employee addEmployee(Employee employee) {
        if (maxEmployeeCount == employees.size()) {
            throw new EmployeeStorageIsFullException();
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i))) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        employees.add(employee);
        return employee;
    }

    public Employee deleteEmployee(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i)))
                return employees.remove(i);
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i))) {
                return employees.get(i);
            }
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> allEmployee() {
        return employees;
    }
}
