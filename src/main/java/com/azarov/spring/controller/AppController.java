package com.azarov.spring.controller;

import com.azarov.spring.dao.EmployeeDAO;
import com.azarov.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public AppController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeDAO.findAll();
        model.addAttribute("allEmps", allEmployees);
        return "all_employees";
    }
}
