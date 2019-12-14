package com.journal.journal.enity.science_publication_filter.service.interfaces;

import com.journal.journal.enity.science_publication_filter.model.Science_publication_filter;

import java.util.List;

public interface Science_publications_filter_service {
    List<Science_publication_filter> findAllByStudentId(int user_id);
}
