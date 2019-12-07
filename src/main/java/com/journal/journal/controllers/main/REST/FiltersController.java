package com.journal.journal.controllers.main.REST;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FiltersController {


    @PostMapping("/api/doFilter")
    public List<String> filter(@RequestParam("id_kaf") int id_kaf,
                               @RequestParam("id_teacher") int id_teacher){
//        System.out.println(id_napr);
//        System.out.println(id_kaf);
//        System.out.println(id_teacher);
        return null;
    }

    @PostMapping("/api/refreshFilters")
    public List<String> refreshFilter(@RequestParam("id_kaf") int id_kaf,
                               @RequestParam("id_teacher") int id_teacher){
        System.out.println(id_kaf);
        System.out.println(id_teacher);
        return null;
    }
}
