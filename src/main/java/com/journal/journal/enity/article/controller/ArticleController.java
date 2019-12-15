package com.journal.journal.enity.article.controller;

import com.journal.journal.enity.list_category.model.List_category;
import com.journal.journal.enity.list_category.service.interfaces.List_category_service;
import com.journal.journal.enity.napr_podg.model.Napr_podg;
import com.journal.journal.enity.napr_podg.service.interfaces.Napr_podg_service_interface;
import com.journal.journal.enity.teacher.model.Teacher;
import com.journal.journal.enity.teacher.service.interfaces.Teacher_service_interface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    private final
    Napr_podg_service_interface napr_podg_service_interface;

    private final
    Teacher_service_interface teacher_service_interface;

    private final
    List_category_service list_category_service;

    public ArticleController(Napr_podg_service_interface napr_podg_service_interface, Teacher_service_interface teacher_service_interface, List_category_service list_category_service) {
        this.napr_podg_service_interface = napr_podg_service_interface;
        this.teacher_service_interface = teacher_service_interface;
        this.list_category_service = list_category_service;
    }

    @PostMapping("/api/getTeacherListByNaprId")
    public List<Teacher> getTeacherListByNaprId(@RequestParam("id_napr") Integer id_napr){
        return teacher_service_interface.findAllByNaprId(id_napr);
    }

    @PostMapping("/api/getNaprList")
    public List<Napr_podg> getNaprList(){
        return napr_podg_service_interface.findAll();
    }

    @PostMapping("/api/getCategoryList")
    public List<List_category> getCategoryList(){
        return list_category_service.getAll();
    }
}
