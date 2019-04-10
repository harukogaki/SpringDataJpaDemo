package com.example.springdatajpademo.employee;

import com.example.springdatajpademo.adress.Address;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String occupation;
    private Long salary;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;


    public Employee(String firstName, String lastName, Integer age, String occupation, Long salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.occupation = occupation;
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public Address getAddress() {
        return address;
    }

    public Long getSalary() {
        return salary;
    }

}
