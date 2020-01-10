package com.journal.journal.controllers.main;

import com.journal.journal.enity.users.service.interfaces.Users_service_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMain(HttpSession httpSession){
        httpSession.setAttribute("page_type","main");
        return "Main";
    }

    @RequestMapping(value = "/defends", method = RequestMethod.GET)
    public String getDefends(HttpSession httpSession){
        httpSession.setAttribute("page_type","defends");
        return "Main";
    }

    @RequestMapping(value = "/publications", method = RequestMethod.GET)
    public String getPublications(HttpSession httpSession){
        httpSession.setAttribute("page_type","publications");
        return "Main";
    }
}
