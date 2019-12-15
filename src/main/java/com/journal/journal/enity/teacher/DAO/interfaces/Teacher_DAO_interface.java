package com.journal.journal.enity.teacher.DAO.interfaces;

import com.journal.journal.enity.teacher.model.Teacher;

import java.util.List;

public interface Teacher_DAO_interface {
    List<Teacher> findAll();
    List<Teacher> findAllByKafedrId(int id_teacher);
    List<Teacher> findAllByStudentId(int id_student);
    List<Teacher> findAllByNaprId(int id_napr);
}
