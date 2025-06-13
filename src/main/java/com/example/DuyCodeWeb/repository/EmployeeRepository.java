package com.example.DuyCodeWeb.repository;

import com.example.DuyCodeWeb.entity.Employee;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
