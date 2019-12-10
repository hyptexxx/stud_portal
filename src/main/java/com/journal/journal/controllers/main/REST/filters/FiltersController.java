package com.journal.journal.controllers.main.REST.filters;

import com.journal.journal.enity.article.model.Article;
import com.journal.journal.enity.article.service.interfaces.ArticleService;
import com.journal.journal.enity.list_kafedr.model.List_kafedr;
import com.journal.journal.enity.list_kafedr.service.interfaces.List_kafedr_service_interface;
import com.journal.journal.enity.science_piblication.model.Science_publication;
import com.journal.journal.enity.science_piblication.service.implementations.Science_publication_service_implementation;
import com.journal.journal.enity.science_piblication.service.interfaces.Science_publication_service_interface;
import com.journal.journal.enity.teacher.model.Teacher;
import com.journal.journal.enity.teacher.service.interfaces.Teacher_service_interface;
import com.journal.journal.enity.users.model.Users;
import com.journal.journal.enity.users.service.interfaces.Users_service_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FiltersController {
    private final
    List_kafedr_service_interface list_kafedr_service_interface;

    private final
    Teacher_service_interface teacher_service_interface;

    private final
    Users_service_interface users_service_interface;

    private final
    Science_publication_service_interface science_publication_service_interface;


    private final
    ArticleService articleService;

    public FiltersController(List_kafedr_service_interface list_kafedr_service_interface,
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

    @PostMapping("/api/doFilter")
    public List<Article> filter(@RequestParam("id_kaf") int id_kaf,
                                @RequestParam("id_teacher") int id_teacher) {
        List<Article> result = null;
        if (id_kaf < 0 && id_teacher < 0) {
            result = articleService.findAll();
        }
        if (id_kaf < 0 && id_teacher > 0) {
            result = articleService.findAllByNr(id_teacher);
        }
        if (id_kaf > 0 && id_teacher < 0) {
            result = articleService.findAllByKafId(id_kaf);
        }
        if (id_kaf > 0 && id_teacher > 0) {
            result = articleService.findAllByKafAndNrId(id_kaf, id_teacher);
        }
        return result;
    }

    @PostMapping("/api/doFilter/Publications")
    public List<Science_publication> filterPublications(@RequestParam("id_student") int id_student,
                                                        @RequestParam("id_teacher") int id_teacher) {
        List<Science_publication> result = null;
        if (id_student < 0 && id_teacher < 0) {
            result = science_publication_service_interface.findAll();
        }
        if (id_student < 0 && id_teacher > 0) {
            result = science_publication_service_interface.findAllByNr(id_teacher);
        }
        if (id_student > 0 && id_teacher < 0) {
            result = science_publication_service_interface.findAllByStudentId(id_student);
        }
        if (id_student > 0 && id_teacher > 0) {
            result = science_publication_service_interface.findAllByStudentAndNrId(id_student, id_teacher);
        }
        return result;
    }

    @PostMapping("/api/refreshFilterNr")
    public List<Teacher> refreshFilterNr(@RequestParam("id_kaf") int id_kaf,
                                         @RequestParam("id_teacher") int id_teacher) {
        return id_kaf < 0 ? teacher_service_interface.findAll() : teacher_service_interface.findAllByKafedrId(id_kaf);
    }

    @PostMapping("/api/refreshFilterKaf")
    public List<List_kafedr> refreshFilterKaf(@RequestParam("id_kaf") int id_kaf,
                                              @RequestParam("id_teacher") int id_teacher) {
        return id_teacher < 0 ? list_kafedr_service_interface.findAll() : list_kafedr_service_interface.findAllByTeacherId(id_teacher);
    }

    @PostMapping("/api/refreshFilterNr/Publications")
    public List<Teacher> refreshFilterNrPublications(@RequestParam("id_student") int id_student,
                                                     @RequestParam("id_teacher") int id_teacher) {
        return id_student < 0 ? teacher_service_interface.findAll() : teacher_service_interface.findAllByStudentId(id_student);
    }

    @PostMapping("/api/refreshFilterStudent/Publications")
    public List<Users> refreshFilterStudentPublications(@RequestParam("id_student") int id_student,
                                                        @RequestParam("id_teacher") int id_teacher) {
        return id_teacher < 0 ? users_service_interface.findAll() : users_service_interface.findAllByTeacherId(id_teacher);
    }
}
