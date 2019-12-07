package com.journal.journal.controllers.main.REST;

import com.journal.journal.enity.list_kafedr.model.List_kafedr;
import com.journal.journal.enity.list_kafedr.service.interfaces.List_kafedr_service_interface;
import com.journal.journal.enity.teacher.model.Teacher;
import com.journal.journal.enity.teacher.service.interfaces.Teacher_service_interface;
import com.journal.journal.enity.users.service.interfaces.Users_service_interface;
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

    public FiltersController(List_kafedr_service_interface list_kafedr_service_interface,
                             Teacher_service_interface teacher_service_interface,
                             Users_service_interface users_service_interface) {
        this.list_kafedr_service_interface = list_kafedr_service_interface;
        this.teacher_service_interface = teacher_service_interface;
        this.users_service_interface = users_service_interface;
    }

    @PostMapping("/api/doFilter")
    public List<String> filter(@RequestParam("id_kaf") int id_kaf,
                               @RequestParam("id_teacher") int id_teacher) {
        System.out.println(id_kaf);
        System.out.println(id_teacher);
        return null;
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
}
