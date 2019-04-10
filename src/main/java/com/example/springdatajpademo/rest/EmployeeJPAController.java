package com.example.springdatajpademo.rest;

import com.example.springdatajpademo.employee.Employee;
import com.example.springdatajpademo.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/v1/datajpa", produces =  MediaType.APPLICATION_JSON_VALUE)
public class EmployeeJPAController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    Page<Employee> findEmployees(@RequestParam(value = "city", defaultValue = "") String city, Pageable page){
        return employeeRepository.findAll(page);
    }

    @PostMapping("/employees")
    void addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("age") Integer age,
            @RequestParam("occupation") String occupation,
            @RequestParam("salary") Long salary){

        Employee employeeToSave = new Employee();
        employeeToSave.setFirstName(firstName);
        employeeToSave.setLastName(lastName);
        employeeToSave.setAge(age);
        employeeToSave.setOccupation(occupation);
        employeeToSave.setSalary(salary);
        employeeRepository.save(employeeToSave);
    }

    // QBE
    @GetMapping("/software-developers")
    Page<Employee> findSoftwareDevelopers (Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        Employee probe = new Employee();
        probe.setOccupation("Project Manager");

        Example<Employee> example = Example.of(probe, matcher);
        return employeeRepository.findAll(example, pageable);
    }

}
