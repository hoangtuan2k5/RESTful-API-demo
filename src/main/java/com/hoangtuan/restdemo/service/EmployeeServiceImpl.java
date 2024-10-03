package com.hoangtuan.restdemo.service;

import com.hoangtuan.restdemo.dao.EmployeeRepository;
import com.hoangtuan.restdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> find(Integer id, String theFirstName, String theLastName, String theEmail) {
        return employeeRepository.find(id, theFirstName, theLastName, theEmail);
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
    }

    @Override
    public Employee findByFirstName(String theFirstName) {
        Optional<Employee> result = employeeRepository.findByFirstName(theFirstName);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find employee first name - " + theFirstName);
        }
    }

    @Override
    public Employee findByLastName(String theLastName) {
        Optional<Employee> result = employeeRepository.findByLastName(theLastName);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find employee last name - " + theLastName);
        }
    }

    @Override
    public Employee findByEmail(String theEmail) {
        Optional<Employee> result = employeeRepository.findByEmail(theEmail);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find employee email - " + theEmail);
        }
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }

    @Override
    public void deleteByFirstName(String theFirstName) {
        employeeRepository.deleteByFirstName(theFirstName);
    }

    @Override
    public void deleteByLastName(String theLastName) {
        employeeRepository.deleteByLastName(theLastName);
    }

    @Override
    public void deleteByEmail(String theEmail) {
        employeeRepository.deleteByEmail(theEmail);
    }
}
