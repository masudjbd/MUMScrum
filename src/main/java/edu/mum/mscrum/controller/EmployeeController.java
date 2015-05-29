/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.mscrum.controller;

import edu.mum.mscrum.domain.Employee;
import edu.mum.mscrum.domain.Role;
import edu.mum.mscrum.service.EmployeeService;
import edu.mum.mscrum.service.RoleService;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * this controller is to create, display list of employee, update and remove
 * employee
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    /**
     * Autowired employee services to get all operation.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * This method is to bind data format / field level access modifier
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /**
     * This method is to display all employee list view.
     *
     * @param model
     * @param principal
     * @return
     */
    @RequestMapping({"/", "/list"})
    public String getList(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("employees", employeeService.getEmployees());

        return "employee/list";
    }

    /**
     * This method is to display employee create page.
     *
     * @param employee
     * @param principal
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(@ModelAttribute("employee") Employee employee, Principal principal, Model model) {
        return "employee/add";
    }

    /**
     * This method is to process employee data, it will bind employee data from
     * form and bind into employee object and persist into database
     *
     * @param employee
     * @param br
     * @param ra
     * @param principal
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProcess(@Valid Employee employee, BindingResult br, RedirectAttributes ra, Principal principal, Model model) {

        //password hashing by bcrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(hashedPassword);

        if (br.hasErrors()) {
            return "employee/add";
        } else {
            employee.setEnabled(true);
            employeeService.create(employee);
            ra.addFlashAttribute("message", "Successfully added employee");
            return "redirect:/employee/list";
        }
    }

    /**
     * This method is to display single employee details view.
     *
     * @param id
     * @param model
     * @param principal
     * @return
     */
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("employee", employeeService.find(id));
        return "employee/details";

    }

    /**
     * This method is to display empoyee update page.
     *
     * @param id
     * @param model
     * @param principal
     * @return
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getDetails(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("employee", employeeService.find(id));
        return "employee/edit";

    }

    /**
     * This method is to bind empoyee updated data bind into empoyee object and
     * persist/merge into database.
     *
     * @param model
     * @param employee
     * @param id
     * @param br
     * @param rAttributes
     * @param principal
     * @return
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateDetails(Model model, @Valid Employee employee, @PathVariable int id,
            BindingResult br, RedirectAttributes rAttributes, Principal principal) {

        if (br.hasErrors()) {
            model.addAttribute("employee", employee);
            return "employee/edit";
        } else {
            employeeService.update(employee);
            rAttributes.addFlashAttribute("message", "Successfully updated item");
            return "redirect:/employee/";

        }

    }

    /**
     * This method is to remove empoyee
     *
     * @param id
     * @param model
     * @param rAttributes
     * @param principal
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteDetails(@PathVariable int id, Model model, RedirectAttributes rAttributes, Principal principal) {
        model.addAttribute("username", principal.getName());
        employeeService.delete(id);
        rAttributes.addFlashAttribute("message", "Successfully removed item");
        return "redirect:/employee/";
    }

    /**
     * This method is to display employee assign role
     *
     * @param model
     * @param principal
     * @return
     */
    @RequestMapping(value = "/assignrole", method = RequestMethod.GET)
    public String getAssignRole(Model model, Principal principal) {
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("roles", employeeService.getRoles());
//        String l = employeeService.getRoles().toString();
//        System.out.println(" error "+l);
        return "employee/assignrole";

    }

    /**
     * This method is to assign roles to employee either single or multiple
     * roles.
     *
     * @param json
     * @return
     * @throws IOException
     */
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

        employeeService.assignRole(empId, arrNode);

        return "{ message: 1 }";
        
    }
}
