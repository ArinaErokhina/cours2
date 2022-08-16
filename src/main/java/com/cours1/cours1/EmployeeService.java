package com.cours1.cours1;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public Employee deleteEmployee(Employee employee);

    public Employee findEmployee(Employee employee);

    public Collection<Employee> allEmployee();
}
