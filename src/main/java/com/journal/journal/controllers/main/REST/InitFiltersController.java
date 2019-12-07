package com.journal.journal.controllers.main.REST;

import com.journal.journal.enity.list_kafedr.model.List_kafedr;
import com.journal.journal.enity.list_kafedr.service.interfaces.List_kafedr_service_interface;
import com.journal.journal.enity.napr_podg.model.Napr_podg;
import com.journal.journal.enity.napr_podg.service.interfaces.Napr_podg_service_interface;
import com.journal.journal.enity.teacher.model.Teacher;
import com.journal.journal.enity.teacher.service.interfaces.Teacher_service_interface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InitFiltersController {

    private final
    List_kafedr_service_interface list_kafedr_service_interface;

    private final
    Teacher_service_interface teacher_service_interface;

    public InitFiltersController(List_kafedr_service_interface list_kafedr_service_interface,
                                 Teacher_service_interface teacher_service_interface) {
        this.list_kafedr_service_interface = list_kafedr_service_interface;
        this.teacher_service_interface = teacher_service_interface;
    }


    @PostMapping(value = "/api/kaf")
    public List<List_kafedr> getkaf() {
        return list_kafedr_service_interface.findAll();
    }

    @PostMapping(value = "/api/nr")
    public List<Teacher> getNr() {
        return teacher_service_interface.findAll();
    }

}
