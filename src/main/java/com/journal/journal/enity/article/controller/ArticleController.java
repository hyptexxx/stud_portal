package com.journal.journal.enity.article.controller;

import com.journal.journal.enity.list_category.model.List_category;
import com.journal.journal.enity.list_category.service.interfaces.List_category_service;
import com.journal.journal.enity.napr_podg.model.Napr_podg;
import com.journal.journal.enity.napr_podg.service.interfaces.Napr_podg_service_interface;
import com.journal.journal.enity.teacher.model.Teacher;
import com.journal.journal.enity.teacher.service.interfaces.Teacher_service_interface;
import com.journal.journal.enity.users.service.interfaces.Users_service_interface;
import com.journal.journal.enity.vkr.service.interfaces.Vkr_service_interface;
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

    private final
    Users_service_interface users_service_interface;

    private final
    Vkr_service_interface vkr_service_interface;

    public ArticleController(Napr_podg_service_interface napr_podg_service_interface, Teacher_service_interface teacher_service_interface, List_category_service list_category_service, Users_service_interface users_service_interface, Vkr_service_interface vkr_service_interface) {
        this.napr_podg_service_interface = napr_podg_service_interface;
        this.teacher_service_interface = teacher_service_interface;
        this.list_category_service = list_category_service;
        this.users_service_interface = users_service_interface;
        this.vkr_service_interface = vkr_service_interface;
    }

    @PostMapping("/api/getTeacherListByNaprId")
    public List<Teacher> getTeacherListByNaprId(@RequestParam("id_napr") Integer id_napr) {
        return teacher_service_interface.findAllByNaprId(id_napr);
    }

    @PostMapping("/api/getNaprList")
    public List<Napr_podg> getNaprList() {
        return napr_podg_service_interface.findAll();
    }

    @PostMapping("/api/getCategoryList")
    public List<List_category> getCategoryList() {
        return list_category_service.getAll();
    }


    @PostMapping("/api/setArticle")
    public String setArticle(@RequestParam("fio") String fio,
                             @RequestParam("teacher") int teacher,
                             @RequestParam("napr") int napr,
                             @RequestParam("category") int category,
                             @RequestParam("user_id") int user_id) {
        users_service_interface.updateUserByUserId(fio, napr, category, user_id);
        vkr_service_interface.updateVkrByUserId(user_id, teacher);
        return "true";
    }

}
