package com.cours1.cours1;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    public Employee maxSalary(int department);
    public Employee minSalary(int department);
    public List<Employee> employeeInDepartment(int department);
    public List<Employee> allEmployeeInDepartment();
}
