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
 *
 * @author HabibRahman
 */
@Controller
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    private SprintService springService;

    @Autowired
    private ReleaseBacklogService releaseBacklogService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping({"/", "/list"})
    public String showSprints(Model model, Principal principal) {

        model.addAttribute("username", principal.getName());

        Employee productOwner = employeeService.findByUsername(principal.getName());
        model.addAttribute("sprintList", springService.getAllSprintByOwner(productOwner.getId()));

        //model.addAttribute("sprintList", springService.getList());
        return "sprint/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createSprint(@ModelAttribute("sprint") Sprint sprint) {

        return "sprint/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createProductBacklog(@ModelAttribute("newSprint") @Valid Sprint sprint, BindingResult br, RedirectAttributes ra, Principal principal, Model model) {

        model.addAttribute("username", principal.getName());

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

    @ModelAttribute("releasebacklogs")
    public List<ReleaseBacklog> populateReleaseBacklog(Principal principal) {

        Employee productOwner = employeeService.findByUsername(principal.getName());
        return releaseBacklogService.getAllReleaseBacklogByOwner(productOwner.getId());

        //return releaseBacklogService.getAllReleaseBacklog();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDetails(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("sprint", springService.find(id));
        return "/sprint/edit";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int id, Model model, RedirectAttributes rAttributes, Principal principal) {
        model.addAttribute("username", principal.getName());
        springService.delete(id);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/sprint/";
    }

}
