/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.ProductBacklog;
import edu.mum.mscrum.domain.Sprint;
import edu.mum.mscrum.domain.UserStory;
import edu.mum.mscrum.service.EmployeeService;
import edu.mum.mscrum.service.ProductBacklogService;
import edu.mum.mscrum.service.UserStoryService;
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
 * This controller is for user story - add , edit, view , remove.
 *
 * @author HabibRahman
 */
@Controller
@RequestMapping("/user-story")
public class UserStoryController {

    /**
     * Autowired user story service to get all user story operations.
     */
    @Autowired
    private UserStoryService userStoryService;

    /**
     * Autowired product backlog service to get all operations.
     */
    @Autowired
    private ProductBacklogService productBacklogService;

    /**
     * Autowired employee service to get all operations.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * this method is to display user story list.
     *
     * @param model
     * @param principal
     * @return
     */
    @RequestMapping({"/", "/list"})
    public String showUserStories(Model model, Principal principal) {
        model.addAttribute("storyList", userStoryService.getList());
        return "userstory/list";
    }

    /**
     * this method is to display user story add page.
     *
     * @param userstory
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createUserStory(@ModelAttribute("userstory") UserStory userstory) {
        return "userstory/add";
    }

    /**
     * this method is to validate user story data and bind and persist into
     * database.
     *
     * @param userstory
     * @param br
     * @param ra
     * @param principal
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createUserStory(@ModelAttribute("newUStory") @Valid UserStory userstory, BindingResult br, RedirectAttributes ra, Principal principal, Model model) {

        if (br.hasErrors()) {
            return "userstory/add";
        } else {
            Employee productOwner = employeeService.findByUsername(principal.getName());
            userstory.setProductOwner(productOwner);
            userStoryService.create(userstory);
            ra.addFlashAttribute("message", "Successfully Add New User Story");
            return "redirect:/user-story/list";
        }
    }

    /**
     * this method is to populate product backlog data.
     * @param principal
     * @return 
     */
    @ModelAttribute("productbacklogs")
    public List<ProductBacklog> populateProductBacklog(Principal principal) {
        Employee productOwner = employeeService.findByUsername(principal.getName());
        return productBacklogService.getAllProductBacklogByOwner(productOwner.getId());
    }

    /**
     * this method is to display user story edit page.
     * @param id
     * @param model
     * @param principal
     * @return 
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDetails(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("sprint", userStoryService.find(id));
        return "userstory/edit";
    }

    /**
     * this method is to delete user story.
     * @param id
     * @param model
     * @param rAttributes
     * @param principal
     * @return 
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int id, Model model, RedirectAttributes rAttributes, Principal principal) {
        userStoryService.delete(id);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/user-story/";
    }
}
