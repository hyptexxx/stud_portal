package com.journal.journal.enity.list_kafedr.service.implementations;

import com.journal.journal.enity.list_kafedr.DAO.interfaces.List_kafedr_DAO_interface;
import com.journal.journal.enity.list_kafedr.model.List_kafedr;
import com.journal.journal.enity.list_kafedr.service.interfaces.List_kafedr_service_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class List_kafedr_service_implementation implements List_kafedr_service_interface {

    private final
    List_kafedr_DAO_interface list_kafedr_dao_interface;

    public List_kafedr_service_implementation(List_kafedr_DAO_interface list_kafedr_dao_interface) {
        this.list_kafedr_dao_interface = list_kafedr_dao_interface;
    }

    @Override
    public List<List_kafedr> findAll() {
        return list_kafedr_dao_interface.findAll();
    }

    @Override
    public List<List_kafedr> findAllByTeacherId(int id_teacher) {
        return list_kafedr_dao_interface.findAllByTeacherId(id_teacher);
    }
}
