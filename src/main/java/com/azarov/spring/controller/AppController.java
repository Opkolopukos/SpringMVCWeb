package com.azarov.spring.controller;

import com.azarov.spring.entity.Employee;
import com.azarov.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AppController {

    private final EmployeeService employeeService;

    @Autowired
    public AppController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all_employees";
    }

    @RequestMapping("/AddNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute(employee);
        return "employee_info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam(name = "empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee_info";
    }
    @RequestMapping("/deleteInfo")
    public String deleteEmployee(@RequestParam(name = "empId") int id, Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
