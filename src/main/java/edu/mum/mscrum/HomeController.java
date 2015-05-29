package edu.mum.mscrum;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

     /**
     * Simply selects the home view to render by returning its name.
     * @param locale
     * @param model
     * @param principal
     * @return 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model, Principal principal) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //get logged in username

        model.addAttribute("username", principal.getName());

//        if (LocaleContextHolder.getLocale().getDisplayLanguage() =="English")
        model.addAttribute("lan",LocaleContextHolder.getLocale().getDisplayLanguage());
        return "home";
    }

    /**
     * This method is to display access denied page once get caught by security
     * @param model
     * @param principal
     * @return 
     */
    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String accessdeniedPage(Model model, Principal principal) {
        return "accessdenied";
    }

}
