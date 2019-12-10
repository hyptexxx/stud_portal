package com.journal.journal.enity.science_piblication.DAO.interfaces;

import com.journal.journal.enity.science_piblication.model.Science_publication;

import java.util.List;

public interface Science_publication_DAO_interface  {
    List<Science_publication> findAll();
    List<Science_publication> findAllByNr(int id_teacher);
    List<Science_publication> findAllByStudentId(int id_student);
    List<Science_publication> findAllByStudentAndNrId(int id_student, int id_teacher);
}
