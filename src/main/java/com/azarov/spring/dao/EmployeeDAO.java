package com.azarov.spring.dao;

import com.azarov.spring.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    void save(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
