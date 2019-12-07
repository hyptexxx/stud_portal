package com.journal.journal.enity.article.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Getter
    @Setter
    private int id_user;

    @Getter
    @Setter
    private String fio_user;

    @Getter
    @Setter
    private int id_teacher;

    @Getter
    @Setter
    private String fio_teacher;

    @Getter
    @Setter
    private int id_napr;

    @Getter
    @Setter
    private String name_napr;

    @Getter
    @Setter
    private int id_category;

    @Getter
    @Setter
    private String category;
}
