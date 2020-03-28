package com.tangbear.springbootmvc.controller;

import com.tangbear.springbootmvc.entity.Employee;
import com.tangbear.springbootmvc.service.EmployeeService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    final private EmployeeService employeeService;

    @GetMapping("employee")
    public String get(Model model) {
        model.addAttribute("employees", employeeService.find());
        return "employee";
    }

    @GetMapping("add-employee")
    public String getEmployeeCreatePage(Employee employee) {
        return "add-employee";
    }

    @PostMapping("employee")
    public String create(Employee employee) {
        employeeService.insert(employee);
        return "redirect:/employee";
    }

    @GetMapping("employee/{id}")
    public String update(@PathVariable Long id, Model model) throws NotFoundException {
        model.addAttribute("employee", employeeService.findById(id));
        return "add-employee";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/employee";
    }
}
