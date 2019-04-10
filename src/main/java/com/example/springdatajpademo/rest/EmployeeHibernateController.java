package com.example.springdatajpademo.rest;

import com.example.springdatajpademo.employee.Employee;
import com.example.springdatajpademo.employee.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/v1/hibernate", produces =  MediaType.APPLICATION_JSON_VALUE)
public class EmployeeHibernateController {

    @Autowired
    private EmployeeRepositoryImpl employeeRepositoryImpl;


    @GetMapping("/employees")
    Page<Employee> findEmployeesHibernate(Pageable pageable){

        return employeeRepositoryImpl.findAll(pageable);
    }

    @PostMapping("/employees")
    @ResponseBody
    void addEmployeeHibernate(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("age") Integer age,
            @RequestParam("occupation") String occupation,
            @RequestParam("salary") Long salary
    ) {

        Employee employeeToSave = new Employee();
        employeeToSave.setFirstName(firstName);
        employeeToSave.setLastName(lastName);
        employeeToSave.setAge(age);
        employeeToSave.setOccupation(occupation);
        employeeToSave.setSalary(salary);
        employeeRepositoryImpl.save(employeeToSave);
    }


}
