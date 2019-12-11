package com.journal.journal.enity.science_piblication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="science_publication")
public class Science_publication {

    @Id
    @GeneratedValue
    @Column(name = "id_science_publication")
    private int id_science_publication;

    @Column(name = "name")
    private String name;

    @Column(name = "text")
    private String text;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "teacher_id")
    private Integer teacher_id;
}
