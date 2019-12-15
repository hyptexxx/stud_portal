package com.journal.journal.enity.teacher.service.interfaces;

import com.journal.journal.enity.teacher.model.Teacher;

import java.util.List;

public interface Teacher_service_interface {
    List<Teacher> findAll();
    List<Teacher> findAllByKafedrId(int id_kaf);
    List<Teacher> findAllByStudentId(int id_student);
    List<Teacher> findAllByNaprId(int id_napr);
}
