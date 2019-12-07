package com.journal.journal.enity.list_kafedr.DAO.interfaces;

import com.journal.journal.enity.list_kafedr.model.List_kafedr;

import java.util.List;

public interface List_kafedr_DAO_interface {
    List<List_kafedr> findAll();
    List<List_kafedr> findAllByTeacherId(int id_teacher);
}
