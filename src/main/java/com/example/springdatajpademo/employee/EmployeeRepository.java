package com.example.springdatajpademo.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, QueryByExampleExecutor<Employee>
{
//    Page<Employee> findAllByAddress_City(String city, Pageable pageable);
}
