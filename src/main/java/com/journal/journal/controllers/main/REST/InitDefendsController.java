package com.journal.journal.controllers.main.REST;

import com.journal.journal.enity.vkr_defends.model.Vkr_defends;
import com.journal.journal.enity.vkr_defends.service.interfaces.Vkr_defends_service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InitDefendsController {

    private final
    Vkr_defends_service vkr_defends_service;

    public InitDefendsController(Vkr_defends_service vkr_defends_service) {
        this.vkr_defends_service = vkr_defends_service;
    }

    @PostMapping(value = "/api/getDefends")
    public List<Vkr_defends> getDefends() {
        return vkr_defends_service.findAll();
    }


}
