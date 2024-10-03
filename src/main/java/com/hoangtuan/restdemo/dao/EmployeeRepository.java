package com.hoangtuan.restdemo.dao;

import com.hoangtuan.restdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE " +
            "(:id IS NULL OR e.id = :id) AND " +
            "(:firstName IS NULL OR e.firstName LIKE CONCAT('%', :firstName, '%')) AND " +
            "(:lastName IS NULL OR e.lastName LIKE CONCAT('%', :lastName, '%')) AND " +
            "(:email IS NULL OR e.email LIKE CONCAT('%', :email, '%'))")
    List<Employee> find(@Param("id") Integer id,
                        @Param("firstName") String firstName,
                        @Param("lastName") String lastName,
                        @Param("email") String email);

    Optional<Employee> findByFirstName(String theFirstName);

    Optional<Employee> findByLastName(String theLastName);

    Optional<Employee> findByEmail(String theEmail);

    void deleteByFirstName(String theFirstName);

    void deleteByLastName(String theLastName);

    void deleteByEmail(String theEmail);

}
