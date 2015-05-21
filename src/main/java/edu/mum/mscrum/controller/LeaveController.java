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
 *
 * @author Rhyhan
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addleave(@ModelAttribute("empvac") Employeevacation empvac) {  
        return "leave/add";
    }
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
    
    @ModelAttribute("employees")
    List<Employee> populateAllEmployee(){
        return employeeService.getEmployees();
    }
    
    @ModelAttribute("leavetypes")
    List<LeaveType> populateAllLeave(){
        return leaveService.getAllList();
    }
    @RequestMapping(value = "/leavetype", method = RequestMethod.GET)
    public String addleavetype(@ModelAttribute("ltype") LeaveType ltype) {        
        return "leave/leavetype";
    }
     @RequestMapping({"/", "/list"})
    public String getList(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("empvac", leaveService.getVacation());

        return "leave/list";
    }    
    
     @RequestMapping(value = "/delete/{leaveid}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int leaveid, Model model, RedirectAttributes rAttributes, Principal principal) {
        model.addAttribute("username", principal.getName());
        leaveService.delete(leaveid);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/leave/";
    }
    
    @RequestMapping(value = "/details/{leaveid}", method = RequestMethod.GET)
    public String details(@PathVariable int leaveid, Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("empvac", leaveService.find(leaveid));
        return "leave/details";

   }
//   @RequestMapping(value = "/edit/{leaveid}", method = RequestMethod.GET)
//    public String getDetails(@PathVariable int leaveid, Model model, Principal principal) {
//        model.addAttribute("username", principal.getName());
//        model.addAttribute("empvac", leaveService.find(leaveid));
////        model.addAttribute("employees", employeeService.getEmployees());
//        return "leave/edit";
//
//    }
////    
////     @RequestMapping(value = "/edit/{leaveid}", method = RequestMethod.POST)
////    public String updateDetails(Model model, @Valid Employeevacation empvac, @PathVariable int leaveid,
////            BindingResult br, RedirectAttributes rAttributes, Principal principal) {
////        model.addAttribute("username", principal.getName());
////
////        if (br.hasErrors()) {
////            model.addAttribute("empvac", empvac);
////            return "leave/edit";
////        } else {
////            leaveService.update(empvac);
////            rAttributes.addFlashAttribute("message", "Successfully updated item");
////            return "redirect:/leave/list";
////
////        }
////    }
////    
////      @InitBinder
////    protected void initBinder(WebDataBinder binder) {
////        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
////        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
////    }
//
//   

}
