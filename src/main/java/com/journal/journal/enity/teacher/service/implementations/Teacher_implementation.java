package com.journal.journal.enity.teacher.service.implementations;

import com.journal.journal.enity.teacher.DAO.interfaces.Teacher_DAO_interface;
import com.journal.journal.enity.teacher.model.Teacher;
import com.journal.journal.enity.teacher.service.interfaces.Teacher_service_interface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Teacher_implementation implements Teacher_service_interface {

    private final
    Teacher_DAO_interface teacher_dao_interface;

    public Teacher_implementation(Teacher_DAO_interface teacher_dao_interface) {
        this.teacher_dao_interface = teacher_dao_interface;
    }


    @Override
    public List<Teacher> findAll() {
        return teacher_dao_interface.findAll();
    }

    @Override
    public List<Teacher> findAllByKafedrId(int id_kaf) {
        return teacher_dao_interface.findAllByKafedrId(id_kaf);
    }

    @Override
    public List<Teacher> findAllByStudentId(int id_student) {
        return teacher_dao_interface.findAllByStudentId(id_student);
    }
}
