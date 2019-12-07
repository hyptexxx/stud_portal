package com.journal.journal.controllers.main;

import com.journal.journal.enity.list_category.model.List_category;
import com.journal.journal.enity.list_category.service.implementations.List_category_service_implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    List_category_service_implementation list_category_service_implementation;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMain(HttpSession httpSession){
        httpSession.setAttribute("list",list_category_service_implementation.getAll());
        return "Main";
    }

//    @RequestMapping(value = "/api/category", method = RequestMethod.POST)
//    @ResponseBody
//    public List<List_category> test(HttpSession httpSession){
//        return list_category_service_implementation.getAll();
//    }


}
