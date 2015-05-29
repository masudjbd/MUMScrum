package edu.mum.mscrum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller is to display login, login failed, and logout page
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Controller
public class LoginController {

    /**
     * This method is to display custom login page
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * This method is to display login failed page
     * @param model
     * @return 
     */
    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        return "login";
    }

    /**
     * This method is to display logout page.
     * @param model
     * @return 
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        return "login";
    }
}
