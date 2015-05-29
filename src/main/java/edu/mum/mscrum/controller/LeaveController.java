/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.Employeevacation;
import edu.mum.mscrum.domain.LeaveType;
import edu.mum.mscrum.service.EmployeeService;
import edu.mum.mscrum.service.LeaveService;
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
 * This controller is to display, add , update and remove employee leave/vacation
 * @author Rhyhan
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

    /**
     * Autowired leave service to get all leave/vacation related operation.
     */
    @Autowired
    private LeaveService leaveService;
    
    /**
     * Autowired employee service to get all employee related operation.
     */
    @Autowired
    EmployeeService employeeService;

    /**
     * This method is to display employee vacation add page.
     * @param empvac
     * @return 
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addleave(@ModelAttribute("empvac") Employeevacation empvac) {  
        return "leave/add";
    }
    
    /**
     * This method is to bind employee vacation data and persist into database and 
     * based on success redirect to list page.
     * @param empvac
     * @param br
     * @param ra
     * @param principal
     * @param model
     * @return 
     */
     @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProcess(@Valid Employeevacation empvac, BindingResult br, RedirectAttributes ra, Principal principal, Model model) {
       model.addAttribute("username", principal.getName());
        if (br.hasErrors()) {
            return "leave/add";
        } else {
           leaveService.create(empvac);
            ra.addFlashAttribute("message", "Successfully added Leave");
            return "redirect:/leave/list";
        }
    }
    
    /**
     * This method is to populate employee list
     * @return 
     */
    @ModelAttribute("employees")
    List<Employee> populateAllEmployee(){
        return employeeService.getEmployees();
    }
    
    /**
     * This method is to get leave types.
     * @return 
     */
    @ModelAttribute("leavetypes")
    List<LeaveType> populateAllLeave(){
        return leaveService.getAllList();
    }
    
    /**
     * This method is to display leave type page
     * @param ltype
     * @return 
     */
    @RequestMapping(value = "/leavetype", method = RequestMethod.GET)
    public String addleavetype(@ModelAttribute("ltype") LeaveType ltype) {        
        return "leave/leavetype";
    }
    
    /**
     * This method is to display list of vacation with employee.
     * @param model
     * @param principal
     * @return 
     */
     @RequestMapping({"/", "/list"})
    public String getList(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("empvac", leaveService.getVacation());

        return "leave/list";
    }    
    
    /**
     * This method is to remove employee vacation.
     * @param leaveid
     * @param model
     * @param rAttributes
     * @param principal
     * @return 
     */
     @RequestMapping(value = "/delete/{leaveid}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int leaveid, Model model, RedirectAttributes rAttributes, Principal principal) {
        model.addAttribute("username", principal.getName());
        leaveService.delete(leaveid);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/leave/";
    }
    
    /**
     * This method is to display each vacation details.
     * @param leaveid
     * @param model
     * @param principal
     * @return 
     */
    @RequestMapping(value = "/details/{leaveid}", method = RequestMethod.GET)
    public String details(@PathVariable int leaveid, Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("empvac", leaveService.find(leaveid));
        return "leave/details";

   } 
}
