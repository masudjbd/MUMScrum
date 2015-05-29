/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.Insurance;
import edu.mum.mscrum.domain.InsuranceType;
import edu.mum.mscrum.service.EmployeeService;
import edu.mum.mscrum.service.InsuranceService;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * This controller is to display insurance compensation to employee and update their packages
 * @author Rhyhan
 */
@Controller
@RequestMapping("/insurance")
public class InsuranceController {
    
    /**
     * Autowired Insurance Services to get all insurance operations.
     */
    @Autowired
    private InsuranceService  insuranceservice;
    
    /**
     * Autowired Employee services to get all employee operations.
     */
    @Autowired
    private EmployeeService employeeService;
    
    /**
     * This method is to populate employee list so that we can get from view
     * @return 
     */
    @ModelAttribute("employees")
    List<Employee> populateAllEmployee(){
        return employeeService.getEmployees();
    }
    
    /**
     * This method is to get insurance type so that we can get from view
     * @return 
     */
    @ModelAttribute("insurancetypes")
    List<InsuranceType> populateAllLeave(){
        return insuranceservice.getAllList();
    }
    
    /**
     * This method is to display insurance add page.
     * @param insurance
     * @return 
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addleave(@ModelAttribute("insurance") Insurance insurance) {  
        return "insurance/add";
    }
    
    /**
     * This method is to bind insurance data and persist into database and based
     * on success redirect to list page.
     * @param insurance
     * @param br
     * @param ra
     * @param principal
     * @param model
     * @return 
     */
     @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProcess(@Valid Insurance insurance, BindingResult br, RedirectAttributes ra, Principal principal, Model model) {
       model.addAttribute("username", principal.getName());
        if (br.hasErrors()) {
            return "insurance/add";
        } else {
           insuranceservice.create(insurance);
            ra.addFlashAttribute("message", "Successfully added Insurance");
            return "redirect:/insurance/list";
        }
    }
//     @RequestMapping(value = "/details/{inId}", method = RequestMethod.GET)
//    public String details(@PathVariable int inId, Model model, Principal principal) {
//        model.addAttribute("username", principal.getName());
//        model.addAttribute("insurance", insuranceservice.find(inId));
//        return "insurance/details";
//
//   }
    
    /**
     * This method is to display insurance benefit lists for each employee.
     * @param model
     * @param principal
     * @return 
     */
    @RequestMapping({"/", "/list"})
    public String getList(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("insurance", insuranceservice.getInsurance());

        return "insurance/list";
    }  
//     @RequestMapping({"/", "/list"})
//    public String getList(Model model, Principal principal) {
//        model.addAttribute("username", principal.getName());
//        model.addAttribute("insurance", insuranceservice.getInsurance());
//        return "insurance/list";
//    }  
    
    /**
     * This method is to remove insurance benefit for employee.
     * @param inId
     * @param model
     * @param rAttributes
     * @param principal
     * @return 
     */
    @RequestMapping(value = "/delete/{inId}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int inId, Model model, RedirectAttributes rAttributes, Principal principal) {
        model.addAttribute("username", principal.getName());
        insuranceservice.delete(inId);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/insurance/";
    }
}


