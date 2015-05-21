/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.UpdateDevelopment;
import edu.mum.mscrum.domain.UpdateTesting;
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
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
@RequestMapping("/tester")
public class TesterController {

    @Autowired
    private UserStoryService userStoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(@ModelAttribute("userStory") UserStory userStory, Model model) {
        model.addAttribute("userstories", userStoryService.getList());
        return "tester/list";
    }

    @RequestMapping(value = "/estimate-testing-effort/{id}", method = RequestMethod.GET)
    public String estimateDevEffort(@ModelAttribute("userStory") UserStory userStory, Model model, @PathVariable int id) {
        model.addAttribute("userStory", userStoryService.find(id));
        return "tester/estimateeffort";
    }

    @RequestMapping(value = "/estimate-testing-effort/{id}", method = RequestMethod.POST)
    public String estimateDevEffortSave(@ModelAttribute("userStory") UserStory userStory, Model model, RedirectAttributes ra) {
        model.addAttribute("userstories", userStoryService.getList());
        double edt = userStory.getTesterEstimateTime();
        int usId = userStory.getId();
        UserStory us = userStoryService.find(usId);
        us.setTesterEstimateTime(edt);

        userStoryService.update(us);
        ra.addFlashAttribute("message", "Successfully added estimated time");
        return "redirect:/tester/list";
    }

    @RequestMapping(value = "/update-testing-effort/{id}", method = RequestMethod.GET)
    public String updateDevEffort(@ModelAttribute("userStory") UserStory userStory, Model model, @PathVariable int id) {
        model.addAttribute("userStory", userStoryService.find(id));

        //usId
        model.addAttribute("updateTestings", userStoryService.getUpdateTestings(id));

        return "tester/updateeffort";
    }

    @RequestMapping(value = "/update-testing-effort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateDevEffortSave(@RequestBody String json) throws IOException {

        int usId = 0;
        String res = json.toString();
        List<UpdateTesting> dList = new ArrayList<UpdateTesting>();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(res);
        usId = actualObj.get("usId").asInt();
//        Date updatedDate = (Date)actualObj.get("updatedDate").;
        double testerRemainingTime = actualObj.get("testerRemainingTime").asDouble();
        UpdateTesting ud = new UpdateTesting();

        ud.setTesterRemainingTime(testerRemainingTime);
        ud.setUpdatedDate(new Date());
        dList.add(ud);

        List<UpdateTesting> udNew =   userStoryService.getUpdateTestings(usId);
        for (UpdateTesting nUd : udNew) {
            dList.add(nUd);
        }

        UserStory userStory = userStoryService.find(usId);
        userStory.setUpdateTestings(dList);

        userStoryService.update(userStory);

        return "redirect:/tester/list";
    }

}
