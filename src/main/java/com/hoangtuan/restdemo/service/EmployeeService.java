package com.hoangtuan.restdemo.service;

import com.hoangtuan.restdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee theEmployee);

    List<Employee> findAll();

    List<Employee> find(Integer id, String theFirstName, String theLastName, String theEmail);

    Employee findById(int theId);

    Employee findByFirstName(String theFirstName);

    Employee findByLastName(String theLastName);

    Employee findByEmail(String theEmail);

    void deleteById(int theId);

    void deleteByFirstName(String theFirstName);

    void deleteByLastName(String theLastName);

    void deleteByEmail(String theEmail);

}
