package com.journal.journal.enity.science_publication_filter.service.implementations;

import com.journal.journal.enity.science_publication_filter.DAO.interfaces.Science_publications_filter_DAO;
import com.journal.journal.enity.science_publication_filter.model.Science_publication_filter;
import com.journal.journal.enity.science_publication_filter.service.interfaces.Science_publications_filter_service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Science_publications_filter_service_implementation implements Science_publications_filter_service {

    private final
    Science_publications_filter_DAO science_publications_filter_dao;

    public Science_publications_filter_service_implementation(Science_publications_filter_DAO science_publications_filter_dao) {
        this.science_publications_filter_dao = science_publications_filter_dao;
    }

    @Override
    public List<Science_publication_filter> findAllByStudentId(int user_id) {
        return science_publications_filter_dao.findAllByStudentId(user_id);
    }
}
