/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping({"/", "/list"})
    public String getList(Model model) {

        Employee empl = new Employee();
        empl.setName("Masudur Rahman");
        empl.setAddress("Fairfield, IA");
        empl.setMobile("02005");
        empl.setEmail("masudjbd@gmail.com");

        employeeService.create(empl);

        model.addAttribute("employees", employeeService.getEmployees());

        return "employee/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(Employee employee) {
        return "employee/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProcess(Employee employee, BindingResult br, RedirectAttributes ra) {
        if (br.hasErrors()) {
            return "employee/add";
        } else {
            employeeService.create(employee);
            ra.addFlashAttribute("message", "Successfully added employee");
            return "redirect:/employee/list";
        }
    }
}
