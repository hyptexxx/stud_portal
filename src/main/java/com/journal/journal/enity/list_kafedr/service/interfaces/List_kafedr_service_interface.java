package com.journal.journal.enity.list_kafedr.service.interfaces;

import com.journal.journal.enity.list_kafedr.model.List_kafedr;
import com.journal.journal.enity.teacher.model.Teacher;

import java.util.List;

public interface List_kafedr_service_interface {
    List<List_kafedr> findAll();
    List<List_kafedr> findAllByTeacherId(int id_teacher);
}
