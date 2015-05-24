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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller class to display burndown chart for user stories,  sprints, release backlogs, product backlogs
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
@RequestMapping("/burndown-chart")
public class BurndownChartController {

    /*
    * Autowired Employee Service layer
    */
    @Autowired
    private EmployeeService employeeService;

    /*
    *   this method is to display burndown bar chart
    *   @param Model model
    *   @param Principal principal
    *   @return String view file name "burndownchart/barchart"
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String viewChart(Model model, Principal principal) {
        Employee empl =   employeeService.findByUsername(principal.getName());
        model.addAttribute("employee", empl);
        return "burndownchart/barchart";
    }
}
