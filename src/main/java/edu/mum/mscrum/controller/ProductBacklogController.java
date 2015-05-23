/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.ProductBacklog;
import edu.mum.mscrum.service.EmployeeService;
import edu.mum.mscrum.service.ProductBacklogService;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
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
 * @author HabibRahman
 */
@Controller
@RequestMapping("/product-backlog")
public class ProductBacklogController {

    @Autowired
    private ProductBacklogService productBacklogService;
    @Autowired
    private EmployeeService employeeService;

    
    
    @RequestMapping({"/", "/list"})
    public String showProductBacklogs(Model model, Principal principal) {

       model.addAttribute("username", principal.getName());
       
       Employee productOwner = employeeService.findByUsername(principal.getName());
       
       model.addAttribute("pbList", productBacklogService.getAllProductBacklogByOwner(productOwner.getId()));
       //model.addAttribute("pbList", productBacklogService.getAllProductBacklog());
        
       return "productbacklog/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createProductBacklog(@ModelAttribute("productbacklog") ProductBacklog productbacklog) {

        return "productbacklog/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createProductBacklog(@ModelAttribute("newPB") @Valid ProductBacklog pb, BindingResult br, RedirectAttributes ra, Principal principal, Model model) {

        model.addAttribute("username", principal.getName());
        
         
        if (br.hasErrors()) {
            return "productbacklog/add";
        } else {
            Employee productOwner =   employeeService.findByUsername(principal.getName()); 
            pb.setProductOwner(productOwner);
                        
            productBacklogService.createProductBacklog(pb);            
            
            ra.addFlashAttribute("message", "Successfully Add New Product Backlog");
            return "redirect:/product-backlog/list";
        }        
    }    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)   
    public String editDetails(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("productbacklog", productBacklogService.findProductBacklog(id));        
        return "productbacklog/edit";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateDetails(@ModelAttribute("productbacklog") @Valid ProductBacklog productbacklog, @PathVariable int id,
            BindingResult br, RedirectAttributes rAttributes, Principal principal,Model model) {

        if (br.hasErrors()) {
            model.addAttribute("productbacklog", productbacklog);
            return "productbacklog/edit";
        } else {
             Employee productOwner =   employeeService.findByUsername(principal.getName()); 
            productbacklog.setProductOwner(productOwner);
            
            productBacklogService.update(productbacklog);
            rAttributes.addFlashAttribute("message", "Successfully updated item");
            return "redirect:/product-backlog/list";

        }

    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int id, Model model, RedirectAttributes rAttributes, Principal principal) {
        model.addAttribute("username", principal.getName());
        productBacklogService.delete(id);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/product-backlog/list";
    }
}
