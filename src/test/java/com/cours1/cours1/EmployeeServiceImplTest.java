package com.cours1.cours1;

import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.cours1.cours1.Constants.*;

public class EmployeeServiceImplTest {

    private EmployeeService employeeService;
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp(){
        employeeService = new EmployeeServiceImpl();
        employee1 = new Employee(NAMEEMPLOYEE1, SURNAMEEMPLOYEE1, DEPARTMENT1, SALARY1);
        employee2 = new Employee(NAMEEMPLOYEE2, SURNAMEEMPLOYEE2, DEPARTMENT2, SALARY2);
    }


    @Test
    public void addEmployeeTest() {
        Assertions.assertEquals(employee1, employeeService.addEmployee(employee1));
    }

    @Test
    public void addEmployeeEmployeeDataEnteredIncorrectlyExceptionTest() {
        Employee brokenEmployee = new Employee(NAMEEMPLOYEE1, null, DEPARTMENT1, SALARY1);
        Assertions.assertThrows(EmployeeDataEnteredIncorrectlyException.class,
                () -> employeeService.addEmployee(brokenEmployee));
    }

    @Test
    public void addEmployeeEmployeeStorageIsFullException() {
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee1);
        Assertions.assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.addEmployee(employee1));
   }

    @Test
    public void addEmployeeAlreadyAddedException(){
        employeeService.addEmployee(employee1);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
               () -> employeeService.addEmployee(employee1));
    }

    @Test
    public void deleteEmployeeTest(){
        employeeService.addEmployee(employee1);
        Assertions.assertEquals(employee1, employeeService.deleteEmployee(employee1));
    }

    @Test
    public void deleteEmployeeEmployeeDataEnteredIncorrectlyExceptionTest() {
        Employee brokenEmployee = new Employee(NAMEEMPLOYEE1, null, DEPARTMENT1, SALARY1);
        Assertions.assertThrows(EmployeeDataEnteredIncorrectlyException.class,
                () -> employeeService.deleteEmployee(brokenEmployee));
    }

    @Test
    public void deleteEmployeeNotFoundException(){
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.deleteEmployee(employee2));
    }

    @Test
    public void findEmployeeTest(){
        employeeService.addEmployee(employee1);
        Assertions.assertEquals(employee1, employeeService.findEmployee(employee1));
    }

    @Test
    public void findEmployeeEmployeeDataEnteredIncorrectlyExceptionTest() {
        Employee brokenEmployee = new Employee(NAMEEMPLOYEE1, null, DEPARTMENT1, SALARY1);
        Assertions.assertThrows(EmployeeDataEnteredIncorrectlyException.class,
                () -> employeeService.findEmployee(brokenEmployee));
    }

    @Test
    public void findEmployeeNotFoundException(){
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee(employee2));
    }

    @Test
    public void allEmployeeTest(){
        Collection<Employee> actual = employeeService.allEmployee();
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee1.getNameEmployee()+employee1.getSurnameEmployee(), employee1);
        Collection<Employee> expectedCollection = Collections.unmodifiableCollection(expected.values());
        Assertions.assertTrue(expectedCollection.containsAll(actual));
    }
}
