/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.service.EmployeeService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
@RequestMapping("/burndown-chart")
public class BurndownChartController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String viewChart(Model model, Principal principal) {
        Employee empl =   employeeService.findByUsername(principal.getName());
        model.addAttribute("employee", empl);
        return "burndownchart/barchart";
    }
}
