/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.Role;
import edu.mum.mscrum.service.EmployeeService;
import edu.mum.mscrum.util.GenericDao;
import edu.mum.mscrum.util.GenericDaoImpl;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
     
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping({"/", "/list"})
    public String getList(Model model, Principal principal) {

//        Employee empl = new Employee();
//        empl.setName("Masudur Rahman");
//        empl.setAddress("Fairfield, IA");
//        empl.setMobile("02005");
//        empl.setEmail("masudjbd@gmail.com");
//
//        employeeService.create(empl);
        model.addAttribute("username", principal.getName());

        model.addAttribute("employees", employeeService.getEmployees());

        return "employee/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(@ModelAttribute("employee") Employee employee, Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "employee/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProcess(@Valid Employee employee, BindingResult br, RedirectAttributes ra, Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        if (br.hasErrors()) {
            return "employee/add";
        } else {
            employeeService.create(employee);
            ra.addFlashAttribute("message", "Successfully added employee");
            return "redirect:/employee/list";
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("employee", employeeService.find(id));
        return "employee/details";

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getDetails(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("employee", employeeService.find(id));
        return "employee/edit";

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateDetails(Model model, @Valid Employee employee, @PathVariable int id,
            BindingResult br, RedirectAttributes rAttributes, Principal principal) {
        model.addAttribute("username", principal.getName());

        if (br.hasErrors()) {
            model.addAttribute("employee", employee);
            return "employee/edit";
        } else {
            employeeService.update(employee);
            rAttributes.addFlashAttribute("message", "Successfully updated item");
            return "redirect:/employee/";

        }

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int id, Model model, RedirectAttributes rAttributes, Principal principal) {
        model.addAttribute("username", principal.getName());
        employeeService.delete(id);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/employee/";
    }

    @RequestMapping(value = "/assignrole", method = RequestMethod.GET)
    public String getAssignRole(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("roles", employeeService.getRoles());
        return "employee/assignrole";

    }

    @RequestMapping(value = "/assignrole", method = RequestMethod.POST)
    @ResponseBody
    public String updateAssignRole(@RequestBody String json) throws IOException {
        int empId = 0;
        List<Role> rL = new ArrayList<Role>();
        String res = json.toString();
        

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(res);
        empId = actualObj.get("id").asInt();

        Employee empl = employeeService.find(empId);

        String lp = "";
        JsonNode arrNode = actualObj.get("roles");

        Iterator<JsonNode> ite = arrNode.getElements();

        while (ite.hasNext()) {
            JsonNode temp = ite.next();
            System.out.println(temp.getTextValue());
            lp += temp.getTextValue();
            

        }
        
        
        return lp + "working " + res + " >> " + actualObj.get("id") + " " + empl.getFirstname();
    }

}
