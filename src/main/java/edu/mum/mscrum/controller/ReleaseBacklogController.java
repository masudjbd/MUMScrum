/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.ProductBacklog;
import edu.mum.mscrum.domain.ReleaseBacklog;
import edu.mum.mscrum.service.EmployeeService;

import edu.mum.mscrum.service.ProductBacklogService;
import edu.mum.mscrum.service.ReleaseBacklogService;
import java.security.Principal;
import java.util.ArrayList;
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
 * @author HabibRahman
 */
@Controller
@RequestMapping("/release-backlog")
public class ReleaseBacklogController {

    @Autowired
    private ReleaseBacklogService ReleaseBacklogService;
    @Autowired
    private ProductBacklogService productBacklogService;
    @Autowired
    private EmployeeService employeeService;

    
    
    @RequestMapping({"/", "/list"})
    public String showReleaseBacklogs(Model model, Principal principal) {

        model.addAttribute("username", principal.getName());

        Employee productOwner = employeeService.findByUsername(principal.getName());
        model.addAttribute("rbList", ReleaseBacklogService.getAllReleaseBacklogByOwner(productOwner.getId()));
        return "releasebacklog/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createReleaseBacklog(@ModelAttribute("releasebacklog") ReleaseBacklog releasebacklog) {
        return "releasebacklog/add";
    }

    @ModelAttribute("productbacklogs")
    public List<ProductBacklog> populateProductBacklog(Principal principal) {
        Employee productOwner = employeeService.findByUsername(principal.getName());
        return productBacklogService.getAllProductBacklogByOwner(productOwner.getId());

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createReleaseBacklog(@ModelAttribute("newRB") @Valid ReleaseBacklog rb, BindingResult br, RedirectAttributes ra, Principal principal, Model model) {

        model.addAttribute("username", principal.getName());

        if (br.hasErrors()) {
            return "releasebacklog/add";
        } else {
            Employee productOwner = employeeService.findByUsername(principal.getName());
            rb.setProductOwner(productOwner);
            ReleaseBacklogService.createReleaseBacklog(rb);
            ra.addFlashAttribute("message", "Successfully Added New Release Backlog");
            return "redirect:/release-backlog/list";
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDetails(@PathVariable int id, @ModelAttribute("releasebacklog") ReleaseBacklog releasebacklog, Model model, Principal principal) {
        model.addAttribute("releasebacklog", ReleaseBacklogService.findReleaseBacklog(id));
        return "releasebacklog/edit";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateDetails(@ModelAttribute("releasebacklog") @Valid ReleaseBacklog releasebacklog, @PathVariable int id,
            BindingResult br, RedirectAttributes rAttributes, Principal principal,Model model) {

        if (br.hasErrors()) {
            model.addAttribute("releasebacklog", releasebacklog);
            return "releasebacklog/edit";
        } else {
             Employee productOwner = employeeService.findByUsername(principal.getName());
            releasebacklog.setProductOwner(productOwner);
            ReleaseBacklogService.update(releasebacklog);
            rAttributes.addFlashAttribute("message", "Successfully updated item");
            return "redirect:/release-backlog/list";

        }

    }
    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int id, Model model, RedirectAttributes rAttributes, Principal principal) {
        model.addAttribute("username", principal.getName());
        ReleaseBacklogService.delete(id);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/release-backlog/";
    }

    @RequestMapping(value = "/assign-scrummaster", method = RequestMethod.GET)
    public String assignScrumMasterToRelease(Model model) {

        model.addAttribute("productbacklogs", productBacklogService.getAllProductBacklog());
        model.addAttribute("releasebacklogs", ReleaseBacklogService.getAllReleaseBacklog());
        model.addAttribute("scrummasters", employeeService.findAllScrumMasters());

        return "releasebacklog/assignsm";

    }
}
