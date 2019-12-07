package com.journal.journal.enity.napr_podg.service.implementations;

import com.journal.journal.enity.napr_podg.DAO.interfaces.Napr_podg_DAO_interface;
import com.journal.journal.enity.napr_podg.model.Napr_podg;
import com.journal.journal.enity.napr_podg.service.interfaces.Napr_podg_service_interface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Napr_podg_service_implementation implements Napr_podg_service_interface {

    private final
    Napr_podg_DAO_interface napr_podg_dao_interface;

    public Napr_podg_service_implementation(Napr_podg_DAO_interface napr_podg_dao_interface) {
        this.napr_podg_dao_interface = napr_podg_dao_interface;
    }

    @Override
    public List<Napr_podg> findAll() {
        return napr_podg_dao_interface.findAll();
    }
}
