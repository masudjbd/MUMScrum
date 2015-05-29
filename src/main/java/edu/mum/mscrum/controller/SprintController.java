/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.ProductBacklog;
import edu.mum.mscrum.domain.ReleaseBacklog;
import edu.mum.mscrum.domain.Sprint;
import edu.mum.mscrum.service.EmployeeService;
import edu.mum.mscrum.service.ProductBacklogService;
import edu.mum.mscrum.service.ReleaseBacklogService;
import edu.mum.mscrum.service.SprintService;
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
 * This controller is to sprint - add, edit, view, delete.
 *
 * @author HabibRahman
 */
@Controller
@RequestMapping("/sprint")
public class SprintController {

    /**
     * Autowired sprint services to get all sprint operations.
     */
    @Autowired
    private SprintService springService;

    /**
     * Autowired release backlog to get all release backlog operations.
     */
    @Autowired
    private ReleaseBacklogService releaseBacklogService;

    /**
     * Autowired employee service to get all employee operation.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * This method is to display sprint list.
     *
     * @param model
     * @param principal
     * @return
     */
    @RequestMapping({"/", "/list"})
    public String showSprints(Model model, Principal principal) {
        Employee productOwner = employeeService.findByUsername(principal.getName());
        model.addAttribute("sprintList", springService.getAllSprintByOwner(productOwner.getId()));
        return "sprint/list";
    }

    /**
     * This method is to display sprint add page.
     *
     * @param sprint
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createSprint(@ModelAttribute("sprint") Sprint sprint) {
        return "sprint/add";
    }

    /**
     * This method is to validate sprint data and bind and persist into
     * database.
     *
     * @param sprint
     * @param br
     * @param ra
     * @param principal
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createProductBacklog(@ModelAttribute("newSprint") @Valid Sprint sprint, BindingResult br, RedirectAttributes ra, Principal principal, Model model) {

        if (br.hasErrors()) {
            return "sprint/add";
        } else {
            Employee scrumMaster = employeeService.findByUsername(principal.getName());
            sprint.setScrumMaster(scrumMaster);
            springService.create(sprint);
            ra.addFlashAttribute("message", "Successfully Add New Sprint");
            return "redirect:/sprint/list";
        }
    }

    /**
     * This method is to populate release backlog data.
     *
     * @param principal
     * @return
     */
    @ModelAttribute("releasebacklogs")
    public List<ReleaseBacklog> populateReleaseBacklog(Principal principal) {
        Employee productOwner = employeeService.findByUsername(principal.getName());
        return releaseBacklogService.getAllReleaseBacklogByOwner(productOwner.getId());
    }

    /**
     * This method is to display sprint edit page
     * @param id
     * @param model
     * @param principal
     * @return 
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDetails(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("sprint", springService.find(id));
        return "sprint/edit";
    }

    /**
     * This method is to remove sprint item. 
     * @param id
     * @param model
     * @param rAttributes
     * @param principal
     * @return 
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int id, Model model, RedirectAttributes rAttributes, Principal principal) {
        springService.delete(id);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/sprint/";
    }

}
