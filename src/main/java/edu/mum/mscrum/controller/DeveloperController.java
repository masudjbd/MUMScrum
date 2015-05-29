/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.UpdateDevelopment;
import edu.mum.mscrum.domain.UserStory;
import edu.mum.mscrum.service.UserStoryService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * this controller is for developer's operation, like estimate development 
 * time for user stories, update development effort, etc
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
@RequestMapping("/developer")
public class DeveloperController {

    /**
    * Autowired User Story service to get all user story operations.
    */
    @Autowired
    private UserStoryService userStoryService;

     /**
     * This method is to display list of user story.
     * @param userStory
     * @param model
     * @return 
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(@ModelAttribute("userStory") UserStory userStory, Model model) {
        model.addAttribute("userstories", userStoryService.getList());
        return "developer/list";
    }

    /**
     * This method is to estimate user story development time.
     * @param userStory
     * @param model
     * @param id
     * @return String developer/estimateeffort
     */
    @RequestMapping(value = "/estimate-development-effort/{id}", method = RequestMethod.GET)
    public String estimateDevEffort(@ModelAttribute("userStory") UserStory userStory, Model model, @PathVariable int id) {
        model.addAttribute("userStory", userStoryService.find(id));
        return "developer/estimateeffort";
    }

    /**
     * This method is to process estimate development effort/time. 
     * @param userStory
     * @param model
     * @param ra
     * @return 
     */
    @RequestMapping(value = "/estimate-development-effort/{id}", method = RequestMethod.POST)
    public String estimateDevEffortSave(@ModelAttribute("userStory") UserStory userStory, Model model, RedirectAttributes ra) {
        model.addAttribute("userstories", userStoryService.getList());
        double edt = userStory.getDeveloperEstimateTime();
        int usId = userStory.getId();
        UserStory us = userStoryService.find(usId);
        us.setDeveloperEstimateTime(edt);

        userStoryService.update(us);
        ra.addFlashAttribute("message", "Successfully added estimated time");
        return "redirect:/developer/list";
    }

    /** 
     * This method is to display update development effort
     * @param userStory
     * @param model
     * @param id
     * @return 
     */
    @RequestMapping(value = "/update-development-effort/{id}", method = RequestMethod.GET)
    public String updateDevEffort(@ModelAttribute("userStory") UserStory userStory, Model model, @PathVariable int id) {
        model.addAttribute("userStory", userStoryService.find(id));

        //Update Developments List get by User Story Id
        model.addAttribute("updateDevelopments", userStoryService.getUpdateDevelopments(id));

        return "developer/updateeffort";
    }

    /**
     * This method is to update development effort for developer
     * @param json
     * @return
     * @throws IOException 
     */
    @RequestMapping(value = "/update-development-effort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateDevEffortSave(@RequestBody String json) throws IOException {

        int usId = 0;
        String res = json.toString();
        List<UpdateDevelopment> dList = new ArrayList<UpdateDevelopment>();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(res);
        usId = actualObj.get("usId").asInt();
//        Date updatedDate = (Date)actualObj.get("updatedDate").;
        double developerRemainingTime = actualObj.get("developerRemainingTime").asDouble();
        UpdateDevelopment ud = new UpdateDevelopment();

        ud.setDeveloperRemainingTime(developerRemainingTime);
        ud.setUpdatedDate(new Date());
        dList.add(ud);

        List<UpdateDevelopment> udNew =   userStoryService.getUpdateDevelopments(usId);
        for (UpdateDevelopment nUd : udNew) {
            dList.add(nUd);
        }

        UserStory userStory = userStoryService.find(usId);
        userStory.setUpdateDevelopments(dList);

        userStoryService.update(userStory);

        return "redirect:/developer/list";
    }

}
