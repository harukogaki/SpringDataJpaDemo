package com.example.springdatajpademo.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class EmployeeRepositoryImpl {
    @PersistenceContext
    EntityManager entityManager;

    public Page<Employee> findAll(Pageable pageable) {

        int count = entityManager.createQuery("select count(*) from Employee emp").getFirstResult();

        String query = "SELECT emp FROM Employee emp";
        try (Stream<Employee> resultStream = entityManager.createQuery(query, Employee.class).getResultStream()) {
            List<Employee> page =
                    resultStream
                            .skip(pageable.getOffset())
                            .limit(pageable.getPageSize())
                            .collect(Collectors.toList());
            return new PageImpl<>(page, pageable, count);
        }

    }

    public void save (Employee employee) {
        entityManager.persist(employee);

    }
}
