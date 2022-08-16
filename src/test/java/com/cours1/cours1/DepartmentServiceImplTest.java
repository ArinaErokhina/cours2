package com.cours1.cours1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.*;
import java.util.stream.Collectors;

import static com.cours1.cours1.Constants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    private Employee employee1 = new Employee(NAMEEMPLOYEE1, SURNAMEEMPLOYEE1, DEPARTMENT1, SALARY1);
    private Employee employee2 = new Employee(NAMEEMPLOYEE2, SURNAMEEMPLOYEE2, DEPARTMENT2,SALARY2);

    private Employee employee3 = new Employee(NAMEEMPLOYEE3, SURNAMEEMPLOYEE3, DEPARTMENT3,SALARY3);
    @Mock
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void allEmployeeInDepartmentTest(){
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee1.getNameEmployee()+employee1.getSurnameEmployee(), employee1);
        expected.put(employee2.getNameEmployee()+employee2.getSurnameEmployee(), employee2);

        Collection<Employee> expectedCollection = Collections.unmodifiableCollection(expected.values());
        Mockito.when(employeeService.allEmployee()).thenReturn(expectedCollection);
        Assertions.assertEquals(expectedCollection, employeeService.allEmployee());
    }

    @Test
    public void employeeInDepartmentTest(){
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee1.getNameEmployee()+employee1.getSurnameEmployee(), employee1);
        expected.put(employee2.getNameEmployee()+employee2.getSurnameEmployee(), employee2);
        expected.put(employee3.getNameEmployee()+employee3.getSurnameEmployee(), employee3);

        Collection<Employee> expectedCollection = Collections.unmodifiableCollection(expected.values());
        List<Employee> allEmployeeInDepartment = expectedCollection.stream()
                .filter(employee -> employee.getDepartment() == 2)
                .collect(Collectors.toList());
        Mockito.when(employeeService.allEmployee()).thenReturn(expectedCollection);
        Assertions.assertEquals(allEmployeeInDepartment, departmentService.employeeInDepartment(2));
    }

    @Test
    public void maxSalaryTest(){
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee1.getNameEmployee()+employee1.getSurnameEmployee(), employee1);
        expected.put(employee2.getNameEmployee()+employee2.getSurnameEmployee(), employee2);
        expected.put(employee3.getNameEmployee()+employee3.getSurnameEmployee(), employee3);

        Collection<Employee> expectedCollection = Collections.unmodifiableCollection(expected.values());
        Mockito.when(employeeService.allEmployee()).thenReturn(expectedCollection);
        Assertions.assertEquals(employee2, departmentService.maxSalary(employee2.getDepartment()));
    }

    @Test
    public void minSalaryTest(){
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee1.getNameEmployee()+employee1.getSurnameEmployee(), employee1);
        expected.put(employee2.getNameEmployee()+employee2.getSurnameEmployee(), employee2);
        expected.put(employee3.getNameEmployee()+employee3.getSurnameEmployee(), employee3);

        Collection<Employee> expectedCollection = Collections.unmodifiableCollection(expected.values());
        Mockito.when(employeeService.allEmployee()).thenReturn(expectedCollection);
        Assertions.assertEquals(employee3, departmentService.minSalary(employee3.getDepartment()));
    }




}
