/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.ReleaseBacklog;
import edu.mum.mscrum.service.ReleaseBacklogService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HabibRahman
 */
@Controller
@RequestMapping("/ajaxhandler")
public class AjaxHandler {

    @Autowired
    private ReleaseBacklogService releaseBacklogService;

    @RequestMapping(value = "/selectRB", method = RequestMethod.POST)
    public @ResponseBody
    List<ReleaseBacklog> getSelectedReleaseBacklog(HttpServletRequest request, HttpServletResponse response) {
        int pbId = Integer.parseInt(request.getParameter("pbId"));
        return releaseBacklogService.filterByProductBacklogId(pbId);

//String m = json.toString();        
        //ObjectMapper mapper = new ObjectMapper();
        //JsonNode actualObj = mapper.readTree(m);
//        int pb = actualObj.get("pb").asInt();
        //ObjectMapper mapper = new ObjectMapper();
        //mapper.readV
//        Person requesValue = mapper.readValue(json, 
//                Person.class);
//        Person person = new Person();
//        person.setName(requesValue.getName());
//        person.setLocation(requesValue.getLocation());
//        Random rand = new Random();
//        float r = rand.nextFloat() * 100;
//        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
//        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
//        return result;
        //return "this is output " + pb + rb;
    }
}
