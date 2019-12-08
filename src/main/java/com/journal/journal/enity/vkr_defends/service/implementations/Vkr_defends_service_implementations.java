package com.journal.journal.enity.vkr_defends.service.implementations;

import com.journal.journal.enity.vkr_defends.DAO.interfaces.Vkr_defends_DAO;
import com.journal.journal.enity.vkr_defends.model.Vkr_defends;
import com.journal.journal.enity.vkr_defends.service.interfaces.Vkr_defends_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vkr_defends_service_implementations implements Vkr_defends_service {
    private final
    Vkr_defends_DAO vkr_defends_dao;

    public Vkr_defends_service_implementations(Vkr_defends_DAO vkr_defends_dao) {
        this.vkr_defends_dao = vkr_defends_dao;
    }

    @Override
    public List<Vkr_defends> findAll() {
        return vkr_defends_dao.findAll();
    }
}
