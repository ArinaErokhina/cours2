package com.cours1.cours1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam("department") int department){
        return departmentService.maxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam("department") int department){
        return departmentService.minSalary(department);
    }

    @GetMapping(path = "/all")
    public List<Employee> employeeInDepartment(@RequestParam("department") int department){
        return departmentService.employeeInDepartment(department);
    }

    @GetMapping(path = "/all-employee")
    public List<Employee> allEmployeeInDepartment(){
        return departmentService.allEmployeeInDepartment();
    }
}
