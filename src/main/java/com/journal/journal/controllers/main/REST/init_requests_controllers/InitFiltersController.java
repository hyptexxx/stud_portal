package com.journal.journal.controllers.main.REST.init_requests_controllers;

import com.journal.journal.enity.article.model.Article;
import com.journal.journal.enity.article.service.interfaces.ArticleService;
import com.journal.journal.enity.list_kafedr.model.List_kafedr;
import com.journal.journal.enity.list_kafedr.service.interfaces.List_kafedr_service_interface;
import com.journal.journal.enity.science_piblication.model.Science_publication;
import com.journal.journal.enity.science_piblication.service.interfaces.Science_publication_service_interface;
import com.journal.journal.enity.teacher.model.Teacher;
import com.journal.journal.enity.teacher.service.interfaces.Teacher_service_interface;
import com.journal.journal.enity.users.model.Users;
import com.journal.journal.enity.users.service.interfaces.Users_service_interface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InitFiltersController {

    private final
    List_kafedr_service_interface list_kafedr_service_interface;

    private final
    Teacher_service_interface teacher_service_interface;

    private final
    ArticleService articleService;

    private final
    Users_service_interface users_service_interface;

    private final
    Science_publication_service_interface science_publication_service_interface;

    public InitFiltersController(List_kafedr_service_interface list_kafedr_service_interface,
                                 Teacher_service_interface teacher_service_interface,
                                 ArticleService articleService,
                                 Users_service_interface users_service_interface,
                                 Science_publication_service_interface science_publication_service_interface) {
        this.list_kafedr_service_interface = list_kafedr_service_interface;
        this.teacher_service_interface = teacher_service_interface;
        this.articleService = articleService;
        this.users_service_interface = users_service_interface;
        this.science_publication_service_interface = science_publication_service_interface;
    }

    @PostMapping(value = "/api/kaf")
    public List<List_kafedr> getkaf() {
        return list_kafedr_service_interface.findAll();
    }

    @PostMapping(value = "/api/getNr")
    public List<Teacher> getNr() {
        return teacher_service_interface.findAll();
    }

    @PostMapping(value = "/api/getAllStudents")
    public List<Users> getStudents() {
        return users_service_interface.findAll();
    }

    @PostMapping("/api/getAllArticles")
    public List<Article> getAllArticles() {
        return articleService.findAll();
    }

    @PostMapping("/api/getAllPublications")
    public List<Science_publication> getAllPublications() {
        return science_publication_service_interface.findAll();
    }


}
