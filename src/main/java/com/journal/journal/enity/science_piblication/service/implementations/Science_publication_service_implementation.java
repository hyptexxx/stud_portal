package com.journal.journal.enity.science_piblication.service.implementations;

import com.journal.journal.enity.science_piblication.DAO.interfaces.Science_publication_DAO_interface;
import com.journal.journal.enity.science_piblication.model.Science_publication;
import com.journal.journal.enity.science_piblication.service.interfaces.Science_publication_service_interface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Science_publication_service_implementation implements Science_publication_service_interface {

    private final
    Science_publication_DAO_interface science_publication_dao_interface;

    public Science_publication_service_implementation(Science_publication_DAO_interface science_publication_dao_interface) {
        this.science_publication_dao_interface = science_publication_dao_interface;
    }

    @Override
    public List<Science_publication> findAll() {
        return science_publication_dao_interface.findAll();
    }

    @Override
    public List<Science_publication> findAllByNr(int id_teacher) {
        return science_publication_dao_interface.findAllByNr(id_teacher);
    }

    @Override
    public List<Science_publication> findAllByStudentId(int id_student) {
        return science_publication_dao_interface.findAllByStudentId(id_student);
    }

    @Override
    public List<Science_publication> findAllByStudentAndNrId(int id_student, int id_teacher) {
        return science_publication_dao_interface.findAllByStudentAndNrId(id_student, id_teacher);
    }
}
