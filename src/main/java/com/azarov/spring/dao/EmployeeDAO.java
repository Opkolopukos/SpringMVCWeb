package com.azarov.spring.dao;

import com.azarov.spring.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
