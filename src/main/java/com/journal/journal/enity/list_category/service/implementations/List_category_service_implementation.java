package com.journal.journal.enity.list_category.service.implementations;

import com.journal.journal.enity.list_category.DAO.interfaces.List_category_DAO;
import com.journal.journal.enity.list_category.model.List_category;
import com.journal.journal.enity.list_category.service.interfaces.List_category_service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class List_category_service_implementation implements List_category_service {

    private final
    List_category_DAO list_category_dao;

    public List_category_service_implementation(List_category_DAO list_category_dao) {
        this.list_category_dao = list_category_dao;
    }

    @Override
    public List<List_category> getAll() {
        return list_category_dao.getAll();
    }
}
